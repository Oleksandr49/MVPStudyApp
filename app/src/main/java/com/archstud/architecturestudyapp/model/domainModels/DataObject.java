package com.archstud.architecturestudyapp.model.domainModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "DataObjects")
public class DataObject {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "Name")
    private String name;
    @ColumnInfo(name = "Details")
    private String details;

    public DataObject(){

    }

    @Ignore
    public DataObject(String name, String details){
        this.name = name;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
