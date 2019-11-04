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

    @ApiModelProperty(value = "id", name = "菜单主键唯一id")
    private Integer id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "name", name = "菜单显示的分类名字")
    private String name;

    @ApiModelProperty(value = "children", name = "此菜单的子菜单数据")
    private List<QuestionMenuListVo> children;

}
