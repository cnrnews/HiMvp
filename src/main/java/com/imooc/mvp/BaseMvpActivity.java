package com.imooc.mvp;

import android.os.Bundle;

import com.imooc.mvp.base.BasePresenter;
import com.imooc.mvp.base.BaseView;
import com.imooc.mvp.inject.InjectPresenter;
import com.imooc.mvp.proxy.ActivityMvpProxy;
import com.imooc.mvp.proxy.ActivityMvpProxyImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//<P extends BasePresenter>
public abstract class BaseMvpActivity extends AppCompatActivity implements BaseView {

    private ActivityMvpProxy mMvpProxy;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView();

        // 交给子类去实现各自的 Presenter
        mMvpProxy = createMvpProxy();
        mMvpProxy.bindAndCreatePresenter();

        initView();
        initData();
    }

    private ActivityMvpProxy createMvpProxy() {
        if (mMvpProxy==null){
            mMvpProxy = new ActivityMvpProxyImpl<>(this);
        }
        return mMvpProxy;
    }

//    protected abstract P createPresenter();
    protected abstract void initData();
    protected abstract void initView();
    protected abstract void setContentView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMvpProxy.unbindPresenter();
//        mPresenter.detach();
    }

//    public P getPresenter() {
//        return mPresenter;
//    }
}
