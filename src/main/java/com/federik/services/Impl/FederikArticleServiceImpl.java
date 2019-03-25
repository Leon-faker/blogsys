package com.federik.services.Impl;

import com.federik.mapper.ArticlesMapper;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticlesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class FederikArticleServiceImpl implements FederikArticlesService {

    @Resource
    private ArticlesMapper articlesMapper;

    @Override
    public int addArticle(Articles articles) {
        try {
            if (Objects.isNull(articles)) {
                return -1;
            }
            return articlesMapper.insertSelective(articles);
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public int delArticle(Integer id) {
        return articlesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateArticle(Articles articles) {
        return articlesMapper.updateByPrimaryKeySelective(articles);
    }

    @Override
    public List<Articles> findArticleLst(Long offset,Long limit) {
        return articlesMapper.selectAll(offset,limit);
    }
}
