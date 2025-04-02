package com.greenuniv.greenuniv.controller.article;

import com.greenuniv.greenuniv.dao.mapper.GenericMapper;
import com.greenuniv.greenuniv.dto.article.ArticleDTO;
import com.greenuniv.greenuniv.dto.article.QnaDTO;
import com.greenuniv.greenuniv.internal.Pagination;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article/qna")
@RequiredArgsConstructor
public class QnaController {

  private final GenericMapper<QnaDTO, Integer> mapper;

  @GetMapping("")
  public String list(@RequestParam(required = false, defaultValue = "1") int page, Model model) {
    if (page <= 0) {
      model.addAttribute("error", "Invalid page number");
      return "/error/error";
    }

    long count = mapper.count();
    Pagination pagination = new Pagination(page, count);
    pagination.setCurrentPage(page);
    pagination.setItemsCount(count);

    int offset = pagination.offset();
    int limit = pagination.limit();

    List<QnaDTO> articles = mapper.selectLimit(offset, limit);

    model.addAttribute("articles", articles);
    model.addAttribute("pagination", pagination);

    return "/community/qna";
  }

  @GetMapping("/answer")
  public String reply(@RequestParam String qid, Model model) {
    // TODO 1. Retrieve question article data that is associated with id request parameter.
    // TODO 2. Add retrieved question article DTO to model attributes.
    return "";
  }

  @PostMapping("/answer")
  public String reply(@RequestParam String qid, ArticleDTO article) {
    // TODO 3. INSERT question article's id into reply_article
    // TODO 4. INSERT answer article's id into article table
    // TODO 5. INSERT answer article's id into reply_article.id
    return "";
  }
}
