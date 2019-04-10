package com.federik.services;

import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.articlesType;

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
    ResultEncapsulationVO findAll(Long offset, Long limit);

    /**
     * 新增文章类型
     * @param articlesType
     * @return
     */
    ResultEncapsulationVO addArticleType(articlesType articlesType);

    /**
     * 修改文章类型
     * @param articlesType
     * @return
     */
    ResultEncapsulationVO updateArticleType(articlesType articlesType);

    /**
     * 删除文章类型
     * @param articleTypeId
     * @return
     */
    ResultEncapsulationVO removeArticleType(Integer articleTypeId);
}
