package com.leo.modules.module.question.menu;

import com.leo.modules.entity.QuestionMenu;
import com.leo.moudles.hanlder.BaseController;
import com.leo.moudles.response.ApiResult;
import com.leo.uniapp.service.QuestionMenuService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qingweiqu
 */
@Api(tags = "")
@RestController
@RequestMapping(value = "/api/question/menu")
public class QuestionMenuController extends BaseController {

    @Resource
    private QuestionMenuService menuService;

    @PostMapping
    public ApiResult create (QuestionMenu menu) {
        menuService.createMenu(menu);
        return success();
    }
}
