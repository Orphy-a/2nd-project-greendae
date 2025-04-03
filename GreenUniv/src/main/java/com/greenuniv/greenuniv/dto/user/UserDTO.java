package com.greenuniv.greenuniv.dto.user;

import com.greenuniv.greenuniv.dto.BaseDTO;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements BaseDTO {

  public static final String GENDER_MALE = "m";
  public static final String GENDER_FEMALE = "f";
  public static final String[] GENDERS = {GENDER_MALE, GENDER_FEMALE};

  public static final String ROLE_GENERAL = "general";
  public static final String ROLE_PROF = "professor";
  public static final String ROLE_STUDENT = "student";
  public static final String ROLE_ADMIN = "admin";
  public static final String[] ROLES = {ROLE_PROF, ROLE_STUDENT, ROLE_ADMIN};

  private String id;
  private String password;
  private String name;
  private String engName;
  private String gender;
  private String nationality;
  private String socialNumber;
  private String email;
  private String contact;
  private String zip;
  private String address;
  private String addressDetail;
  private UserEntity.Role role;
  private boolean agreedTerms;
  @CreationTimestamp
  private LocalDateTime registerDate;
  private LocalDateTime leaveDate;

  public UserDTO(String name) {
    this.name = name;
  }


  @Override
  public UserEntity toEntity() {
    return UserEntity.builder()
        .id(id)
        .password(password)
        .name(name)
        .eng_Name(engName)
        .gender(gender)
        .nationality(nationality)
        .socialNumber(socialNumber)
        .email(email)
        .contact(contact)
        .zip(zip)
        .address(address)
        .address_detail(addressDetail)
        .role(role)
        .agreedTerms(agreedTerms)
        .registerDate(registerDate)
        .leaveDate(leaveDate)
        .build();
  }

  public static class UserDTOBuilder {

    public UserDTO build() throws IllegalArgumentException {
      if (gender != null || role != null) {
        boolean isGenderLegal = Arrays.asList(GENDERS).contains(gender);
        boolean isRoleLegal = Arrays.asList(ROLES).contains(role);

        if (!isGenderLegal) {
          String message = String.format("유효하지 않은 성별([%s]): %s", Arrays.toString(GENDERS), gender);
          throw new IllegalArgumentException(message);
        } else if (!isRoleLegal) {
          String message = String.format("유효하지 않은 사용자 유형([%s]): %s", Arrays.toString(ROLES), role);
          throw new IllegalArgumentException(message);
        }
      }
      return new UserDTO(id, password, name, engName, gender, nationality, socialNumber, email,
          contact, zip, address, addressDetail, role, agreedTerms, registerDate, leaveDate);
    }
  }
}
