package com.leo.modules.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>
 *      用户表
 * </p>
 *
 * @author qingweiqu
 */
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "use_language")
    private String useLanguage;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "country")
    private String country;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;


}
