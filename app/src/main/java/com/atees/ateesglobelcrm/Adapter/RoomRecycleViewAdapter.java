package com.atees.ateesglobelcrm.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atees.ateesglobelcrm.Edit_room_Activity;
import com.atees.ateesglobelcrm.GenrateLeadsActivity;
import com.atees.ateesglobelcrm.R;
import com.atees.ateesglobelcrm.Roomdatabase.RoomData;
import com.atees.ateesglobelcrm.Roomdatabase.RoomVewmodel;

import java.util.ArrayList;
import java.util.List;

public class RoomRecycleViewAdapter extends RecyclerView.Adapter<RoomRecycleViewAdapter.RoomViewHolder> implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private List<RoomData>RoomDatalist = new ArrayList<>();
    private Context context;
//    private  OnItemclicKlistener listener;

    public  void setContext(Context context){
        this.context=context;
    }


    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.add_item_layout,parent,false);
        this.context=context;

        return new RoomViewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        RoomData roomData=RoomDatalist.get(position);
        holder.organization.setText(roomData.getOrganization());
        holder.opportunity.setText(roomData.getOpportunity());
        holder.opptunityname.setText(roomData.getOpportunity());
        holder.Menu.setOnClickListener(this);
        holder.timmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "timer", Toast.LENGTH_SHORT).show();


            }
        });
        holder.opptunityname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Name", Toast.LENGTH_SHORT).show();

            }
        });


    }

    public  void  setDataBase(List<RoomData>roomData){
        RoomDatalist=roomData;
        notifyDataSetChanged();
    }




    @Override
    public int getItemCount() {
        return RoomDatalist.size();
    }


    @Override
    public void onClick(View v) {
        showPopupMenu(v);

    }

    private void showPopupMenu(View v) {

        PopupMenu popupMenu =new PopupMenu(v.getContext(),v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener( this);


    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.deleteditem) {

//            Intent intent=new Intent(context.getApplicationContext(),GenrateLeadsActivity.class);
//               context.startActivity(intent);
//            Toast.makeText(context.getApplicationContext(), "delete", Toast.LENGTH_SHORT).show();

            return true;

        } else if (id == R.id.editeditem) {
//            Toast.makeText(context.getApplicationContext(), "edit", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(context.getApplicationContext(), Edit_room_Activity.class);
               context.startActivity(intent);
            return true;
        }

        return false;

    }

    public static class RoomViewHolder extends  RecyclerView.ViewHolder{
       public  TextView opportunity,organization,opptunityname;

       public RatingBar ratingBar;
       public ImageView Menu,timmer;



        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);

            opportunity=itemView.findViewById(R.id.Opportunity);
            organization=itemView.findViewById(R.id.OrganizationContact);
            opptunityname=itemView.findViewById(R.id.Opportunityname);
            ratingBar=itemView.findViewById(R.id.ratingstar);
            Menu=itemView.findViewById(R.id.menuitem);
            timmer=itemView.findViewById(R.id.timer);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(itemView.getContext(), "text", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(itemView.getContext(),Edit_room_Activity.class);
                    itemView.getContext().startActivity(intent);


                }
            });

        }

    }
//    public  interface OnItemclicKlistener{
//        void onItemClick(RoomData roomData);
//    }
//    public  void OnItemClickListener(OnItemclicKlistener klistener){
//        listener=klistener;
//
//    }
}
