package com.eddelacruz.mvp_rest_example.Models;

import java.util.ArrayList;
import java.util.List;

public class SchoolList {
    private List<School_Item> school_item = new ArrayList<>();

    public SchoolList(List<School_Item> school_items) {
        this.school_item = school_items;
    }

    public List<School_Item> getResult() {
        return this.school_item;
    }

    public void setResult(ArrayList<School_Item> arrayList) {
        this.school_item = arrayList;
    }

}
