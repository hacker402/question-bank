package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author qingweiqu
 */
@Repository
public interface QuestionMenuRepository extends JpaRepository<QuestionMenu, Integer> {
}
