package com.maasova.stickme.language;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.maasova.stickme.Adapters.Adapters_recycle.memeAdapter;
import com.maasova.stickme.R;

import java.util.ArrayList;

public class Hindi extends AppCompatActivity {
    ArrayList<String> imagelist;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    memeAdapter adapter;
    private Parcelable recyclerViewState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi);


    }
}