package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_menu")
public class Menu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Double price;
    private String flavor;
    private Type type;
    private Long tid;

}
