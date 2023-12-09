package com.jamie.home.api.model.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString
public class MEMBER {
    private Integer member;
    private String id;
    private String password;
    @Enumerated(EnumType.STRING)
    private ROLE role;
    private String reg_date;
    private String upd_date;

    private Boolean auto_login;

    public MEMBER() {}

    public MEMBER(Integer member) {
        this.member = member;
    }
}
