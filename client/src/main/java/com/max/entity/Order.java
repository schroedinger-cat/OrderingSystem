package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    private Long id;

    private Long uid;
    private User user;

    private Long mid;
    private Menu menu;

    private Long aid;
    private Admin admin;

    private Date date;
    private Integer state = 0;


}
