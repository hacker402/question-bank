package com.leo.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 题库菜单栏
 * @author qingweiqu
 */
@Data
@Entity
@Table(name = "t_question_menu")
public class QuestionMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 标题
     */
    @Column(name = "f_title")
    private String title;

    /**
     * 父级id
     */
    @Column(name = "f_parent_id")
    private Integer parentId;

    /**
     * 排序序号
     */
    @Column(name = "f_order_num")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
