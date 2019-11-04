package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionCollection;
import com.leo.uniapp.repository.QuestionCollectionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class QuestionCollectionService {

    @Resource
    private QuestionCollectionRepository repository;

    public QuestionCollection require(Integer id) throws Exception {
        return repository.findById(id)
                .orElseThrow(() -> new Exception());
    }

    @Transactional(rollbackFor = Exception.class)
    public void create(QuestionCollection collection) {
        repository.save(collection);
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(QuestionCollection collection) {
        repository.save(collection);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer collectionId) throws Exception {
        QuestionCollection collection = require(collectionId);
        collection.setEnabled(Boolean.TRUE);
        repository.save(collection);
    }

    public List<QuestionCollection> listByUserId(Integer userId) {
        return repository.findAllByEnabledTrueAndUserId(userId);
    }

    private void init (QuestionCollection collection) {

    }


}
