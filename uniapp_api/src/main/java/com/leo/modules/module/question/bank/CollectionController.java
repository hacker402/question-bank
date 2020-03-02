package com.leo.modules.module.question.bank;

import com.leo.modules.vo.AddCollectionQuery;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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


    @ApiOperation(value = "单个收藏级下所有问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页容量", defaultValue = "10", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "collectionId", value = "收藏级id", required = true, paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "userId", value = "用户id", required = true, paramType = "query", dataType = "string")
    })
    @GetMapping
    public ApiResult listOfOneCollection (@ApiIgnore Integer collectionId, @ApiIgnore String userId) {
        return success("success", collectionService.getOneCollection(collectionId, userId));
    }

}
