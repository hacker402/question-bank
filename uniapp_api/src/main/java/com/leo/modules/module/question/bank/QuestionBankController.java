package com.leo.modules.module.question.bank;

import com.leo.modules.entity.QuestionBank;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "添加问题")
    @PostMapping
    public ApiResult add (QuestionBank bank) {
        bankService.add(bank);
        return ApiResult.success();
    }

    @ApiOperation(value = "问题列表", notes = "分页展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "0", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页容量", defaultValue = "10", paramType = "query", dataType = "int"),
            @ApiImplicitParam(name = "questionMenuId", value = "问答菜单id", paramType = "query", required = true, dataType = "int")
    })
    @GetMapping
    public ApiResult<Page<QuestionBank>> test ( Integer questionMenuId, Pageable pageable) {
        return ApiResult.success(bankService.listPage(questionMenuId, pageable));
    }
}
