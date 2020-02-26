package com.leo.modules.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qingweiqu
 */
@Data
@ApiModel(value = "添加点赞参数")
public class AddQuestionLikeQuery {

    @ApiModelProperty(name = "questionId", value = "题库id")
    private Integer questionId;

    @ApiModelProperty(name = "userId", value = "用户id")
    private String userId;
}
