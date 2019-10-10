package com.leo.uniapp.repository;

import com.leo.modules.entity.QuestionMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qingweiqu
 */
@Repository
public interface QuestionMenuRepository extends JpaRepository<QuestionMenu, Integer> {

    List<QuestionMenu> findAllByParentId (Integer parentId);
}
