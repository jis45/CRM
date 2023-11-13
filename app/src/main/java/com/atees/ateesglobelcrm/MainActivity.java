package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.atees.ateesglobelcrm.Adapter.SlidePagerAdapter;
import com.atees.ateesglobelcrm.Adapter.SpinnerAdapter;
import com.atees.ateesglobelcrm.Fragment.mainfragment1;
import com.atees.ateesglobelcrm.Fragment.mainfragment2;
import com.atees.ateesglobelcrm.Fragment.mainfragment3;
import com.atees.ateesglobelcrm.Fragment.mainfragment4;
import com.atees.ateesglobelcrm.List.SpinnerList;
import com.atees.ateesglobelcrm.Roomdatabase.AddlistViewModel;
import com.atees.ateesglobelcrm.Roomdatabase.RoomData;
import com.atees.ateesglobelcrm.Roomdatabase.RoomVewmodel;

import java.util.ArrayList;
import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;


    private ViewPager2 viewPager;
    private LinearLayout searchBTN, searchBAR, uploadnewItem;

    private Spinner spinner, spinnerleads;

    private SpinnerAdapter spinnerAdapter;

    private AddlistViewModel addlistViewModel;

    private Dialog dialog;

    private FragmentManager fragmentManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));


        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new mainfragment1());
        fragments.add(new mainfragment2());
        fragments.add(new mainfragment3());
        fragments.add(new mainfragment4());

         addlistViewModel= ViewModelProviders.of(this).get(AddlistViewModel.class);


        viewPager = findViewById(R.id.viewpaper);
        searchBTN = findViewById(R.id.search_btn);
        searchBAR = findViewById(R.id.search_bar);
        spinner = findViewById(R.id.spinner);
        spinnerleads = findViewById(R.id.leadsgen);
         String[] items={"","Generate Leads"};
        uploadnewItem = findViewById(R.id.newitemupload);
        dialog = new Dialog(MainActivity.this);

        ArrayAdapter<String>arrayAdapter =new ArrayAdapter<>(this, R.layout.customspinnerlead,items);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_drop_lead);
        spinnerleads.setAdapter(arrayAdapter);

        spinnerleads.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = items[position];

                if(selectedItem.length()==0){

                }
                else {
                    if (selectedItem.equals("Generate Leads")){

                        Intent intent=new Intent(MainActivity.this,GenrateLeadsActivity.class);
                        startActivity(intent);
                        finish();

                    }
                }








            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




//        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_leads, R.layout.customspinnerlead);
//        arrayAdapter.setDropDownViewResource(R.layout.spinner_drop_lead);
//        spinnerleads.setAdapter(arrayAdapter);
//        spinnerleads.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item =parent.getItemAtPosition(position).toString();
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        spinnerAdapter = new SpinnerAdapter(MainActivity.this, SpinnerList.getSpinnerList());
        spinner.setAdapter(spinnerAdapter);


        SlidePagerAdapter adapter = new SlidePagerAdapter(this, fragments);
        viewPager.setAdapter(adapter);
        searchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchBAR.getVisibility() == View.VISIBLE) {
                    searchBAR.setVisibility(View.GONE);
                } else {
                    searchBAR.setVisibility(View.VISIBLE);
                }


            }
        });

        uploadnewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//      View view=LayoutInflater.from(MainActivity.this).inflate(R.layout.pipeline_custom_layout,null);
                AddCustomAlert();

            }
        });
    }

    private void AddCustomAlert() {

        dialog.setContentView(R.layout.pipeline_custom_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        LinearLayout AddItems = dialog.findViewById(R.id.additem);
        LinearLayout EditItems, DeleteItems;
        EditItems = dialog.findViewById(R.id.edititem);
        DeleteItems = dialog.findViewById(R.id.deleteitem);

        DeleteItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });


    }

    public void additemClick(View view2) {
        final EditText organzation, opportunity, email, phonenumber, expRev;
        final TextView rateshow;
        final ProgressBar progressBar1;
        final RatingBar ratingBar;


        ratingBar = dialog.findViewById(R.id.ratingstar);
        organzation = dialog.findViewById(R.id.OrganizationET);
        opportunity = dialog.findViewById(R.id.OpportunityET);
        email = dialog.findViewById(R.id.EmailET);
        phonenumber = dialog.findViewById(R.id.PhonenumberET);
        expRev = dialog.findViewById(R.id.EXpectRevET);
        progressBar1 = dialog.findViewById(R.id.progressBAR);


        fragmentManager = getSupportFragmentManager();

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                StyleableToast.makeText(getApplicationContext(), "rating is  :" + rating, R.style.Toast).show();

                String rate = String.valueOf(rating);


            }
        });


        if (TextUtils.isEmpty(organzation.getText().toString())) {
            organzation.setError(" Organization  or Contact is requried");
            progressBar1.setVisibility(View.GONE);
            return;
        }
        if (TextUtils.isEmpty(opportunity.getText().toString())) {
            opportunity.setError(" Opportunity is requried");
            progressBar1.setVisibility(View.GONE);

            return;
        }
//        if (TextUtils.isEmpty(email.getText().toString())){
//            email.setError(" Email is requried");
//            progressBar1.setVisibility(View.GONE);
//
//            return;
//        }
//        if (TextUtils.isEmpty(phonenumber.getText().toString())){
//            phonenumber.setError(" Phone number is requried");
//            progressBar1.setVisibility(View.GONE);
//
//            return;
//        }
//        if (TextUtils.isEmpty(expRev.getText().toString())){
//            expRev.setError(" Expected Revenue is requried");
//            progressBar1.setVisibility(View.GONE);
//
//            return;
//        }


        Intent intent =new Intent(MainActivity.this,MainActivity.class);


        String orgstr = organzation.getText().toString().trim();
        String opportstr = opportunity.getText().toString().trim();
        String emailstr = email.getText().toString().trim();
//        int phonestr = Integer.parseInt(phonenumber.getText().toString());
//        int revstr = Integer.parseInt(expRev.getText().toString().trim());

        if (orgstr.isEmpty() || opportstr.isEmpty()) {
            StyleableToast.makeText(this, "please fill  all field", R.style.Toast).show();
        }
        addlistViewModel.insert(new RoomData(orgstr,opportstr));
        finish();
        startActivity(intent);
        finish();


    }
}








