package com.example.app1;

import android.graphics.drawable.Drawable;

public class CategoriesHelperClass{
    int image;
    String title;
            Drawable relativeLayout;

    public CategoriesHelperClass(int image, String title, Drawable Gradient){
        this.image = image;
        this.title = title;
        this.relativeLayout = Gradient;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public Drawable getGradient() {
        return relativeLayout;
    }
}
