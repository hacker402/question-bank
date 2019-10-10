package com.leo.modules.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * <p>
 *     收藏集
 * </p>
 */
@Data
@Entity
@Table(name = "t_question_collection")
public class QuestionCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 背景图片名字
     */
    private String filename;

    private Boolean enabled;
}
