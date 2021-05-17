package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Onbord extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, categoriesRecycler, mostviewRecycler;;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon, loginstart;
    LinearLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onbord);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        featuredRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.most_viewed_recycler2);
        mostviewRecycler = findViewById(R.id.most_viewed_recycler3);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        loginstart = findViewById(R.id.login_start);


        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        contentView = findViewById(R.id.contant);

        navigation();
        featuredRecycler();
        categoriesRecycler();
        mostviewRecycler();

        loginstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Onbord.this, startpage.class);
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       switch (menuItem.getItemId()){
           case R.id.nav_home:
               Intent intent = new Intent(Onbord.this, Onbord.class);
               startActivity(intent);
               break;

           case R.id.nav_login:
               Intent login = new Intent(Onbord.this, startpage.class);
               startActivity(login);
               break;

           case R.id.nav_logout:
               Intent logout = new Intent(Onbord.this, Splash_screen.class);
               startActivity(logout);
               break;


       }

        return false;
    }



    private void navigation() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START);
            else drawerLayout.openDrawer(GravityCompat.START);
        });

        animationNavigation();
    }

    private void animationNavigation() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.setScrimColor(getResources().getColor(R.color.home_white));
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }



    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.kakadiya_lake, "Kakaria lake", "Kankaria lake can be found in the south-eastern section of Ahmedabad near the Maninagar area, in Gujrat."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.sabarmati_ashram, "Shabarmati Ashram", "Sabarmati Ashram is a peaceful abode on the banks of Sabarmati River."));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.adalaj_stepwall, "Adalaj Stepwall", "Stepwells used to be the only source of water in the old days."));
        adapter = new FeatureAdpater(featuredLocations);
        featuredRecycler.setAdapter(adapter);


    }

    private void categoriesRecycler() {

        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        //All Gradients
        gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        ArrayList<CategoriesHelperClass> categoriesHelperClasses = new ArrayList<>();

        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.school_image,"Education", gradient1));
        categoriesHelperClasses.add(new CategoriesHelperClass(R.drawable.hospital_image,"HOSPITAL", gradient2));
        categoriesHelperClasses.add(new CategoriesHelperClass( R.drawable.resturant_image, "Restaurant", gradient3));
        categoriesHelperClasses.add(new CategoriesHelperClass( R.drawable.shoping_image, "Shopping", gradient4 ));


        adapter = new CategoriesAdapter(categoriesHelperClasses);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);

    }

    private void mostviewRecycler() {

        mostviewRecycler.setHasFixedSize(false);
        mostviewRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();

        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.mac_donat, "McDonald's"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.jama_masjid, "Jama Masjid"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.veshnav_devi, "Veshnavdevi Mandir"));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.adalaj_stepwall, "Adalaj step Wall"));

        adapter = new MostViewedAdapter(mostViewedLocations);
        mostviewRecycler.setAdapter(adapter);

    }


}
