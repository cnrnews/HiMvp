package com.imooc.mvp.demo.article;

import com.imooc.mvp.base.BasePresenter;

public class ArticlePresenter extends BasePresenter<ArticleContract.ArticleView,
        ArticleContract.ArticleModel> {

    public void getArticle(){
        getView().loading();
        ArticleInfo articleInfo= new ArticleInfo("秘密花园","大力苏");

        getView().onSucceed(articleInfo);
    }
}
