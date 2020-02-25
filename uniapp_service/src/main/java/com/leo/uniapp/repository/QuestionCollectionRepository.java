package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionCollectionRepository extends JpaRepository<QuestionCollection, Integer> {

    List<QuestionCollection> findAllByUserId (Integer userId);

    List<QuestionCollection> findAllByEnabledIsTrueAndUserId (String userId);
}
