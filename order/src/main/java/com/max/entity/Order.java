package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_order")
public class Order {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private Long uid;
    private User user;

    private Long mid;
    private Menu menu;

    private Long aid;
    private Admin admin;

    private Date date;
    private Integer state;


}
