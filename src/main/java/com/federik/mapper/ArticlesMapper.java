package com.federik.mapper;

import com.federik.mapper.dto.Articles;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(Articles record);

    int insertSelective(Articles record);

    Articles selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKey(Articles record);

    List<Articles> selectAll(@Param("offset") Long offset,@Param("limit") Long limit);
}