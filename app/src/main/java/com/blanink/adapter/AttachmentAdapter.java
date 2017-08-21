package com.blanink.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blanink.R;
import com.blanink.utils.CommonUtil;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

import me.iwf.photopicker.utils.AndroidLifecycleUtils;

/**
 * Created by donglua on 15/5/31.
 */
public class AttachmentAdapter extends RecyclerView.Adapter<AttachmentAdapter.PhotoViewHolder> {

    private ArrayList<String> photoPaths = new ArrayList<String>();
    private LayoutInflater inflater;

    private Context mContext;

/*
  public final static int TYPE_ADD = 1;
  final static int TYPE_PHOTO = 2;
*/

    public final static int MAX = 9;

    public AttachmentAdapter(Context mContext, ArrayList<String> photoPaths) {
        this.photoPaths = photoPaths;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);

    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        itemView = inflater.inflate(R.layout.item_attachment, parent, false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PhotoViewHolder holder, final int position) {

        Uri uri = null;
        if (photoPaths.get(position).endsWith(".gif")
                || photoPaths.get(position).endsWith(".png")
                || photoPaths.get(position).endsWith(".jpg")
                || photoPaths.get(position).endsWith(".jpeg")
                || photoPaths.get(position).endsWith(".bmp")
            ||photoPaths.get(position).endsWith(".GIF")
                    || photoPaths.get(position).endsWith(".PNG")
                    || photoPaths.get(position).endsWith(".JPG")
                    || photoPaths.get(position).endsWith(".JPEG")
                    || photoPaths.get(position).endsWith(".BMP")
                ){
            uri = Uri.parse(photoPaths.get(position));

            boolean canLoadImage = AndroidLifecycleUtils.canLoadImage(holder.ivPhoto.getContext());
            if (canLoadImage) {
                Glide.with(mContext)
                        .load(uri)
                        .centerCrop()
                        .thumbnail(0.1f)
                        .placeholder(R.mipmap.load)
                        .error(R.drawable.fail)
                        .into(holder.ivPhoto);
            }
        }/*else if (photoPaths.get(position).endsWith(".gif")){
            holder.ivPhoto.setImageResource(R.drawable.gif);


        }*/else if (photoPaths.get(position).endsWith(".doc")
                || photoPaths.get(position).endsWith(".docx")
        ||photoPaths.get(position).endsWith(".DOC")
                || photoPaths.get(position).endsWith(".DOCX")) {
            holder.ivPhoto.setImageResource(R.drawable.word);

        } else if (photoPaths.get(position).endsWith(".ppt")
                || photoPaths.get(position).endsWith(".pptx")||photoPaths.get(position).endsWith(".PPT")
                || photoPaths.get(position).endsWith(".PPTX")) {

            holder.ivPhoto.setImageResource(R.drawable.ppt);
        } else if (photoPaths.get(position).endsWith(".pdf")||photoPaths.get(position).endsWith(".PDF")) {

            holder.ivPhoto.setImageResource(R.drawable.pdf);


        } else if (photoPaths.get(position).endsWith(".xls")
                || photoPaths.get(position).endsWith(".xlsx")||photoPaths.get(position).endsWith(".XLS")
                || photoPaths.get(position).endsWith(".XLSX")) {

            holder.ivPhoto.setImageResource(R.drawable.xml);


        } else if (photoPaths.get(position).endsWith(".zip")
                || photoPaths.get(position).endsWith(".gizp")||
                photoPaths.get(position).endsWith(".ZIP")
                || photoPaths.get(position).endsWith(".GZIP")) {
            holder.ivPhoto.setImageResource(R.drawable.zip);

        }else {
            holder.ivPhoto.setImageResource(R.drawable.unknow);
        }
        if(photoPaths.get(position)!=null &&!photoPaths.get(position).equals("")){
            Log.e("Attach",photoPaths.get(position).toString());
            holder.tv_name.setText(CommonUtil.getFileName(photoPaths.get(position))+ CommonUtil.getFileLastName(photoPaths.get(position)));
        }
    }


    @Override
    public int getItemCount() {
        int count = photoPaths.size();
        if (count > MAX) {
            count = MAX;
        }
        return count;
    }


    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tv_name;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            ivPhoto = (ImageView) itemView.findViewById(R.id.iv_icon);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);

        }

    }
}
