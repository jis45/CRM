package com.atees.ateesglobelcrm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atees.ateesglobelcrm.Fragment.internalNotesFragment;
import com.atees.ateesglobelcrm.Models.spinnerheaderModel;
import com.atees.ateesglobelcrm.R;

import java.util.List;

public class SpinnerHeaderAdapter extends BaseAdapter {

    private Context context;
    private List<spinnerheaderModel> spinnerheaderModelList;

    public SpinnerHeaderAdapter(Context context, internalNotesFragment internalNotesFragment, List<spinnerheaderModel> spinnerheaderModelList) {
        this.context = context;
        this.spinnerheaderModelList = spinnerheaderModelList;
    }

    @Override
    public int getCount() {
        return spinnerheaderModelList !=null? spinnerheaderModelList.size():0;
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
        View rootView=LayoutInflater.from(context).inflate(R.layout.layout_spinner_header,parent,false);
        TextView textView=rootView.findViewById(R.id.headername);
        textView.setText(spinnerheaderModelList.get(position).getHeadername());

        return rootView;
    }
}
