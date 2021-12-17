package com.imooc.mvp.demo;

import android.util.Log;
import android.widget.TextView;

import com.imooc.mvp.BaseMvpActivity;
import com.imooc.mvp.demo.article.ArticleContract;
import com.imooc.mvp.demo.article.ArticleInfo;
import com.imooc.mvp.demo.article.ArticlePresenter;
import com.imooc.mvp.demo.save.SaveContract;
import com.imooc.mvp.demo.save.SaveInfo;
import com.imooc.mvp.demo.save.SavePresenter;
import com.imooc.mvp.inject.InjectPresenter;

import java.util.List;

/**
 * MVP 封装
 */
public class TestMvpActivity extends BaseMvpActivity  implements ArticleContract.ArticleView,
SaveContract.SaveView{

    private TextView mTextView;

    //  多 Presenter 处理？ 使用注解
    @InjectPresenter
    ArticlePresenter articlePresenter;
    @InjectPresenter
    SavePresenter savePresenter;

    @Override
    protected void initData() {
        articlePresenter.getArticle();
        savePresenter.getArticle();
    }
    @Override
    protected void initView() {
//        mTextView = findViewById(R.id.net_tv);
    }
    @Override
    protected void setContentView() {
//        setContentView(R.layout.activity_mvp);
    }

    @Override
    public void loading() {
        // 显示加载进度
        Log.e("TAG","loading");
    }

    @Override
    public void onError() {
        // 加载错误
        Log.e("TAG","onError");
    }

    /**
     * 加载成功
     * @param articleInfo
     */
    @Override
    public void onSucceed(ArticleInfo articleInfo) {
        mTextView.setText(articleInfo.toString());
    }

    @Override
    public void onSucceed(List<SaveInfo> articleInfos) {
        StringBuffer sb  = new StringBuffer();
        for (SaveInfo articleInfo : articleInfos) {
            sb.append(articleInfos.toString());
            sb.append("\n");
        }
        mTextView.setText(sb.toString());
    }
}
