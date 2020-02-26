package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionLike;
import com.leo.modules.vo.AddQuestionLikeQuery;
import com.leo.uniapp.repository.QuestionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


/**
 * @author qingweiqu
 */
@Service
@Transactional(readOnly = true)
public class QuestionLikeService {

    @Autowired
    private QuestionLikeRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public void create(AddQuestionLikeQuery query) {
        QuestionLike questionLike = new QuestionLike();
        repository.findByQuestionId(query.getQuestionId()).ifPresent(like -> {
            questionLike.setId(like.getId());
        });
        questionLike.setEnabled(Boolean.TRUE)
                .setQuestionId(query.getQuestionId())
                .setUserId(query.getUserId())
                .setCreateTime(new Date());
        repository.save(questionLike);
    }
}
