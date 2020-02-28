package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionBank;
import com.leo.modules.entity.QuestionLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author qingweiqu
 */
public interface QuestionLikeRepository extends JpaRepository<QuestionLike, Integer> {

    Optional<QuestionLike> findByQuestionId (Integer questionId);

    @Query(value = "SELECT * FROM t_question_like WHERE user_id = ?1",
            countQuery = "SELECT count(*) FROM t_question_like WHERE user_id = ?1",
            nativeQuery = true)
    Page<QuestionLike> findAllByUserIdOfPage (String userId, Pageable pageable);


}
