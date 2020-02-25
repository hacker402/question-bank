package com.leo.modules.entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * <p>
 *     收藏集
 * </p>
 * @author qingweiqu
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_question_collection")
public class QuestionCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

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
