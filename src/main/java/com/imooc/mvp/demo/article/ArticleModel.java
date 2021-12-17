package com.imooc.mvp.demo.article;

public class ArticleModel   implements ArticleContract.ArticleModel {
    @Override
    public ArticleInfo getArticle() {
        return new ArticleInfo("秘密花园","大力苏");
    }
}
