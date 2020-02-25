package com.leo.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qingweiqu
 */
@Data
@ApiModel(value = "创建收藏集参数")
public class CreateCollectionQuery {

    @ApiModelProperty(name = "title", value = "收藏集标题")
    private String title;

    @ApiModelProperty(name = "description", value = "收藏集描述")
    private String description;

    @ApiModelProperty(name = "userId", value = "用户id")
    private String userId;
}
