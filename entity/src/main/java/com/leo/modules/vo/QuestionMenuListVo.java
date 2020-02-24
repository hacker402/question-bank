package com.leo.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * @author qingweiqu
 */
@Data
@Builder
@ApiModel(description = "获取菜单列表，每一个菜单数据的封装")
public class QuestionMenuListVo {

    @ApiModelProperty(value = "菜单主键唯一id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "菜单显示的分类名字", name = "name", position = 1)
    private String name;

    @ApiModelProperty(value = "菜单的子菜单数据", name = "children", position = 2)
    private List<QuestionMenuListVo> children;

}
