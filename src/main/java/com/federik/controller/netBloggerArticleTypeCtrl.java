package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.ArticleType;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticleTypeService;
import com.federik.services.FederikArticlesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/articleType")
public class netBloggerArticleTypeCtrl {

    @Resource
    private FederikArticleTypeService federikArticleTypeService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public String addArticle(@RequestParam(value="offset") Long offset,@RequestParam(value = "limit") Long limit){
        List<ArticleType> articleTypelst = federikArticleTypeService.findAll(offset,limit);
        System.out.println(JSON.toJSONString(articleTypelst));
        ResultEncapsulationVO<List<ArticleType>> resultEncapsulationVO = new ResultEncapsulationVO<>();
        resultEncapsulationVO.setData(articleTypelst);
        resultEncapsulationVO.setResultCode(1L);
        resultEncapsulationVO.setStrDescribe("return successful");
        return resultEncapsulationVO.toString();
    }
}
