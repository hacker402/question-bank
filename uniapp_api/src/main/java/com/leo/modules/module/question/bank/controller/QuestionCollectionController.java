package com.leo.modules.module.question.bank.controller;

import com.leo.modules.entity.QuestionCollection;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionCollectionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "收藏集接口")
@RestController
@RequestMapping(value = "/api/question/collection")
public class QuestionCollectionController extends BaseController {

    @Resource
    private QuestionCollectionService collectionService;

    @PostMapping
    public ApiResult create (QuestionCollection collection) {
        collectionService.create(collection);
        return success();
    }

    @GetMapping(value = "/list")
    public ApiResult list () {
        return collectionService.listByUserId(11);
    }

    @PutMapping
    public ApiResult update (QuestionCollection collection) {
        collectionService.update(collection);
        return success();
    }

    @DeleteMapping
    public ApiResult delete (Integer collectionId) {
        collectionService.delete(collectionId);
        return success();
    }
}
