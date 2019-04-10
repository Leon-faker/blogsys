package com.federik.services.Impl;

import com.federik.common.utils.CommUtils;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.articlesMapper;
import com.federik.mapper.dto.articles;
import com.federik.mapper.dto.articlesExample;
import com.federik.services.FederikArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
public class FederikArticleServiceImpl implements FederikArticlesService {

    @Resource
    private articlesMapper articlesMapperDao;

    @Override
    public ResultEncapsulationVO addArticle(articles articles) {
        try {
            if (Objects.isNull(articles)) {
                return ResultEncapsulationVO.fail("参数异常");
            }
            articles.setArticleCrTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            int sqlResult =  articlesMapperDao.insertSelective(articles);
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
            int sqlResult =  articlesMapperDao.deleteByPrimaryKey(id);
            return sqlResult > 0 ? ResultEncapsulationVO.success("删除成功") : ResultEncapsulationVO.fail("删除失败");
        }catch (Exception e){
            log.info("删除出现异常");
            return ResultEncapsulationVO.fail("删除出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO updateArticle(articles articles) {
        log.info(""+articles.getArticleStatus());
        try {
            if (Objects.isNull(articles)) {
                return ResultEncapsulationVO.fail("参数异常");
            }
            if(CommUtils.isNull(articles.getArticleId())){
                return ResultEncapsulationVO.fail("articleId 不能为空");
            }

            articles sourceArticle = articlesMapperDao.selectByPrimaryKey(articles.getArticleId());
            if(CommUtils.isNull(sourceArticle)) {
                return  ResultEncapsulationVO.fail("未查询到内容");
            }
            if(!CommUtils.isNull(articles.getArticleName())){
                sourceArticle.setArticleName(articles.getArticleName());
            }

            if(!CommUtils.isNull(articles.getArticleTypeId())){
                sourceArticle.setArticleTypeId(articles.getArticleTypeId());
            }

            if(!CommUtils.isNull(articles.getArticleId())){
                sourceArticle.setArticleId(articles.getArticleId());
            }

            if(!CommUtils.isNull(articles.getArticleStatus())){
                sourceArticle.setArticleStatus(articles.getArticleStatus());
            }

            if(!CommUtils.isNull(articles.getArticleContent())){
                sourceArticle.setArticleContent(articles.getArticleContent());
            }

            int sqlResult =  articlesMapperDao.updateByPrimaryKeySelective(sourceArticle);
            return sqlResult > 0 ? ResultEncapsulationVO.success("修改成功") : ResultEncapsulationVO.fail("修改失败");
        }catch (Exception e){
            log.info("修改出现异常");
            return ResultEncapsulationVO.fail("修改出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO findArticleLst(Long offset,Long limit) {
        try {
            if(limit == 0) {
                return ResultEncapsulationVO.fail("limit不能为0");
            }

            articlesExample articleEx = new articlesExample();
            articleEx.setOrderByClause(" article_id LIMIT "+offset+","+limit);

            articlesExample.Criteria articleCr = articleEx.createCriteria()
                    .andArticleFlagDelEqualTo(0);

            List<articles> articllst =  articlesMapperDao.selectByExample(articleEx);

            return ResultEncapsulationVO.success("查询成功").setData(articllst);
        }catch (Exception e){
            log.info("查询出现异常"+e.getMessage());
            return ResultEncapsulationVO.fail("查询出现异常："+e.getMessage());
        }
    }
}
