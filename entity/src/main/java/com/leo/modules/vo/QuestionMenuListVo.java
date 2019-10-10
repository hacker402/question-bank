package com.leo.modules.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;


/**
 * @author qingweiqu
 */
@Data
@Builder
public class QuestionMenuListVo {

    private Integer id;

    /**
     * 标题
     */
    private String title;

    private List<QuestionMenuListVo> children;

}
