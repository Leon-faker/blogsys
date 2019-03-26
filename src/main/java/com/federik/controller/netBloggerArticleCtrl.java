package com.federik.controller;

import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticlesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @GetMapping(value = "/findArticlelst")
    @ResponseBody
    public String obtainArticlelst(@RequestParam(value = "offset") Long offset,
                                   @RequestParam(value = "limit") Long limit){
        ResultEncapsulationVO<List<Articles>> resultlst = new ResultEncapsulationVO<>();
        List<Articles> articlelst = federikArticlesService.findArticleLst(offset,limit);
        if(Objects.isNull(articlelst)){
            resultlst.setData(null);
            resultlst.setResultCode(-1L);
            resultlst.setStrDescribe("Don't Data");
        }else {
            resultlst.setData(articlelst);
            resultlst.setResultCode(1L);
            resultlst.setStrDescribe("Hava Data");
        }
        return resultlst.toString();
    }
}
