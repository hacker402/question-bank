package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionBank;
import com.leo.moudles.utils.DataUtils;
import com.leo.moudles.utils.validate.ValidateUtils;
import com.leo.uniapp.repository.QuestionBankRepository;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    public void add(QuestionBank bank) {
        log.info("-add input, QuestionBank:{}", bank);
        ValidateUtils.create()
                .append(bank.getAnswer(), StringUtils::isNotBlank, "answer is null")
                .append(bank.getContent(), StringUtils::isNotBlank, "content is null")
                .append(bank.getQuestionMenuId(), DataUtils::isNotNull, "questionMenuId is null")
                .validate();
        bank.setCreateTime(new Date());
        repository.save(bank);
    }

    @Transactional(rollbackFor = Exception.class)
    public Page<QuestionBank> listPage (Integer questionMenuId, Pageable pageable) {
        ValidateUtils.notNull(questionMenuId, "questionMenuId is null");
        return repository.findListByQuestionMenuId(questionMenuId, pageable);
    }
}
