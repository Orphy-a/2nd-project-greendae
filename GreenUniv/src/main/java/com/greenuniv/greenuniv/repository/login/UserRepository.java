package com.greenuniv.greenuniv.repository.login;

import com.greenuniv.greenuniv.entity.professor.ProfessorEntity;
import com.greenuniv.greenuniv.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    boolean existsByEmail(String email);

    boolean existsByContact(String contact);

    @Query("SELECT u.name from UserEntity AS u WHERE u.role='professor'")
    public void findAllProfessors();

    //Optional<ProfessorEntity> professorFindById(String id);
}