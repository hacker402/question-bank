package com.leo.modules.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    private Integer questionId;

    @Column(name = "garbage_type")
    private Integer garbageType;


}
