package com.federik.mapper.dto;

public class ArticleType {
    private Integer articleTypeId;

    private String articleTypeName;

    private String articleCrTime;

    public Integer getArticleTypeId() {
        return articleTypeId;
    }

    public void setArticleTypeId(Integer articleTypeId) {
        this.articleTypeId = articleTypeId;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public String getArticleCrTime() {
        return articleCrTime;
    }

    public void setArticleCrTime(String articleCrTime) {
        this.articleCrTime = articleCrTime;
    }
}