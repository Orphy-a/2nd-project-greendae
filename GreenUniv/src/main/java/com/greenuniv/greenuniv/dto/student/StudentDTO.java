package com.greenuniv.greenuniv.dto.student;

/*-
 * - 작성자: id3ntity99(이현민)
 * - 설명 :
 *    학생 정보를 저장하는 DTO.
 *    StudentDTOBuilder는 Builder 어노테이션에 의해 생성된 Builder 클래스의 build() 메서드를
 *    오버라이드 하기 위해 만듦.
 */

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.dto.department.DepartmentDTO;
import com.greenuniv.greenuniv.dto.image.ImageDTO;
import com.greenuniv.greenuniv.dto.professor.ProfessorDTO;
import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.student.StudentEntity;
import java.time.Year;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements BaseDTO {

  public static final String STATUS_IN = "in";
  public static final String STATUS_GRADUATED = "grad";
  public static final String STATUS_BREAK = "break";
  public static final String[] STATUSES = {STATUS_IN, STATUS_GRADUATED, STATUS_BREAK};

  public static final String ENTRANCE_TYPE_REGULAR = "regular";
  public static final String ENTRANCE_TYPE_ROLLING = "rolling";
  public static final String[] ENTRANCE_TYPES = {ENTRANCE_TYPE_REGULAR, ENTRANCE_TYPE_ROLLING};

  private String studentNumber;
  private UserDTO user;
  private DepartmentDTO department;
  private ImageDTO image;
  private int grade;
  private int semester;
  private int currentCredit;
  private int graduationCredit;
  private String status;
  private String entranceType;
  private Year entranceYear;
  private int entranceGrade;
  private int entranceSemester;
  private Year graduationYear;
  private ProfessorDTO supervisorProfessor;

  @Override
  public StudentEntity toEntity() {
    return StudentEntity.builder()
        .studentNumber(studentNumber)
        .user(user.toEntity())
        .department(department.toEntity())
        .image(image.toEntity())
        .grade(grade)
        .semester(semester)
        .currentCredit(currentCredit)
        .graduationCredit(graduationCredit)
        .status(status)
        .entranceType(entranceType)
        .entranceYear(entranceYear)
        .entranceGrade(entranceGrade)
        .entranceSemester(entranceSemester)
        .graduationYear(graduationYear)
        .supervisorProfessor(supervisorProfessor.toEntity())
        .build();
  }

  public static class StudentDTOBuilder {

    public StudentDTO build() throws IllegalArgumentException {
      if (status != null || entranceType != null) {
        boolean isStatusLegal = Arrays.asList(STATUSES).contains(status);
        boolean isEntranceTypeLegal = Arrays.asList(ENTRANCE_TYPES).contains(entranceType);
        if (!isStatusLegal) {
          throw new IllegalArgumentException("유효하지 않은 상태: " + status);
        } else if (!isEntranceTypeLegal) {

          throw new IllegalArgumentException("유효하지 않은 입학유형: " + entranceType);
        }
      }

      return new StudentDTO(studentNumber, user, department, image, grade, semester, currentCredit,
          graduationCredit,
          status, entranceType, entranceYear, entranceGrade, entranceSemester, graduationYear,
          supervisorProfessor);
    }
  }
}
