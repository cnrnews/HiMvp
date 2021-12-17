package com.imooc.mvp.proxy;

import com.imooc.mvp.base.BasePresenter;
import com.imooc.mvp.base.BaseView;
import com.imooc.mvp.inject.InjectPresenter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MvpProxyImpl<V extends BaseView> implements IMvpProxy{

    private V mView;
    private List<BasePresenter> mPresenters;

    public MvpProxyImpl(V mView) {
        this.mView = mView;
        mPresenters = new ArrayList<>();
    }

    @Override
    public void bindAndCreatePresenter() {
        Field[] fields = mView.getClass().getDeclaredFields();
        for (Field field : fields) {

            InjectPresenter annotation = field.getAnnotation(InjectPresenter.class);
            if (annotation!=null){
                // 创建注入
                Class<? extends BasePresenter> presenterClazz = null;
                try {
                    presenterClazz = (Class<? extends BasePresenter>) field.getType();
                }catch (Exception e){
                    // 防止错误的注入
                    throw new RuntimeException("no support inject presenter type!");
                }
                try {
                    BasePresenter basePresenter = presenterClazz.newInstance();
                    basePresenter.attach(mView);
                    // 设置
                    field.setAccessible(true);
                    field.set(mView,basePresenter);
                    mPresenters.add(basePresenter);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void unbindPresenter() {
        for (BasePresenter presenter : mPresenters) {
            presenter.detach();
        }
        mView=null;
    }
}
