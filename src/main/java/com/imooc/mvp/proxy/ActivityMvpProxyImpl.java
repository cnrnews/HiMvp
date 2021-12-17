package com.imooc.mvp.proxy;

import com.imooc.mvp.base.BaseView;

public class ActivityMvpProxyImpl<V extends BaseView> extends MvpProxyImpl<V> implements ActivityMvpProxy {
    public ActivityMvpProxyImpl(V mView) {
        super(mView);
    }
}
