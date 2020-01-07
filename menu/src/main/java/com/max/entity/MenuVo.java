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
public class MenuVo {
    private Integer code;
    private String msg;
    private Long count;
    private List<Menu> data;
}
