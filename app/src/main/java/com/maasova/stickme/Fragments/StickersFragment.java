package com.maasova.stickme.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.maasova.stickme.Adapters.Adapters_recycle.StickersAdapter;
import com.maasova.stickme.Adapters.Adapters_recycle.memeAdapter;
import com.maasova.stickme.R;

import java.util.ArrayList;


public class StickersFragment extends Fragment {
    FloatingActionButton forgalleryoption;
    FloatingActionButton forcameraoption;
    ArrayList<String> imagelist;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    StickersAdapter adapter;
    Context thiscontext;
    private Parcelable recyclerViewState;

    public StickersFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thiscontext = container.getContext();
        View view = inflater.inflate(R.layout.fragment_stickers,container,false);
        forcameraoption = view.findViewById(R.id.for_camera);
        forgalleryoption =  view.findViewById(R.id.for_gallery);

        imagelist = new ArrayList<>();
        recyclerView = view.findViewById(R.id.sticker_recycle);
        adapter = new StickersAdapter(imagelist,getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        recyclerView.setNestedScrollingEnabled(true);
        progressBar = view.findViewById(R.id.stickers_progress);
        progressBar.setVisibility(View.VISIBLE);
        StorageReference listRef = FirebaseStorage.getInstance().getReference().child("/Stickers");
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


        forcameraoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "open camera", Toast.LENGTH_SHORT).show();
            }
        });
        forgalleryoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "open gallery", Toast.LENGTH_SHORT).show();
            }
        });
        return  view;
    }

}