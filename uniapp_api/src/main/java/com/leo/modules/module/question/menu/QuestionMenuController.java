package com.leo.modules.module.question.menu;

import com.leo.modules.entity.QuestionMenu;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qingweiqu
 */
@Api(tags = "题库菜单")
@RestController
@RequestMapping(value = "api/question/menu")
public class QuestionMenuController extends BaseController {

    @Resource
    private QuestionMenuService menuService;

    @ApiOperation(value = "创建菜单")
    @PostMapping
    public ApiResult create (QuestionMenu menu) {
        menuService.createMenu(menu);
        return success();
    }

    @ApiOperation(value = "获取菜单列表", notes = "分页")
    @GetMapping
    public ApiResult list () {
        return success(menuService.getAllMenu());
    }
}
