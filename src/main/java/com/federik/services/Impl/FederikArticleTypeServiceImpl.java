package com.federik.services.Impl;

import com.federik.common.utils.CommUtils;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.ArticleTypeMapper;
import com.federik.mapper.dto.ArticleType;
import com.federik.services.FederikArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class FederikArticleTypeServiceImpl implements FederikArticleTypeService {

    @Resource
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public ResultEncapsulationVO findAll(Long offset, Long limit) {
        log.info("查找文章类型列表【Service】");
        try {
            List<ArticleType> articleTypelst = articleTypeMapper.findAll(offset,limit);
            return ResultEncapsulationVO.success("请求成功").setData(articleTypelst);
        }catch (Exception e){
            log.error("查询出现异常");
            return ResultEncapsulationVO.fail("查询出现异常");
        }
    }
}
