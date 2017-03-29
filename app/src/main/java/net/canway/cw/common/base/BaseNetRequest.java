package net.canway.cw.common.base;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public abstract  class BaseNetRequest<T>  {
    //Type actualType = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    public T loadData(boolean parse) throws IOException {
        T t = null;
        t = loadDataFromNet(parse);
        if(t!=null) {
            return t;
        }
        return null;

    }

    public T loadDataFromNet(boolean parse) throws IOException {
        //创建网络加载类okhttp
        OkHttpClient client = new OkHttpClient();
        //获取对应的url地址
        String url = getURLString();
        //获取网络请求类
        Request request = new Request.Builder().get().url(url).build();
        Response response = client.newCall(request).execute();
        //通过respose来判断数据请求的状态
        if(response.isSuccessful()) {
            String result = response.body().string();
            if(parse) {
                T t = parseResult(result);
                return t;
            }else {
                return (T) result;
            }

        }
        return null;
    }

    public T parseResult(String result){
        //获取Gson对象
        Gson gson = new Gson();
        Type actualType = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Object o = gson.fromJson(result, actualType);
        return (T) o;
    }

    /**
     * 获取网络数据请求的url地址
     * @return url地址
     */
    protected abstract String getURLString();

}
