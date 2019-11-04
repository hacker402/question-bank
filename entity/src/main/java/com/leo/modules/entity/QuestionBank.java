package com.leo.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *      题库表
 * </p>
 *
 * @author qingweiqu
 */
@Data
@Entity
@Table(name = "t_question_bank")
public class QuestionBank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 题库菜单id
     */
    @Column(name = "f_question_menu_id", nullable = false)
    private Integer questionMenuId;

    /**
     * 问题内容
     */
    @Column(name = "f_content", nullable = false)
    private String content;

    /**
     * 问题答案
     */
    @Column(name = "f_answer", nullable = false)
    private String answer;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;


}
