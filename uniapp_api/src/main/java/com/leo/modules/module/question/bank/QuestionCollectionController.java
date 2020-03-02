package com.leo.modules.module.question.bank;

import com.leo.modules.entity.QuestionCollection;
import com.leo.modules.vo.CreateCollectionQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qingweiqu
 */
@Api(tags = "收藏集接口")
@RestController
@RequestMapping(value = "/api/question/collection")
public class QuestionCollectionController extends BaseController {

    @Autowired
    private QuestionCollectionService questionCollectionService;

    @ApiOperation(value = "创建收藏集")
    @PostMapping
    public ApiResult create (@RequestBody CreateCollectionQuery query) {
        questionCollectionService.create(query);
        return success();
    }

    @ApiOperation(value = "我的收藏级列表")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query")
    @GetMapping
    public ApiResult<List<QuestionCollection>> listOfOwner (String userId) {
        return success("success", questionCollectionService.listByUserId(userId));
    }

    @ApiOperation(value = "收藏级详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "收藏级id", required = true, paramType = "path")
    })
    @GetMapping(value = "{id}")
    public ApiResult<QuestionCollection> detail(@PathVariable Integer id) {
        return success("success", questionCollectionService.detail(id));
    }


    @PutMapping
    public ApiResult update (QuestionCollection collection) {
        questionCollectionService.update(collection);
        return success();
    }

    @DeleteMapping
    public ApiResult delete (Integer collectionId) throws Exception {
        questionCollectionService.delete(collectionId);
        return success();
    }
}
