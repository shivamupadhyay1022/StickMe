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

public class English extends AppCompatActivity {
    private Parcelable recyclerViewState;
    ArrayList<String> imagelist;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    memeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        imagelist = new ArrayList<>();
        recyclerView = findViewById(R.id.meme_fragment_recycle_english);
        adapter = new memeAdapter(imagelist, this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setNestedScrollingEnabled(true);
        progressBar = findViewById(R.id.progress_english);
        progressBar.setVisibility(View.VISIBLE);
        StorageReference listRef = FirebaseStorage.getInstance().getReference().child("/Memes/Hindi");
        listRef.listAll().addOnSuccessListener(listResult -> {

            for (StorageReference file : listResult.getItems()) {

                file.getDownloadUrl().addOnSuccessListener(uri -> {
                    imagelist.add(uri.toString());
                    Log.d("Itemvalue", uri.toString());

                }).addOnSuccessListener(uri -> {
                    recyclerViewState = recyclerView.getLayoutManager().onSaveInstanceState();
                    recyclerView.getLayoutManager().onRestoreInstanceState(recyclerViewState);
                    recyclerView.setAdapter(adapter);
                    progressBar.setVisibility(View.GONE);

                });
            }
        });
    }
}