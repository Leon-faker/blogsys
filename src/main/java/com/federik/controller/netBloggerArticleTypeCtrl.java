package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.ArticleType;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticleTypeService;
import com.federik.services.FederikArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/articleType")
public class netBloggerArticleTypeCtrl {

    @Resource
    private FederikArticleTypeService federikArticleTypeService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public String addArticle(@RequestParam(value="offset") Long offset,@RequestParam(value = "limit") Long limit){
        log.info("查询文章类型列表【Controller】");
         return federikArticleTypeService.findAll(offset,limit).toString();
    }
}
