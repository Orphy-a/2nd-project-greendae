package com.greenuniv.greenuniv.repository.management;

import com.greenuniv.greenuniv.entity.department.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {
}
