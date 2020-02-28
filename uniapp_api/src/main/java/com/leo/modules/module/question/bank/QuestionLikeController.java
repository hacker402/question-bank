package com.leo.modules.module.question.bank;

import com.leo.modules.entity.QuestionLike;
import com.leo.modules.vo.AddQuestionLikeQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


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

    @ApiOperation(value = "我的点赞")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页容量", defaultValue = "10", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "用户id", paramType = "query", required = true, dataType = "string")
    })
    @GetMapping
    public ApiResult<Page<QuestionLike>> list (String userId, Pageable pageable) {
        return success(questionLikeService.list(userId, pageable));
    }
}
