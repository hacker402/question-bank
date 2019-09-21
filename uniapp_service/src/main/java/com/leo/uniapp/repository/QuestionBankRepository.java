package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qingweiqu
 */
@Repository
public interface QuestionBankRepository extends JpaRepository<QuestionBank, Integer> {
}
