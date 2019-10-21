package com.zh.smooth;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create by zj on 2019/10/16
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder> {

    private Context mContext;
    private List<String> list;
    public PhotoAdapter(Context context, List<String> list){
        this.list=list;
        this.mContext=context;
    }
    @NonNull
    @Override
    public PhotoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_avatar_value,null);
        PhotoHolder photoHolder=new PhotoHolder(view);
        return photoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoHolder photoHolder, int i) {
        if (photoHolder!=null&&photoHolder.imageView!=null){
            Glide.with(mContext).load(list.get(i%list.size())).transform(new CircleCrop()).into(photoHolder.imageView);
        }
    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }


    public class PhotoHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_avatar)
        ImageView imageView;
        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
