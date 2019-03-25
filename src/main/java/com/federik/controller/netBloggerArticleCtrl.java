package com.federik.controller;

import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticlesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/article")
public class netBloggerArticleCtrl {

    @Resource
    private FederikArticlesService federikArticlesService;

    @PostMapping(value = "addArticle")
    @ResponseBody
    public String addArticle(@RequestBody Articles articles){
        int result = federikArticlesService.addArticle(articles);
        ResultEncapsulationVO<Boolean> resultEncapsulationVO = new ResultEncapsulationVO<>();
        if (result >= 1){
            resultEncapsulationVO.setData(true);
            resultEncapsulationVO.setResultCode(1L);
            resultEncapsulationVO.setStrDescribe("add successful");
        }else {
            resultEncapsulationVO.setData(false);
            resultEncapsulationVO.setResultCode(-1L);
            resultEncapsulationVO.setStrDescribe("add fail");
        }
        return resultEncapsulationVO.toString();
    }
}
