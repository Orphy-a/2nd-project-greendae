package com.greenuniv.greenuniv.controller.article;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import com.greenuniv.greenuniv.internal.Pagination;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 *  작성자: id3ntity99(이현민)
 */

@Slf4j
@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

  private final GenericMapper<ArticleDTO, Integer> articleMapper;
  private final GenericMapper<CommentDTO, Integer> commentMapper;

  private final Pagination pagination;

  /**
   * @param category
   * @param page
   * @param model
   * @return
   */
  @GetMapping("") // == /article
  public String list(@RequestParam String category,
      @RequestParam(required = false, defaultValue = "1") int page,
      Model model) {
    log.info("Incoming request for /article?{}&{} has been detected", category, page);
    if (category.equals("qna")) {
      return "redirect:/qna";
    }

    // 페이지 및 필요한 article 개수 계산
    pagination.setCurrentPage(page);
    if (page < 1) { // page query param 유효성 검증
      model.addAttribute("error", "Bad Request");
      return "/error/error";
    }

    long articleCount = articleMapper.countBy("category", category);

    if (page > 1 && articleCount <= 10) { // page query param 유효성 검증
      model.addAttribute("error", "Bad Request. Insufficient items");
      return "/error/error";
    }

    pagination.setItemsCount(articleCount);
    int offset = pagination.offset();
    int limit = pagination.limit();

    // 계산된 필요한 개수의 article SELECT
    List<ArticleDTO> articles = articleMapper.selectByLimit(offset, limit, "category", category);

    model.addAttribute("category", category);
    model.addAttribute("articles", articles);
    model.addAttribute("pagination", pagination);

    String templatePath = String.format("/community/%s", category);
    log.info("Retrieving page for {}...", templatePath);

    return templatePath;
  }

  /**
   * A URL mapping for viewing specific article
   *
   * @param id article id
   * @return Path to template
   */
  @GetMapping("/view")
  public String view(@RequestParam int id, Model model, HttpServletRequest request) {

    String uri = request.getRequestURI();

    // 특정 게시물과 그 게시물의 댓글 조회
    ArticleDTO article = articleMapper.selectById(id);
    List<CommentDTO> comments = commentMapper.selectAllBy("article_id", id);

    // 게시물 조회수 조회
    int view = article.getView();
    articleMapper.updateByIdWhere(article.getId(), "view", ++view);
    article.setView(view);

    // 현재 접속한 사용자 객체 가져오기
    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    try {
      if (obj instanceof UserDetails currentUser) {
        model.addAttribute("currentUser", currentUser);
      }
    } catch (NullPointerException e) {
      model.addAttribute("error", e.getMessage());
      return "/error/error";
    }

    model.addAttribute("article", article);
    model.addAttribute("comments", comments);
    model.addAttribute("uri", uri);
    return "/community/view";
  }

  @PostMapping("/publish")
  public String publish(@RequestParam String category,
      @RequestParam(required = false) String status, @RequestBody String json) {

    return "/community/publish";
  }

  @PostMapping("/modify")
  public String modify(@RequestParam String id, @RequestBody String json) {

    return "/community/edit";
  }

  @PostMapping("/delete")
  public String delete(@RequestParam int id, @RequestParam String category) {
    articleMapper.deleteById(id);

    return "redirect:/article?category=" + category;
  }
}
