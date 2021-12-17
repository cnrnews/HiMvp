package com.imooc.mvp.demo.save;

import com.imooc.mvp.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class SavePresenter extends BasePresenter<SaveContract.SaveView,
        SaveContract.SaveModel> {

    public void getArticle(){
        getView().loading();
        List<SaveInfo> articleInfos = new ArrayList<>();
        articleInfos.add(new SaveInfo("秘密花园","大力苏"));
        articleInfos.add(new SaveInfo("秘密花园2","大力苏2"));
        getView().onSucceed(articleInfos);
    }
}
