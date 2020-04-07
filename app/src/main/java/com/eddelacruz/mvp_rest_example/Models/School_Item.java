package com.eddelacruz.mvp_rest_example.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class School_Item {

    @SerializedName("school_email")
    @Expose
    private String school_email;

    @SerializedName("phone_number")
    @Expose
    private String phone_number;

    @SerializedName("boro")
    @Expose
    private String boro;

    @SerializedName("dbn")
    @Expose
    private String dbn;

    @SerializedName("school_name")
    @Expose
    private String school_name;

    public School_Item(String school_name, String dbn, String boro, String phone_number, String school_email) {
            this.school_name = school_name;
            this.dbn = dbn;
            this.boro = boro;
            this.phone_number = phone_number;
            this.school_email = school_email;
        }

    public String getSchool_name() {
            return school_name;
        }

    public String getBoro() {
        return boro;
    }

    public String getDbn() {
        return dbn;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getSchool_email() {
        return school_email;
    }

    public void setBoro(String boro) {
        this.boro = boro;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setSchool_email(String school_email) {
        this.school_email = school_email;
    }

    public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }
}
