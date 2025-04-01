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
   * number should be 10.
   */
  public static final int PAGE_LIMIT = 10;

  /**
   * Max number of items to be displayed per page.
   */
  public static final int MAX_ITEM_PER_PAGE = 10;

  /**
   * Current page number
   */
  private int currentPage = 0;

  private long itemsCount;

  public Pagination(int offset, int itemsCount) {
    this.currentPage = (offset - 1) * MAX_ITEM_PER_PAGE;
    this.itemsCount = itemsCount;
  }

  /**
   * Get a number of end page.
   *
   * @return Number of end page number
   */
  public int getEndPage() {
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
  public int itemLimit() {
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
  public int itemOffset() {
    return (currentPage - 1) * MAX_ITEM_PER_PAGE;
  }
}
