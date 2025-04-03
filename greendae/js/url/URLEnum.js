/**
 * 작성자: id3ntity99(이현민)
 * 설명: 서버로의 요청에 사용되는 URL들을 모아 놓은 클래스
 */
export default class URLEnum {
  // 클래스 속성 필드. 아래에 사용된 URL은 placeholder(가짜)이므로 실제 URL로 변경할 것.

  constructor() {
    // 비어있는 생성자
  }

  _SEARCH_URL = "/SEARCH"; //커뮤니티 페이지의 검색 버튼 클릭에 사용되는 URL

  _PAGE_URL = "/PAGINATION"; // 페이지 버튼 클릭에 사용되는 URL

  _REGISTER_LECTURE_URL = "/LECTURE/REGISTER"; // 수강신청의 신청 버튼 클릭에 사용되는 URL
  _CANCEL_LECTURE_REGISTER_URL = "/LECTURE/CANCEL"; // 수강신청내역 페이지에서 취소 버튼 클릭에 사용되는 URL

  _SCORE_DETAIL_URL = "/STUDENT/SCORE/DETAIL"; // 성적 페이지에서 상세보기 버튼 클릭에 사용되는 URL

  _ARTICLE_PUBLISH_URL = "/article/publish";
  _ARTICLE_MODIFY_URL = "/article/modify";
  _ARTICLE_DELETE_URL = "/article/delete";

  /**
   * getter 메서드. URL을 사용하고자 할 때에는 반드시 getter 메서드를 호출할 것.
   *
   * getter 메서드 호출 예시:
   * const enum = new URLEnum();
   * const searchUrl = enum.searchURL();
   */
  get searchURL() {
    return this._SEARCH_URL;
  }

  get pageURL() {
    return this._PAGE_URL;
  }

  get registerLectureURL() {
    return this._REGISTER_LECTURE_URL;
  }

  get cancelLectureRegisterURL() {
    return this._CANCEL_LECTURE_REGISTER_URL;
  }

  get scoreDetailURL() {
    return this._SCORE_DETAIL_URL;
  }

  get articlePublishURL() {
    return this._ARTICLE_PUBLISH_URL;
  }
}
