package com.greenuniv.greenuniv.controller.article;

import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.comment.CommentDTO;
import com.greenuniv.greenuniv.internal.Pagination;
import com.greenuniv.greenuniv.service.GenericService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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


  private final GenericService<ArticleDTO, Integer> articleService;
  private final GenericService<CommentDTO, Integer> commentService;

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
    pagination.setCurrentPage(page);

    log.info("Incoming request for /article?{}&{} has been detected", category, page);

    if (page < 1) { // page query param 유효성 검증
      model.addAttribute("error", "Bad Request");
      return "/error/error";
    }

    long articleCount = articleService.countBy("category", category);

    if (page > 1 && articleCount <= 10) { // page query param 유효성 검증
      model.addAttribute("error", "Bad Request. Insufficient items");
      return "/error/error";
    }

    pagination.setItemsCount(articleCount);

    int offset = pagination.itemOffset();
    int limit = pagination.itemLimit();
    List<ArticleDTO> articles = articleService.findByLimit(offset, limit, "category", category);

    model.addAttribute("articles", articles);
    model.addAttribute("pagination", pagination);

    String templatePath = String.format("/community/%s", category);
    log.info("Retrieving page for {}...", templatePath);

    return templatePath;
  }

  @PostMapping("")
  public String publish() {
    return "";
  }

  /**
   * A URL mapping for viewing specific article
   *
   * @param id article id
   * @return Path to template
   */
  @GetMapping("/view")
  public String view(@RequestParam String id) {
    return "";
  }

}
