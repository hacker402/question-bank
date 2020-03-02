package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionLike;
import com.leo.modules.vo.AddQuestionLikeQuery;
import com.leo.uniapp.repository.QuestionLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


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
        questionLike.setEnabled(query.getEnabled())
                .setQuestionId(query.getQuestionId())
                .setUserId(query.getUserId())
                .setCreateTime(new Date());
        repository.save(questionLike);
    }


    public Page<QuestionLike> list(String userId, Pageable pageable) {
        Pageable page = PageRequest.of(pageable.getPageNumber() - 1, pageable.getPageSize());
        return repository.findAllByUserIdOfPage(userId, page);
    }

    public Boolean isLiked (Integer questionId, String userId) {
        Boolean liked = Boolean.FALSE;
        Optional<QuestionLike> optional = repository.findByQuestionIdAndUserId(questionId, userId);
        if (optional.isPresent()) {
            liked = optional.get().getEnabled();
        }
        return liked;
    }
}
