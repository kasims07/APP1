package com.example.app1;

public class MostViewedHelperClass {

    int image;
    String title;

    public MostViewedHelperClass(int image, String title){
        this.image = image;
        this.title = title;

    }

    public int getImageView() {
        return image;
    }

    public String getTextView() {
        return title;
    }


}
