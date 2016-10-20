package com.qf.sxy.baiduweatheraaa.bean;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.qf.sxy.baiduweatheraaa.WeatherActivity;

/**
 * Created by sxy on 2016/10/19.
 */
public class MainBean {
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //点击事件
    public void MyWeatherClick(Context context) {
        //String city = etCity.getText().toString().trim();
        if(TextUtils.isEmpty(city)){
            Toast.makeText(context,"请输入城市名称",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(context,WeatherActivity.class);
        intent.putExtra("city",city);
        context.startActivity(intent);
    }

}
