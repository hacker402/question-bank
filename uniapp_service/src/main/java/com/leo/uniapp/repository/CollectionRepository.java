package com.leo.uniapp.repository;

import com.leo.modules.entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Integer> {

    List<Collection> findAllByQuestionCollectionIdAndUserId (Integer questionCollectionId, String userId);

}
