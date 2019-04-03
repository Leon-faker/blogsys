package com.federik.services.Impl;

import com.alibaba.fastjson.JSON;
import com.federik.common.utils.CommUtils;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.ArticlesMapper;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class FederikArticleServiceImpl implements FederikArticlesService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public ResultEncapsulationVO addArticle(Articles articles) {
        try {
            if (Objects.isNull(articles)) {
                return ResultEncapsulationVO.fail("参数异常");
            }
            int sqlResult =  articlesMapper.insertSelective(articles);
            return sqlResult > 0 ? ResultEncapsulationVO.success("添加成功") : ResultEncapsulationVO.fail("添加失败");
        }catch (Exception e){
           log.info("添加出现异常");
           return ResultEncapsulationVO.fail("添加出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO delArticle(Integer id) {
        try {
            if (Objects.isNull(id)) {
                return ResultEncapsulationVO.fail("参数异常");
            }
            int sqlResult =  articlesMapper.deleteByPrimaryKey(id);
            return sqlResult > 0 ? ResultEncapsulationVO.success("删除成功") : ResultEncapsulationVO.fail("删除失败");
        }catch (Exception e){
            log.info("删除出现异常");
            return ResultEncapsulationVO.fail("删除出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO updateArticle(Articles articles) {
        log.info(JSON.toJSONString(articles));
        try {
            if (Objects.isNull(articles)) {
                return ResultEncapsulationVO.fail("参数异常");
            }
            if(CommUtils.isNull(articles.getArticleId())){
                return ResultEncapsulationVO.fail("articleId 不能为空");
            }

            Articles sourceArticle = articlesMapper.selectByPrimaryKey(articles.getArticleId());
            if(CommUtils.isNull(sourceArticle)) {
                return  ResultEncapsulationVO.fail("未查询到内容");
            }
            if(CommUtils.isNull(articles.getArticleName())){
                sourceArticle.setArticleName(articles.getArticleName());
            }

            if(CommUtils.isNull(articles.getArticleId())){
                sourceArticle.setArticleId(articles.getArticleId());
            }

            if(CommUtils.isNull(articles.getArticleStatus())){
                sourceArticle.setArticleStatus(articles.getArticleStatus());
            }

            if(CommUtils.isNull(articles.getArticleContent())){
                sourceArticle.setArticleContent(articles.getArticleContent());
            }

            int sqlResult =  articlesMapper.updateByPrimaryKeySelective(sourceArticle);
            return sqlResult > 0 ? ResultEncapsulationVO.success("修改成功") : ResultEncapsulationVO.fail("修改失败");
        }catch (Exception e){
            log.info("修改出现异常");
            return ResultEncapsulationVO.fail("修改出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO findArticleLst(Long offset,Long limit) {
        try {
            List<Articles> articllst =  articlesMapper.selectAll(offset,limit);
            return ResultEncapsulationVO.success("查询成功").setData(articllst);
        }catch (Exception e){
            log.info("查询出现异常");
            return ResultEncapsulationVO.fail("查询出现异常");
        }
    }
}
