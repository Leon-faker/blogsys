package com.federik.services;

import com.federik.mapper.dto.ArticleType;

import java.util.List;

/**
 * 文章类型服务接口
 */
public interface FederikArticleTypeService {

    /**
     * 查询文章类型列表
     * @param offset
     * @param limit
     * @return
     */
    List<ArticleType> findAll(Long offset,Long limit);
}
