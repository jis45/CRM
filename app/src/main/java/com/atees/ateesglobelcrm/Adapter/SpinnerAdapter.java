package com.atees.ateesglobelcrm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atees.ateesglobelcrm.Models.spinnerModel;
import com.atees.ateesglobelcrm.R;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
    private Context context;
    private List<spinnerModel>spinnerModelList;

    public SpinnerAdapter(Context context, List<spinnerModel> spinnerModelList) {
        this.context = context;
        this.spinnerModelList = spinnerModelList;
    }

    @Override
    public int getCount() {
        return spinnerModelList !=null? spinnerModelList.size():0;
    }


    @Override
    public Object getItem(int position) {
        return position;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView=LayoutInflater.from(context).inflate(R.layout.custom_spinner,parent,false);
        TextView textView=rootView.findViewById(R.id.tvCustomSpinner);
        ImageView imageView=rootView.findViewById(R.id.ivCustomSpinner);

        textView.setText(spinnerModelList.get(position).getName());
        imageView.setImageResource(spinnerModelList.get(position).getImage());


        return rootView;
    }
}
