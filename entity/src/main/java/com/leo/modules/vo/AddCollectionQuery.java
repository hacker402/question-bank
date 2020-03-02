package com.leo.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qingweiqu
 */
@Data
@ApiModel(value = "添加收藏参数")
public class AddCollectionQuery {

    @ApiModelProperty(name = "questionId", value = "题库id")
    private Integer questionId;

    @ApiModelProperty(name = "questionCollectionId", value = "收藏集id")
    private Integer questionCollectionId;

    @ApiModelProperty(name = "userId", value = "用户id")
    private String userId;


    @ApiModelProperty(name = "enabled", value = "是否收藏", example = "true")
    private Boolean enabled = Boolean.TRUE;
}
