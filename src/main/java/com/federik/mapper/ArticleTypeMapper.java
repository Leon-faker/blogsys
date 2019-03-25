package com.federik.mapper;

import com.federik.mapper.dto.ArticleType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleTypeMapper {
    int deleteByPrimaryKey(Integer articleTypeId);

    int insert(ArticleType record);

    int insertSelective(ArticleType record);

    ArticleType selectByPrimaryKey(Integer articleTypeId);

    int updateByPrimaryKeySelective(ArticleType record);

    int updateByPrimaryKey(ArticleType record);

    List<ArticleType> findAll(@Param("offset") Long offset, @Param("limit") Long limit);
}