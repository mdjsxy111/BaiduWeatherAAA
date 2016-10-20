package com.qf.sxy.baiduweatheraaa;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.qf.sxy.baiduweatheraaa.bean.Bean;
import com.qf.sxy.baiduweatheraaa.databinding.ActivityWeatherBinding;
import com.qf.sxy.baiduweatheraaa.utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity implements Callback<Bean> {
    ActivityWeatherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_weather);
       //Wa DataBindingUtil.setContentView(this,R.layout.activity_weather);
        binding= DataBindingUtil.setContentView(WeatherActivity.this, R.layout.activity_weather);
        String city = getIntent().getStringExtra("city");
        Log.e("AA", "==>" + city);
        //开启网络加载
        RetrofitUtils.initService();
        RetrofitUtils.getRetrofitService().getWeatherBean(city).enqueue(this);
    }

    @Override
    public void onResponse(Call<Bean> call, Response<Bean> response) {
        //请求成功
        Log.e("AAA", "==>" + response.body().toString());

        //下载数据更新数据到实体类
        binding.setWeather(response.body());
    }

    @Override
    public void onFailure(Call<Bean> call, Throwable t) {
        //请求失败
        Log.e("AAA", "=失败=>");
    }




}
