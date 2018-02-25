package com.elmahalwy.thirdproject.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.elmahalwy.thirdproject.Models.MainModel;
import com.elmahalwy.thirdproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cz on 23/02/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<MainModel> main_list = new ArrayList<>();
    Context context;
    LayoutInflater layoutInflater;

    public MainAdapter(List<MainModel> main_list, Context context) {
        this.main_list = main_list;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == 0) {

        }
    }

    @Override
    public int getItemCount() {
        return main_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_main)
        TextView tv_main;
        @BindView(R.id.iv_main_pic)
        ImageView iv_main_pic;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
