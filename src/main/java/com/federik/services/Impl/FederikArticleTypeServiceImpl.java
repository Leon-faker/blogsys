package com.federik.services.Impl;

import com.federik.mapper.ArticleTypeMapper;
import com.federik.mapper.dto.ArticleType;
import com.federik.services.FederikArticleTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FederikArticleTypeServiceImpl implements FederikArticleTypeService {

    @Resource
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public List<ArticleType> findAll(Long offset, Long limit) {
        return articleTypeMapper.findAll(offset,limit);
    }
}
