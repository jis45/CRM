package com.atees.ateesglobelcrm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.atees.ateesglobelcrm.Adapter.EditinteralnotAdapter;
import com.google.android.material.tabs.TabLayout;

public class Edit_room_Activity extends AppCompatActivity {

    LinearLayout newButtonclick;
    TextView newtext;

    TabLayout tabLayout;
     ViewPager2 viewPager2;
     EditinteralnotAdapter editinteralnotAdapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_room);
        Window window = Edit_room_Activity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(Edit_room_Activity.this, R.color.colorPrimary));

        newButtonclick=findViewById(R.id.newbuttonclick);
        newtext=findViewById(R.id.newtext);
        tabLayout=findViewById(R.id.tablayout);
        viewPager2=findViewById(R.id.viewpaper);

        tabLayout.addTab(tabLayout.newTab().setText("Internal Notes"));
        tabLayout.addTab(tabLayout.newTab().setText("Extra information"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        FragmentManager fragmentManager=getSupportFragmentManager();
        editinteralnotAdapter =new EditinteralnotAdapter(fragmentManager,getLifecycle());
        viewPager2.setAdapter(editinteralnotAdapter);
//        int tabBgColor=ContextCompat.getColor(Edit_room_Activity.this,R.color.colorPrimary);
//        tabLayout.getTabAt(0).getIcon().setColorFilter(tabBgColor,PorterDuff.Mode.SRC_IN);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
                tab.view.setBackground(getResources().getDrawable(R.drawable.latout_new_box_line));


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.view.setBackgroundColor(Color.TRANSPARENT);



            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageSelected(int position) {
               tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });




    }

    public void addnewClick(View view) {
        newButtonclick.setBackground(ContextCompat.getDrawable(this,R.drawable.layout_new_box_line_bg));
        newtext.setTextColor(ContextCompat.getColor(this,R.color.white));
    }
}