package com.qf.sxy.baiduweatheraaa;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.qf.sxy.baiduweatheraaa.bean.MainBean;
import com.qf.sxy.baiduweatheraaa.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private EditText etCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        //设置DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);
       // etCity = ((EditText) findViewById(R.id.et_city));
        binding.setMainBean(new MainBean());


    }

//    //点击事件
//    public void MyWeatherClick(View view) {
//        String city = etCity.getText().toString().trim();
//        if(TextUtils.isEmpty(city)){
//            Toast.makeText(MainActivity.this,"请输入城市名称",Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
//        intent.putExtra("city",city);
//        startActivity(intent);
//    }
}
