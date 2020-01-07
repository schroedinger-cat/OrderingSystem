package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderVo {
    private Integer code;
    private String msg;
    private Long count;
    private List<Order> data;
}
