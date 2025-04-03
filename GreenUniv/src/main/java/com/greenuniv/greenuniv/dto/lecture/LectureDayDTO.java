package com.greenuniv.greenuniv.dto.lecture;

/*-
 * - 작성자: id3ntity99(이현민)
 * - 설명 :
 *    강의 시간 데이터를 저장하는 DTO.
 *    LectureDayDTOBuilder는 Builder 어노테이션에 의해 생성된 Builder 클래스의 build() 메서드를
 *    오버라이드 하기 위해 만듦.
 */

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.lecture.LectureDayEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LectureDayDTO implements BaseDTO {

  public static final String MONDAY = "mon";
  public static final String TUESDAY = "tue";
  public static final String WEDNESDAY = "wed";
  public static final String THURSDAY = "thur";
  public static final String FRIDAY = "fri";
  public static final String[] WEEK_DAYS = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY};

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String day;

  @Override
  public LectureDayEntity toEntity() {
    return LectureDayEntity.builder()
        .id(id)
        .day(day)
        .build();
  }

  public static class LectureDayDTOBuilder {

    public LectureDayDTO build() throws IllegalArgumentException {
      if (day != null) {
        boolean isLegal = Arrays.asList(LectureDayDTO.WEEK_DAYS).contains(day);
        if (!isLegal) {
          throw new IllegalArgumentException("유효하지 않은 요일: " + day);
        }
      }

      return new LectureDayDTO(id, day);
    }
  }
}
