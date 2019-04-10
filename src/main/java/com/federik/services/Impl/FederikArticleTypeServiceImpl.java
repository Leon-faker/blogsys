package com.federik.services.Impl;

import com.federik.common.utils.CommUtils;
import com.federik.controller.vo.ResultEncapsulationVO;
import com.federik.mapper.articlesTypeMapper;
import com.federik.mapper.dto.articlesType;
import com.federik.mapper.dto.articlesTypeExample;
import com.federik.services.FederikArticleTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class FederikArticleTypeServiceImpl implements FederikArticleTypeService {

    @Resource
    private articlesTypeMapper articleTypeMapperDao;

    @Override
    public ResultEncapsulationVO findAll(Long offset, Long limit) {
        log.info("查找文章类型列表【Service】");
        try {

            if(limit == 0){
                return  ResultEncapsulationVO.fail("limit不能为0");
            }
            articlesTypeExample articleTypeEx = new articlesTypeExample();
            articleTypeEx.setOrderByClause(" article_type_id LIMIT "+offset+","+limit);

            List<articlesType> articleTypelst = articleTypeMapperDao.selectByExample(articleTypeEx);
            return ResultEncapsulationVO.success("请求成功").setData(articleTypelst);
        }catch (Exception e){
            log.error("查询出现异常");
            return ResultEncapsulationVO.fail("查询出现异常");
        }
    }

    @Override
    public ResultEncapsulationVO addArticleType(articlesType articlesType) {
        log.info("新增文章类型【Service】");
        if(CommUtils.isNull(articlesType)){
            return  ResultEncapsulationVO.fail("参数不能为null");
        }
        articlesType.setArticleCrTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
            int sqlResult = articleTypeMapperDao.insertSelective(articlesType);
            return  sqlResult > 0?ResultEncapsulationVO.success("添加成功"):ResultEncapsulationVO.fail("添加失败");
        }catch (Exception e){
            log.error("新增文章类型异常:"+e.getMessage());
            return ResultEncapsulationVO.fail("新增文章类型异常:"+e.getMessage());
        }
    }

    @Override
    public ResultEncapsulationVO updateArticleType(articlesType articleType) {
        log.info("修改文章类型【Service】");
        if(CommUtils.isNull(articleType)){
            return  ResultEncapsulationVO.fail("articlesType 不能为空");
        }

        if(CommUtils.isNull(articleType.getArticleTypeId())){
            return  ResultEncapsulationVO.fail("articlesTypeId 不能为空");
        }

        try{
            int sqlResult = articleTypeMapperDao.updateByPrimaryKeySelective(articleType);
            return  sqlResult > 0?ResultEncapsulationVO.success("修改成功"):ResultEncapsulationVO.fail("修改失败");
        }catch (Exception e){
            log.error("修改文章类型异常:"+e.getMessage());
            return ResultEncapsulationVO.fail("修改文章类型异常:"+e.getMessage());
        }
    }

    @Override
    public ResultEncapsulationVO removeArticleType(Integer articleTypeId) {
        log.info("删除文章类型【Service】");

        if(CommUtils.isNull(articleTypeId)){
            return  ResultEncapsulationVO.fail("articlesTypeId 不能为空");
        }

        try{
            int sqlResult = articleTypeMapperDao.deleteByPrimaryKey(articleTypeId);
            return  sqlResult > 0?ResultEncapsulationVO.success("删除成功"):ResultEncapsulationVO.fail("删除失败");
        }catch (Exception e){
            log.error("删除文章类型异常:"+e.getMessage());
            return ResultEncapsulationVO.fail("删除文章类型异常:"+e.getMessage());
        }
    }
}
