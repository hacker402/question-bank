package com.leo.modules.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *     题库菜单栏
 * </p>
 *
 * 分为一级菜单
 *      二级菜单
 *      三级菜单
 * parentId为0表示是一级标题
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
     * 名字
     */
    @Column(name = "f_name", nullable = false)
    private String name;

    /**
     * 父级id
     */
    @Column(name = "f_parent_id", nullable = false, columnDefinition = "int default 0")
    private Integer parentId;

    /**
     * 排序序号
     */
    @Column(name = "f_order_num", nullable = false, columnDefinition = "int default 0")
    private Integer orderNum;

    /**
     * 创建时间
     */
    @Column(name = "f_create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
}
