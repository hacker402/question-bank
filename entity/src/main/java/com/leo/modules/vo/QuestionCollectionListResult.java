package com.leo.modules.vo;

import com.leo.modules.entity.QuestionBank;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author qingweiqu
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "单个收藏集列表")
public class QuestionCollectionListResult {

    @ApiModelProperty(name = "id", value = "收藏集id")
    private Integer id;

    @ApiModelProperty(name = "title", value = "收藏集标题")
    private String title;
    @ApiModelProperty(name = "description", value = "描述")
    private String description;
    @ApiModelProperty(name = "imageUrl", value = "背景图片url")
    private String imageUrl;

    @ApiModelProperty(name = "questionBankList", value = "问题列表")
    List<QuestionBank> questionBankList;
}
