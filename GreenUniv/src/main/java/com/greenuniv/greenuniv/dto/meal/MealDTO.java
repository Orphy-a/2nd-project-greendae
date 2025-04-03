package com.greenuniv.greenuniv.dto.meal;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.menu.MenuDTO;
import com.greenuniv.greenuniv.entity.meal.MealEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO implements BaseDTO {

  public static final String BREAKFAST = "breakfast";
  public static final String LUNCH = "lunch";
  public static final String DINNER = "dinner";
  public static final String[] MEAL_TIME = {BREAKFAST, LUNCH, DINNER};

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private MenuDTO menu;
  private LocalDate date;
  private String mealTime;

  @Override
  public MealEntity toEntity() {
    return MealEntity.builder()
        .id(id)
        .menu(menu.toEntity())
        .date(date)
        .mealTime(mealTime)
        .build();
  }

  public static class MealDTOBuilder {

    public MealDTO build() throws IllegalArgumentException {
      if(mealTime != null) {
        boolean isLegal = Arrays.asList(MealDTO.MEAL_TIME).contains(mealTime);
        if (!isLegal) {
          throw new IllegalArgumentException("유효하지 않은 식사 시간: " + mealTime);
        }
      }
      return new MealDTO(id, menu, date, mealTime);
    }
  }
}
