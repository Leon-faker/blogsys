package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.mapper.dto.articles;
import com.federik.services.FederikArticlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/article")
public class netBloggerArticleCtrl {

    @Resource
    private FederikArticlesService federikArticlesService;

    @PostMapping(value = "/addArticle")
    @ResponseBody
    public String addArticle(@RequestBody articles articles){
        log.info("添加文章,请求参数:"+JSON.toJSONString(articles));
        articles.setArticleCrTime(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").format(new Date()));
       return federikArticlesService.addArticle(articles).toString();
    }

    @PostMapping(value = "/findArticlelst")
    @ResponseBody
    public String obtainArticlelst(@RequestBody Map<String,Integer> map){
        log.info("查询文章,请求参数:"+JSON.toJSONString(map));
       return federikArticlesService.findArticleLst(map.get("offset").longValue(),map.get("limit").longValue()).toString();
    }

    /**
     * 修改文章
     * @param articles
     * @return
     */
    @PostMapping(value = "/updateArticle")
    @ResponseBody
    public String updateStatus(@RequestBody articles articles){
        log.info("文章修改,请求参数:" + JSON.toJSONString(articles));
        return federikArticlesService.updateArticle(articles).toString();
    }

    /**
     * 删除文章
     * @param map
     * @return
     */
    @PostMapping(value = "/delArticle")
    @ResponseBody
    public String removeArticle(@RequestBody Map<String,Integer> map){
        log.info("文章删除,请求参数:" + JSON.toJSONString(map));
        return federikArticlesService.delArticle(map.get("articleId")).toString();
    }
}
