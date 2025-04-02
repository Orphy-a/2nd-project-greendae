package com.greenuniv.greenuniv.repository.management;

import com.greenuniv.greenuniv.entity.department.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer> {


}
