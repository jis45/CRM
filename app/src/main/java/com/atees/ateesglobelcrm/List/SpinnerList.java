package com.atees.ateesglobelcrm.List;

import com.atees.ateesglobelcrm.Models.spinnerModel;
import com.atees.ateesglobelcrm.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerList {
    public  static List<spinnerModel>getSpinnerList(){
        List<spinnerModel>spinnerList =new ArrayList<>();

        spinnerModel Kanban =new spinnerModel();
        Kanban.setName("kanban");
        Kanban.setImage(R.drawable.baseline_align_vertical_top_24);
        spinnerList.add(Kanban);

        spinnerModel List =new spinnerModel();
        List.setName("List");
        List.setImage(R.drawable.list);
        spinnerList.add(List);

        spinnerModel Calender =new spinnerModel();
        Calender.setName(" Calender");
        Calender.setImage(R.drawable.calendar);
        spinnerList.add( Calender);

        spinnerModel Pivot =new spinnerModel();
        Pivot .setName("kanban");
        Pivot .setImage(R.drawable.pivot);
        spinnerList.add( Pivot );

        spinnerModel Graph =new spinnerModel();
        Graph.setName("Graph");
        Graph.setImage(R.drawable.graph);
        spinnerList.add(Graph);

        spinnerModel Map =new spinnerModel();
        Map.setName("Map");
        Map.setImage(R.drawable.map);
        spinnerList.add(Map);

        spinnerModel Activity =new spinnerModel();
        Activity.setName("Activity");
        Activity.setImage(R.drawable.baseline_align_vertical_top_24);
        spinnerList.add(Activity);

         return spinnerList;
    }
}
