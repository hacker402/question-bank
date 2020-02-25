package com.leo.uniapp.service;

import com.leo.modules.entity.Collection;
import com.leo.modules.vo.AddCollectionQuery;
import com.leo.uniapp.repository.CollectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional(readOnly = true)
public class CollectionService {

    @Resource
    private CollectionRepository repository;


    @Transactional(rollbackFor = Exception.class)
    public void create(AddCollectionQuery query) {
        Collection collection = new Collection();
        collection.setEnabled(Boolean.TRUE)
                .setTitle("11111")
                .setUserId(query.getUserId())
                .setQuestionId(query.getQuestionId())
                .setQuestionCollectionId(query.getQuestionCollectionId());
        repository.save(collection);
    }
}
