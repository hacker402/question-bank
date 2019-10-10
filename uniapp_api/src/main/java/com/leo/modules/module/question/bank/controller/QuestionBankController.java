package com.leo.modules.module.question.bank.controller;

import com.leo.modules.entity.QuestionBank;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qingweiqu
 */
@Api(tags = "题库接口")
@RequestMapping(value = "/api/question/bank")
@RestController
public class QuestionBankController extends BaseController {

    @Resource
    private QuestionBankService bankService;

    @ApiOperation(value = "", notes = "分页展示")
    @GetMapping
    public ApiResult test (Integer questionMenuId, Pageable pageable) {
        return bankService.listPage(questionMenuId, pageable);
    }
}
