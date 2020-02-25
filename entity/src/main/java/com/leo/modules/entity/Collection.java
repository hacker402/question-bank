package com.leo.modules.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * <p>
 *     收藏
 * </p>
 * @author qingweiqu
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "t_collection")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userId;

    /**
     * 题库id
     */
    private Integer questionId;

    /**
     * 收藏集id
     */
    private Integer questionCollectionId;

    /**
     * 问题标题
     */
    private String title;

    private Boolean enabled;
}
