package com.leo.uniapp.service;

import com.leo.modules.entity.Collection;
import com.leo.modules.entity.QuestionBank;
import com.leo.modules.vo.AddCollectionQuery;
import com.leo.uniapp.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class CollectionService {

    @Resource
    private CollectionRepository repository;

    @Autowired
    private QuestionBankService questionBankService;


    @Transactional(rollbackFor = Exception.class)
    public void create(AddCollectionQuery query) {
        Collection collection = new Collection();
        repository.findByQuestionIdAndUserId(query.getQuestionId(), query.getUserId())
                .ifPresent( p -> {
                    collection.setId(p.getId());
                });
        collection.setEnabled(query.getEnabled())
                .setTitle("11111")
                .setUserId(query.getUserId())
                .setQuestionId(query.getQuestionId())
                .setQuestionCollectionId(query.getQuestionCollectionId());
        repository.save(collection);
    }

    public List<QuestionBank> getOneCollection(Integer collectionId, String userId) {
        List<Collection> list = repository.findAllByQuestionCollectionIdAndUserId(collectionId, userId);
        List<QuestionBank> result = new ArrayList<>();
        list.forEach(p -> {
            QuestionBank questionBank = questionBankService.detail(p.getQuestionId());
            result.add(questionBank);
        });
        return result;
    }

    public Boolean isCollected (Integer questionId, String userId) {
        Boolean collected = Boolean.FALSE;
        Optional<Collection>  optional = repository.findByQuestionIdAndUserId(questionId, userId);
        if (optional.isPresent()) {
            collected = optional.get().getEnabled();
        }
        return collected;
    }
}
