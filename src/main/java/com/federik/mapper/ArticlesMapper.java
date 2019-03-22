package com.federik.mapper;

import com.federik.mapper.dto.Articles;

public interface ArticlesMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKey(Articles record);
}