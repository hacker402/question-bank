package com.leo.modules.module.question.bank;

import com.leo.modules.vo.AddQuestionLikeQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author qingweiqu
 */
@Api(tags = "点赞接口")
@RestController
@RequestMapping(value = "api/question/like")
public class QuestionLikeController extends BaseController {

    @Autowired
    private QuestionLikeService questionLikeService;

    @ApiOperation(value = "点赞")
    @PostMapping
    public ApiResult create (@RequestBody AddQuestionLikeQuery query) {
        questionLikeService.create(query);
        return success();
    }

}
