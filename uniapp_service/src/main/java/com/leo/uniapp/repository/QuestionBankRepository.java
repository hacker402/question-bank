package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionBank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author qingweiqu
 */
@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Integer> {

    @Query(value = "SELECT * FROM t_question_bank WHERE f_question_menu_id = ?1",
            countQuery = "SELECT count(*) FROM t_question_bank WHERE f_question_menu_id = ?1",
            nativeQuery = true)
    Page<QuestionBank> findListByQuestionMenuId (Integer menuId, Pageable pageable);

}
