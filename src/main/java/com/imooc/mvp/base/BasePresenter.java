package com.imooc.mvp.base;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

public class BasePresenter<V extends BaseView,M extends BaseModel> {


    private V mView,mProxyView;
    // 动态创建的model
    private M mModel;

    public void attach(V view) {
        mView = view;
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (mView == null){
                    return null;
                }
                // 没解绑执行的是原始被代理 View的方法
                return method.invoke(mView,args);
            }
        });

        // 通过反射获取model 对象
        Type superclass = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) superclass).getActualTypeArguments();
        try {
            mModel  = (M) ((Class) typeArguments[1]).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public void detach() {
        mView = null;
    }

    public V getView() {
        return mProxyView;
    }

    public M getModel() {
        return mModel;
    }
}
