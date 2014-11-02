package com.invisiblefury.android.fragmentlearn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jason on 10/29/2014.
 */

public class Message implements Serializable{
    private UUID mId;
    private String mTitle;
    private String mDescription;
    private Date mDateCreated;

    public void setId(UUID id) {
        this.mId = id;
    }

    public UUID getId() {
        return mId;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDateCreated(Date dateCreated) {
        this.mDateCreated = dateCreated;
    }

    public Date getDateCreated() {
        return mDateCreated;
    }


    public Message(){
        this.setId(UUID.randomUUID());
        this.setDateCreated(new Date());
    }
}



