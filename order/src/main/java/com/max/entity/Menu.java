package com.max.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private Long id;
    private String name;
    private Double price;
    private String flavor;
    private Type type;
    private Long tid;

}
