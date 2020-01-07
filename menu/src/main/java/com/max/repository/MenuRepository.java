package com.max.repository;

import com.max.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuRepository extends Mapper<Menu> {

    List<Menu> selectAllJoinType();

    Menu selectByPrimaryKeyJoinType(Long id);
}
