package com.imooc.mvp.proxy;

public interface IMvpProxy {
    // 创建并绑定
    void bindAndCreatePresenter();
    // 解绑
    void unbindPresenter();
}
