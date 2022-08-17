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

public class Tamil extends AppCompatActivity {
    ArrayList<String> imagelist;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    memeAdapter adapter;
    private Parcelable recyclerViewState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tamil);
        imagelist = new ArrayList<>();
        recyclerView = findViewById(R.id.meme_fragment_recycle_tmail);
        adapter = new memeAdapter(imagelist, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        progressBar = findViewById(R.id.progress_tmail);
        progressBar.setVisibility(View.VISIBLE);
        StorageReference listRef = FirebaseStorage.getInstance().getReference().child("/Memes/Tamil");
        listRef.listAll().addOnSuccessListener(listResult -> {

            for (StorageReference file : listResult.getItems()) {

                file.getDownloadUrl().addOnSuccessListener(uri -> {
                    imagelist.add(uri.toString());
                    Log.d("Itemvalue", uri.toString());

                }).addOnSuccessListener(uri -> {
                    recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
                    recyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);

                    progressBar.setVisibility(View.GONE);
                    recyclerView.setAdapter(adapter);
                });
            }

        });


    }
}