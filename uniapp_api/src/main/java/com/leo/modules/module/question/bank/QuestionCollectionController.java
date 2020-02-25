package com.leo.modules.module.question.bank;

import com.leo.modules.entity.QuestionCollection;
import com.leo.modules.vo.CreateCollectionQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qingweiqu
 */
@Api(tags = "收藏集接口")
@RestController
@RequestMapping(value = "/api/question/collection")
public class QuestionCollectionController extends BaseController {

    @Resource
    private QuestionCollectionService collectionService;

    @ApiOperation(value = "创建收藏集")
    @PostMapping
    public ApiResult create (@RequestBody CreateCollectionQuery query) {
        collectionService.create(query);
        return success();
    }

    @ApiOperation(value = "收藏级列表")
    @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path")
    @GetMapping(value = "{userId}")
    public ApiResult<List<QuestionCollection>> list (@PathVariable String userId) {
        return success("success", collectionService.listByUserId(userId));
    }

    @PutMapping
    public ApiResult update (QuestionCollection collection) {
        collectionService.update(collection);
        return success();
    }

    @DeleteMapping
    public ApiResult delete (Integer collectionId) throws Exception {
        collectionService.delete(collectionId);
        return success();
    }
}
