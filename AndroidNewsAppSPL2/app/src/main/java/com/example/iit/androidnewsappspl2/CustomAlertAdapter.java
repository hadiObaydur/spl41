package com.example.iit.androidnewsappspl2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 */

public class CustomAlertAdapter extends BaseAdapter {

    Context ctx = null;
    ArrayList<String> list = null;

    private LayoutInflater mInflater = null;

    public CustomAlertAdapter(Activity activty, ArrayList<String> list) {
        this.ctx=activty;
        mInflater = activty.getLayoutInflater();
        this.list =list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override

    public Object getItem(int arg0) {

        return null;

    }


    @Override

    public long getItemId(int arg0) {

        return 0;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup arg2) {

        final ViewHolder holder;

        if (convertView == null ) {
            holder = new ViewHolder();
            convertView = (View) mInflater.inflate(R.layout.list_view_for_all_language, null);
            holder.titlename = (TextView) convertView.findViewById(R.id.textView_titllename);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        String datavalue= list.get(position);
        holder.titlename.setText(datavalue);
        return convertView;
    }
    private static class ViewHolder {

        TextView titlename;

    }

}