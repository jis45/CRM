package com.atees.ateesglobelcrm.Roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "roomsaveData")
public class RoomData {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "organzation")
    private String organization;

    @ColumnInfo(name = "opportunity")
    private String opportunity;

    public RoomData(String organization, String opportunity) {

        this.organization = organization;
        this.opportunity = opportunity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
    }
}
