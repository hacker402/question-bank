package com.leo.uniapp.repository;

import com.leo.modules.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author qingweiqu
 */
public interface CollectionRepository extends JpaRepository<Collection, Integer> {

    List<Collection> findAllByQuestionCollectionIdAndUserId (Integer questionCollectionId, String userId);

    Optional<Collection> findByQuestionIdAndUserId(Integer questionId, String userId);

}
