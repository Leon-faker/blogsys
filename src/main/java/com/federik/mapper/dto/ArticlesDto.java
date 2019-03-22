package com.federik.mapper.dto;

public class ArticlesDto {
    //文章Id
    private Integer articleId;
    //文章名称
    private String articleName;
    //文章作者
    private String articleAuthor;
    //可见状态
    private String articleStatus;
    //点赞数
    private Integer articleLikeNum;
    //阅读数
    private Integer articleReadNum;
    //文章类型id
    private Integer articleTypeId;
    //文章创建时间
    private String articleCrTime;


    public ArticlesDto(Integer articleId, String articleName, String articleAuthor, String articleStatus, Integer articleLikeNum, Integer articleReadNum, Integer articleTypeId, String articleCrTime) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleAuthor = articleAuthor;
        this.articleStatus = articleStatus;
        this.articleLikeNum = articleLikeNum;
        this.articleReadNum = articleReadNum;
        this.articleTypeId = articleTypeId;
        this.articleCrTime = articleCrTime;
    }

    public ArticlesDto(){};

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getArticleLikeNum() {
        return articleLikeNum;
    }

    public void setArticleLikeNum(Integer articleLikeNum) {
        this.articleLikeNum = articleLikeNum;
    }

    public Integer getArticleReadNum() {
        return articleReadNum;
    }

    public void setArticleReadNum(Integer articleReadNum) {
        this.articleReadNum = articleReadNum;
    }

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleCrTime() {
        return articleCrTime;
    }

    public void setArticleCrTime(String articleCrTime) {
        this.articleCrTime = articleCrTime;
    }


}
