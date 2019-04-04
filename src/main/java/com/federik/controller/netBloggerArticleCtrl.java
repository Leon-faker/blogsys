package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.mapper.dto.Articles;
import com.federik.services.FederikArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
@RequestMapping(value = "/article")
public class netBloggerArticleCtrl {

    @Resource
    private FederikArticlesService federikArticlesService;

    @PostMapping(value = "/addArticle")
    @ResponseBody
    public String addArticle(@RequestBody Articles articles){
        articles.setArticleCrTime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
       return federikArticlesService.addArticle(articles).toString();
    }

    @GetMapping(value = "/findArticlelst")
    @ResponseBody
    public String obtainArticlelst(@RequestParam(value = "offset") Long offset,
                                   @RequestParam(value = "limit") Long limit){
       return federikArticlesService.findArticleLst(offset,limit).toString();
    }

    /**
     * 修改文章
     * @param articles
     * @return
     */
    @PostMapping(value = "/updateArticle")
    @ResponseBody
    public String updateStatus(@RequestBody Articles articles){
        log.info("文章修改,请求参数:" + JSON.toJSONString(articles));
        return federikArticlesService.updateArticle(articles).toString();
    }
}
