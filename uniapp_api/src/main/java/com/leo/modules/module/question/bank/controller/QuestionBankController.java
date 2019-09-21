package com.leo.modules.module.question.bank.controller;

import com.leo.modules.entity.QuestionBank;
import com.leo.uniapp.service.QuestionBankService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qingweiqu
 */
@RestController
public class QuestionBankController {

    @Resource
    private QuestionBankService questionBankService;

    @RequestMapping("/test")
    public String test () {
        QuestionBank bank = new QuestionBank();
        bank.setGarbageType(1);

        questionBankService.save(bank);
        return "ok";
    }
}
