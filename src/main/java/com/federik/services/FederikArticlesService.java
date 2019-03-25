package com.federik.services;

import com.federik.mapper.dto.Articles;

import java.util.List;

/**
 * 文章管理模块
 * @author  hang.li 2019-3-25
 */
public interface FederikArticlesService {

    /**
     * 新增文章
     * @param articles 文章模型
     * @return
     */
    int addArticle(Articles articles);

    /**
     *  删除文章
     * @param id 文章id
     * @return
     */
    int delArticle(Integer id);

    /**
     * 修改文章
     * @param articles 文章模型
     * @return
     */
    int updateArticle(Articles articles);

    /**
     * 查询文章列表
     * @return
     */
    List<Articles> findArticleLst(Long offset,Long limit);
}
