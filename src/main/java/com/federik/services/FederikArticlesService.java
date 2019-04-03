package com.federik.services;

import com.federik.controller.vo.ResultEncapsulationVO;
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
    ResultEncapsulationVO addArticle(Articles articles);

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
    ResultEncapsulationVO updateArticle(Articles articles);

    /**
     * 查询文章列表
     * @return
     */
    ResultEncapsulationVO findArticleLst(Long offset,Long limit);
}
