package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionCollection;
import com.leo.modules.vo.CreateCollectionQuery;
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
    public void create(CreateCollectionQuery query) {
        QuestionCollection collection = new QuestionCollection();
        collection.setTitle(query.getTitle())
                .setDescription(query.getDescription())
                .setUserId(query.getUserId())
                .setImageUrl(query.getImageUrl())
                .setEnabled(Boolean.TRUE);
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

    public List<QuestionCollection> listByUserId(String userId) {
        return repository.findAllByEnabledIsTrueAndUserId(userId);
    }

    private void init (QuestionCollection collection) {

    }


}
