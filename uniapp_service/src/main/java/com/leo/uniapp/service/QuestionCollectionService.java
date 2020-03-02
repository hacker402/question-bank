package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionCollection;
import com.leo.modules.vo.CreateCollectionQuery;
import com.leo.modules.vo.UpdateCollectionParam;
import com.leo.moudles.exception.GeneralException;
import com.leo.uniapp.repository.QuestionCollectionRepository;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author qingweiqu
 */
@Service
@Transactional(readOnly = true)
public class QuestionCollectionService {

    @Resource
    private QuestionCollectionRepository repository;

    public QuestionCollection require(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new GeneralException("not exist"));
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
    public void update(UpdateCollectionParam param) {
        QuestionCollection questionCollection = repository.findById(param.getId()).orElseThrow(() -> new GeneralException("not exist"));
        if (StringUtils.isNotBlank(param.getTitle())) {
            questionCollection.setTitle(param.getTitle());
        }
        if (StringUtils.isNotBlank(param.getImageUrl())) {
            questionCollection.setImageUrl(param.getImageUrl());
        }
        if (StringUtils.isNotBlank(param.getDescription())) {
            questionCollection.setDescription(param.getDescription());
        }
        repository.save(questionCollection);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer collectionId) {
        QuestionCollection collection = require(collectionId);
        collection.setEnabled(Boolean.FALSE);
        repository.save(collection);
    }

    public List<QuestionCollection> listByUserId(String userId) {
        return repository.findAllByEnabledIsTrueAndUserId(userId);
    }

    private void init (QuestionCollection collection) {

    }


    public QuestionCollection detail(Integer id) {
        return repository.findById(id).orElseThrow(() -> new GeneralException("not exist"));
    }
}
