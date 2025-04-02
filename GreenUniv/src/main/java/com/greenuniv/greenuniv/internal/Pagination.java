package com.greenuniv.greenuniv.internal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/*
 *  작성자: id3ntity99(이현민)
 */

@Getter
@Setter
@Component
@NoArgsConstructor
public class Pagination {

  /**
   * Max number of pages to be displayed. For example, if current number of page is 1, then the max
   * number should be 10. </br> 페이지 내에서 보여질 페이지의 최대 개수. PAGE_LIMIT 값이 10일 경우, 현재 페이지 + 10 만큼의 페이지.
   */
  public static final int PAGE_LIMIT = 10;

  /**
   * Max number of items to be displayed per page. <br> 한 페이지 내에서 보여지는 아이템들의 최대 개수. article을 예로 들면,
   * 현재 페이지가 1일때, 1번 페이지에 보여지는 article의 수는 총 10개.
   */
  public static final int MAX_ITEM_PER_PAGE = 10;

  /**
   * Current page number
   * <br>
   * 현재 페이지 값
   */
  private int currentPage = 0;

  private long itemsCount;

  public Pagination(int currentPage, long itemsCount) {
    this.currentPage = currentPage;
    this.itemsCount = itemsCount;
  }

  /**
   * Get a number of end page.
   * <br>
   * 화면에 표시될 가장 마지막 페이지 값을 계산해준다.
   *
   * @return Number of end page number
   */
  public int endPage() {
    int endPageNumber = 1;
    if (itemsCount > MAX_ITEM_PER_PAGE) {
      endPageNumber = (int) Math.ceil(itemsCount / (double) MAX_ITEM_PER_PAGE);

      if (endPageNumber > PAGE_LIMIT) {
        endPageNumber = PAGE_LIMIT;
      }
    }
    return endPageNumber;
  }

  /**
   * Calculates how many items should be retrieved from database. The return value of this method
   * will be used at SQL `LIMIT` statement
   *
   * @return Total number of items that should be retrieved from the database.
   */
  public int limit() {
    long maxItems = (long) PAGE_LIMIT * MAX_ITEM_PER_PAGE;
    if (itemsCount > maxItems) {// 전체 아이템의 수가 표시 가능한 최대 아이템 개수를 초과할 경우.

      return (int) maxItems; // 최대 아이템 개수를 반환.
    }

    // 전체 아이템의 개수가 표시 가능한 최대 아이템 개수 이하일 경우, 전체 아이탬의 개수를 반환.
    return (int) itemsCount;
  }

  /**
   * This method calculates the starting index of items. The return value of this method will be
   * used at SQL `OFFSET` statement
   */
  public int offset() {
    return (currentPage - 1) * MAX_ITEM_PER_PAGE;
  }
}
