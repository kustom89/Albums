package com.example.kustom.album.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.kustom.album.R;

public class DetailsActivity extends AppCompatActivity {
    public static final String ALBUM = "com.example.kustom.album.main.KEY.ALBUM";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
