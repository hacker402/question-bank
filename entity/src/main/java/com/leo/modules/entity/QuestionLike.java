package com.leo.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 *     点赞
 * </p>
 * @author qingweiqu
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_question_like")
public class QuestionLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    /**
     * 题库id
     */
    private Integer questionId;

    /**
     * 问题标题
     */
    private String title;

    private Boolean enabled;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
