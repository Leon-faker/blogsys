package com.federik.controller;

import com.alibaba.fastjson.JSON;
import com.federik.mapper.dto.articlesType;
import com.federik.services.FederikArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping(value = "/articleType")
public class netBloggerArticleTypeCtrl {

    @Resource
    private FederikArticleTypeService federikArticleTypeService;

    @PostMapping(value = "/findAll")
    @ResponseBody
    public String findArticleType(@RequestBody Map<String,Integer> map){
        log.info("查询文章类型列表【Controller】，请求参数:"+ JSON.toJSONString(map));
         return federikArticleTypeService.findAll(map.get("offset").longValue(),map.get("limit").longValue()).toString();
    }

    @PostMapping(value = "/addArticleType")
    @ResponseBody
    public String addArticle(@RequestBody articlesType articleType){
        log.info("新增文章类型列表【Controller】，请求参数:"+ JSON.toJSONString(articleType));
        return federikArticleTypeService.addArticleType(articleType).toString();
    }

    @PostMapping(value = "/updateArticleType")
    @ResponseBody
    public String updateArticleType(@RequestBody articlesType articleType){
        log.info("修改文章类型列表【Controller】，请求参数:"+ JSON.toJSONString(articleType));
        return federikArticleTypeService.updateArticleType(articleType).toString();
    }

    @PostMapping(value = "/removeArticleType")
    @ResponseBody
    public String removeArticleType(@RequestBody Map<String,Integer> map){
        log.info("删除文章类型列表【Controller】，请求参数:"+ JSON.toJSONString(map));
        return federikArticleTypeService.removeArticleType(map.get("articleTypeId")).toString();
    }
}
