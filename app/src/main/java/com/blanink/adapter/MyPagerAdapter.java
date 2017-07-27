package com.blanink.adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blanink.R;
import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.PhotoPreview;

/**
 * Created by Administrator on 2017/6/16.
 */
//适配器
public class MyPagerAdapter extends PagerAdapter {
    private List<String> drawableLists;
    private Context context;

    public MyPagerAdapter(Context context, List<String> drawableLists) {
        this.context = context;
        this.drawableLists = drawableLists;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        ImageView imageView = new ImageView(context);

        if (drawableLists.size() > 0) {
            String path = drawableLists.get(position % drawableLists.size());
            Uri uri=null;
            if (path.contains("http://")) {
                uri  = Uri.parse(path);
            }else {
                uri=Uri.fromFile(new File(path));
            }
            Glide.with(context)
                    .load(uri)
                    .centerCrop()
                    .thumbnail(0.1f)
                    .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                    .error(R.drawable.__picker_ic_broken_image_black_48dp)
                    .into(imageView);

            // x.image().bind(imageView,drawableLists.get(position%drawableLists.size()));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            container.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> arrayList = new ArrayList<String>();
                    arrayList.addAll(drawableLists);
                    PhotoPreview.builder()
                            .setPhotos(arrayList)
                            .setCurrentItem(position % drawableLists.size())
                            .setShowDeleteButton(false)
                            .start((Activity) context);
                }
            });
        }
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View) object);
    }


}