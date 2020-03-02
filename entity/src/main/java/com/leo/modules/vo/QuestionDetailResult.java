package com.leo.modules.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author qingweiqu
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "问题详情返回值")
public class QuestionDetailResult {


    @ApiModelProperty(name = "id", value = "主键id")
    private Integer id;

    @ApiModelProperty(name = "content", value = "问题内容")
    private String content;

    @ApiModelProperty(name = "answer", value = "问题答案")
    private String answer;

    @ApiModelProperty(name = "liked", value = "是否点赞")
    private Boolean liked;

    @ApiModelProperty(name = "collected", value = "是否收藏")
    private Boolean collected;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(name = "createTime", value = "创建时间")
    private Date createTime;


}
