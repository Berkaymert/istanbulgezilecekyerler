package com.example.berkaymert.stanbulgezilecekyerler;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class MyAdapter extends ArrayAdapter<String> {

    String[] names;
    TypedArray flags;
    Context mContext;

    public MyAdapter( Context context, String[] countryNames,TypedArray imgs ) {
        super(context, R.layout.listview_item);
        this.names=countryNames;
        this.flags=imgs;
        this.mContext=context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView ,ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mFlag = (ImageView) convertView.findViewById(R.id.imageView2);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        }else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.mFlag.setImageResource(flags.getResourceId(position, -1));
        mViewHolder.mName.setText(names[position]);
        return convertView;

    }
    static class ViewHolder {
        ImageView mFlag;
        TextView mName;
    }
}
