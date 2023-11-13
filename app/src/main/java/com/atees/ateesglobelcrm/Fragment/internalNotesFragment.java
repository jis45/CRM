package com.atees.ateesglobelcrm.Fragment;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.atees.ateesglobelcrm.Adapter.SpinnerHeaderAdapter;
import com.atees.ateesglobelcrm.List.SpinnnerListHeader;
import com.atees.ateesglobelcrm.R;

import java.util.ArrayList;

public class internalNotesFragment extends Fragment {
    TextView underline ,crossline,HeaderText;

    Context context;

    Spinner HeaderSpinner;
    SpinnerHeaderAdapter spinnerHeaderAdapter;





    public internalNotesFragment() {

    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_internal_notes, container, false);
        HeaderSpinner=view.findViewById(R.id.headerSpinner);
        spinnerHeaderAdapter =new SpinnerHeaderAdapter(getActivity().getApplicationContext(),internalNotesFragment.this, SpinnnerListHeader.getSpinnerheaderList());
        HeaderSpinner.setAdapter(spinnerHeaderAdapter);
        HeaderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        underline=view.findViewById(R.id.underlineU);
        crossline=view.findViewById(R.id.crossline);
        SpannableString content = new SpannableString( "U " ) ;
        content.setSpan( new UnderlineSpan() , 0 , content.length() , 0 ) ;
        underline.setText(content) ;

        crossline.setPaintFlags(crossline.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        return view;
    }
}