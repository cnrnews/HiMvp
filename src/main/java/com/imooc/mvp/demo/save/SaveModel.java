package com.imooc.mvp.demo.save;

import java.util.ArrayList;
import java.util.List;

public class SaveModel implements SaveContract.SaveModel {
    @Override
    public  List<SaveInfo> getArticle() {
        List<SaveInfo> articleInfos = new ArrayList<>();
        articleInfos.add(new SaveInfo("秘密花园","大力苏"));
        articleInfos.add(new SaveInfo("秘密花园2","大力苏2"));
        return articleInfos;
    }
}
