package com.leo.uniapp.service;

import com.leo.modules.entity.QuestionBank;
import com.leo.uniapp.repository.QuestionBankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void save (QuestionBank bank) {
        repository.save(bank);
    }
}
