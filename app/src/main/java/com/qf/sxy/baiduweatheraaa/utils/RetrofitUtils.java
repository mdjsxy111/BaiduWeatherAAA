package com.qf.sxy.baiduweatheraaa.utils;


import com.qf.sxy.baiduweatheraaa.bean.Bean;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * Created by sxy on 2016/10/19.
 */
public class RetrofitUtils {

    public static RetrofitService retrofitService;

    public static void initService() {
        retrofitService = new Retrofit.Builder()
                .baseUrl("http://api.map.baidu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    public static  RetrofitService getRetrofitService(){
        return retrofitService;
    }
    public interface RetrofitService {
        @GET("telematics/v3/weather?output=json&ak=FkPhtMBK0HTIQNh7gG4cNUttSTyr0nzo")
        Call<Bean> getWeatherBean(@Query("location") String city);

    }


}
