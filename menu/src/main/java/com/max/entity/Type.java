package com.max.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_type")
public class Type {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
}
