package com.federik.services;

import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.articles;

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
    ResultEncapsulationVO addArticle(articles articles);

    /**
     *  删除文章
     * @param id 文章id
     * @return
     */
    ResultEncapsulationVO delArticle(Integer id);

    /**
     * 修改文章
     * @param articles 文章模型
     * @return
     */
    ResultEncapsulationVO updateArticle(articles articles);

    /**
     * 查询文章列表
     * @return
     */
    ResultEncapsulationVO findArticleLst(Long offset,Long limit);
}
