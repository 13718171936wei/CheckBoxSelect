package com.example.checkboxselect;

/**
 * Created by 行走的力量 on 2016/11/2.
 */
public class Fruit {
    private String name;

    private int imageId;

    private boolean checked;

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
