package com.greenuniv.greenuniv.repository.login;

import com.greenuniv.greenuniv.entity.terms.TermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<TermsEntity, Integer> {
}
