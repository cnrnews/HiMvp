package com.imooc.mvp.demo.save;

import com.imooc.mvp.base.BaseModel;
import com.imooc.mvp.base.BaseView;

import java.util.List;

public class SaveContract {
    public interface SaveView extends BaseView {
        void onSucceed(List<SaveInfo> articleInfos);
    }
    public interface SaveModel extends BaseModel{
       List<SaveInfo> getArticle();
    }
}
