package com.leo.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qingweiqu
 */
@Data
@ApiModel(value = "修改收藏集参数")
public class UpdateCollectionParam {

    @ApiModelProperty(name = "id", value = "收藏级id", required = true, dataType = "int")
    private Integer id;

    @ApiModelProperty(name = "title", value = "标题")
    private String title;
    @ApiModelProperty(name = "description", value = "描述")
    private String description;
    @ApiModelProperty(name = "imageUrl", value = "背景图片url")
    private String imageUrl;
}
