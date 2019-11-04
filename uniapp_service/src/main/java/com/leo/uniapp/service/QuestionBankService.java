package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionBank;
import com.leo.moudles.utils.validate.ValidateUtils;
import com.leo.uniapp.repository.QuestionBankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

/**
 * @author qingweiqu
 */
@Slf4j
@Service
@Transactional(readOnly = true)
public class QuestionBankService {

    @Autowired
    private QuestionBankRepository repository;

    @Transactional(rollbackFor = Exception.class)
    public Page<QuestionBank> listPage (Integer questionMenuId, Pageable pageable) {
        ValidateUtils.notNull(questionMenuId, "questionMenuId is null");
        //return repository.findAllByQuestionMenuId(questionMenuId, pageable);
        return null;
    }
}
