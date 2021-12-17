# HiMvp

#### 介绍
搭建基础MVP 框架 

#### 使用说明

1.  创建Contract

```
public class ArticleContract {
    public interface  ArticleView extends BaseView {
        void onSucceed(ArticleInfo articleInfo);
    }
    public interface ArticleModel extends BaseModel{
       void ArticleInfo getArticle();
    }
}

```

2.  实现自己的Model数据访问类

```
public class ArticleModel   implements ArticleContract.ArticleModel {
    @Override
    public ArticleInfo getArticle() {
        return new ArticleInfo("秘密花园","大力苏");
    }
}

```

3.  创建 Prensenter

```
public class ArticlePresenter extends BasePresenter<ArticleContract.ArticleView,
        ArticleContract.ArticleModel> {

    public void getArticle(){
        getView().loading();
        ArticleInfo articleInfo= new ArticleInfo("秘密花园","大力苏");

        getView().onSucceed(articleInfo);
    }
}
```
4.  实现Activity

```
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
        // 请求数据
        articlePresenter.getArticle();
        savePresenter.getArticle();
    }
    @Override
    protected void initView() {
        mTextView = findViewById(R.id.net_tv);
    }
    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_mvp);
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
```


