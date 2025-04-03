package com.greenuniv.greenuniv.entity.user;

import com.greenuniv.greenuniv.dto.user.UserDTO;
import com.greenuniv.greenuniv.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@ToString
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements BaseEntity {

  //TODO: Impl this
  @Id
  private String id;

  @Column(name = "password")
  private String password;

  @Column(name = "name")
  private String name;

  private String eng_Name;
  private String gender;
  private String nationality;

  @Column(name = "social_number")
  private String socialNumber;

  @Column(name = "email")
  private String email;

  @Column(name = "contact")
  private String contact;

  @Column(name = "zip")
  private String zip;

  @Column(name = "address")
  private String address;

  @Column(name = "address_detail")
  private String address_detail;

  // string -> enum 타입 수정
  @Enumerated(EnumType.STRING)
  private UserEntity.Role role;

  @Column(name = "agreed_terms")
  private boolean agreedTerms;

  @Column(name = "register_date")
  @CreationTimestamp
  private LocalDateTime registerDate;

  @Column(name = "leave_date")
  private LocalDateTime leaveDate;


  public enum Role {
    student, professor, admin, general
  }


  @Override
  public UserDTO toDTO() {
    return UserDTO.builder()
        .id(id)
        .password(password)
        .name(name)
        .engName(eng_Name)
        .gender(gender)
        .nationality(nationality)
        .socialNumber(socialNumber)
        .email(email)
        .contact(contact)
        .zip(zip)
        .address(address)
        .addressDetail(address_detail)
        .role(role)
        .agreedTerms(agreedTerms)
        .registerDate(registerDate)
        .leaveDate(leaveDate)
        .build();
  }

  public static class UserEntityBuilder {

    public UserEntity build() throws IllegalArgumentException {

      boolean isGenderLegal = Arrays.asList(UserDTO.GENDERS).contains(gender);
      boolean isRoleLegal = Arrays.asList(UserDTO.ROLES).contains(role);

      if (!isGenderLegal) {
        String message = String.format("유효하지 않은 성별([%s]): %s", Arrays.toString(UserDTO.GENDERS),
            gender);
        throw new IllegalArgumentException(message);
      } else if (!isRoleLegal) {
        String message = String.format("유효하지 않은 사용자 유형([%s]): %s", Arrays.toString(UserDTO.ROLES),
            role);
        throw new IllegalArgumentException(message);
      }
      return new UserEntity(id, password, name, eng_Name, gender, nationality, socialNumber, email,
          contact, zip, address, address_detail, role, agreedTerms, registerDate, leaveDate);
    }

  }
}
