package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author qingweiqu
 */
public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Integer> {

    Optional<QuestionLike> findByQuestionId (Integer questionId);

}
