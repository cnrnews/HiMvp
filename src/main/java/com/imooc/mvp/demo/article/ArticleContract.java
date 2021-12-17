package com.imooc.mvp.demo.article;

import com.imooc.mvp.base.BaseModel;
import com.imooc.mvp.base.BaseView;

public class ArticleContract {
    public interface   ArticleView extends BaseView {
        void onSucceed(ArticleInfo articleInfo);
    }
    public interface ArticleModel extends BaseModel{
       abstract ArticleInfo getArticle();
    }
}
