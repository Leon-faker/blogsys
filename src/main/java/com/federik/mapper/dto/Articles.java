package com.federik.mapper.dto;

public class Articles {
    private Integer articleId;

    private String articleName;

    private String articleAuthor;

    private Byte articleStatus;

    private Integer articleLikeNum;

    private Integer articleReadNum;

    private Integer articleTypeId;

    private String articleCrTime;

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

    public Byte getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(Byte articleStatus) {
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