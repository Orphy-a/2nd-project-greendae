package com.greenuniv.greenuniv.repository.management;

import com.greenuniv.greenuniv.entity.lecture.LectureInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<LectureInfoEntity, String> {
}
