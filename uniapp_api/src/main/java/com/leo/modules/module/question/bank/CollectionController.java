package com.leo.modules.module.question.bank;

import com.leo.modules.vo.AddCollectionQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author qingweiqu
 */
@Api(tags = "收藏接口")
@RestController
@RequestMapping(value = "api/collection")
public class CollectionController extends BaseController {

    @Resource
    private CollectionService collectionService;

    @ApiOperation(value = "添加收藏")
    @PostMapping
    public ApiResult create (@RequestBody AddCollectionQuery query) {
        collectionService.create(query);
        return success();
    }

    //@ApiOperation(value = "收藏级列表")
    //@ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "path")
    //@GetMapping(value = "{userId}")
    //public ApiResult<List<QuestionCollection>> list (@PathVariable String userId) {
    //    return success("success", collectionService.listByUserId(userId));
    //}

}
