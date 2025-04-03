package com.greenuniv.greenuniv.dto.professor;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
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
public class ProfessorDTO implements BaseDTO {

  public static final String DEGREE_MASTER = "master";
  public static final String DEGREE_PHD = "phd";
  public static final String[] DEGREES = {DEGREE_MASTER, DEGREE_PHD};

  public static final String STATUS_IN = "in";
  public static final String STATUS_OUT = "out";
  public static final String STATUS_BREAK = "break";
  public static final String[] STATUSES = {STATUS_IN, STATUS_OUT, STATUS_BREAK};

  public static final String POSITION_FULL = "full";
  public static final String POSITION_ASSOCIATE = "assoc";
  public static final String POSITION_ASSIST = "asst";
  public static final String[] POSITIONS = {POSITION_FULL, POSITION_ASSOCIATE, POSITION_ASSIST};

  private String id;
  private UserDTO user;
  private DepartmentDTO department;
  private String graduatedFrom;
  private LocalDate graduatedAt;
  private String major;
  private String degree;
  private LocalDate employedAt;
  private String status;
  private String position;
  private boolean isChief;


    @Override
  public ProfessorEntity toEntity() {
    return ProfessorEntity.builder()
        .id(id)
        .user(user.toEntity())
        .department(department.toEntity())
        .graduatedFrom(graduatedFrom)
        .graduatedAt(graduatedAt)
        .major(major)
        .degree(degree)
        .employedAt(employedAt)
        .status(status)
        .position(position)
        .isChief(isChief)
        .build();
  }

  public static class ProfessorDTOBuilder {

    private boolean isLegal(String[] matcher, String input) {
      return Arrays.asList(matcher).contains(input);
    }

    public ProfessorDTO build() throws IllegalArgumentException {
      if (degree != null || status != null || position != null) {
        boolean isDegreeLegal = isLegal(DEGREES, degree);
        boolean isStatusLegal = isLegal(STATUSES, status);
        boolean isPositionLegal = isLegal(POSITIONS, position);

        if (!isDegreeLegal) {
          String message = String.format("유효하지 않은 교수 학위([%s]): %s", Arrays.toString(DEGREES),
                  degree);
          throw new IllegalArgumentException(message);
        } else if (!isStatusLegal) {
          String message = String.format("유효하지 않은 교수 상태([%s]): %s", Arrays.toString(STATUSES),
                  status);
          throw new IllegalArgumentException(message);
        } else if (isPositionLegal) {
          String message = String.format("유효하지 않은 교수 직위([%s]): %s", Arrays.toString(POSITIONS),
                  position);
          throw new IllegalArgumentException(message);
        }
      }

      return new ProfessorDTO(id, user, department, graduatedFrom, graduatedAt, major, degree,
          employedAt, status, position, isChief);
    }
  }
}
