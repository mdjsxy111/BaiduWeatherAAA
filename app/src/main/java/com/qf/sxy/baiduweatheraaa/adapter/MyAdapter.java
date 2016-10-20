package com.qf.sxy.baiduweatheraaa.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qf.sxy.baiduweatheraaa.BR;
import com.qf.sxy.baiduweatheraaa.R;
import com.qf.sxy.baiduweatheraaa.bean.Bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sxy on 2016/10/20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  {


    private List<Bean.ResultsBean.WeatherDataBean> beans;

    public static MyAdapter getInstance(List<Bean.ResultsBean.WeatherDataBean> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        return new MyAdapter(list);
    }
    public MyAdapter(List<Bean.ResultsBean.WeatherDataBean> beans) {
        this.beans = beans;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());
        ;
        return new ViewHolder(DataBindingUtil.inflate(inflater, R.layout.item,parent,false));
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //绑定数据
        //onBindViewHolder中设置layout中定义的movie变量值
        Bean.ResultsBean.WeatherDataBean weatherDataBean = beans.get(position);

        holder.binding.setVariable(BR.WeatherDataBean,weatherDataBean);
        holder.binding.executePendingBindings();
    }



//    @Override
//    public int getItemViewType(int position) {
//        return R.layout.item;
//    }
    @Override
    public int getItemCount() {
        return beans.size();
    }

    public static  class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding binding;
        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
