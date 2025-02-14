package com.senosy.soccer.Entity.MatchEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchResponseEntity {

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("data")
    @Expose
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
