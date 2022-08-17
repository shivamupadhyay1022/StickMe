package com.maasova.stickme.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;
import com.maasova.stickme.Adapters.Adapters_recycle.memeAdapter;
import com.maasova.stickme.R;
import com.maasova.stickme.language.English;
import com.maasova.stickme.language.Hindi;
import com.maasova.stickme.language.Tamil;

import java.util.ArrayList;


public class MemesFragment extends Fragment {
    FloatingActionButton forgalleryoption;
    FloatingActionButton forcameraoption;
    FloatingActionButton forcollageoption;
    ArrayList<String> imagelist;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    memeAdapter adapter;
    private String path = "/Memes/Hindi";
    TextView nofilter, hindi, english, bangali, tmail;
    private Parcelable recyclerViewState;


    public MemesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memes, container, false);
        recyclerView = view.findViewById(R.id.meme_fragment_recycle);
        progressBar = view.findViewById(R.id.progress);
        nofilter = view.findViewById(R.id.nofilter);
        hindi = view.findViewById(R.id.hindi);
        english = view.findViewById(R.id.english);
        bangali = view.findViewById(R.id.bangali);
        tmail = view.findViewById(R.id.tmail);



        imagelist = new ArrayList<>();
        adapter = new memeAdapter(imagelist, getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setNestedScrollingEnabled(true);
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





        nofilter.setBackgroundResource(R.drawable.filterbackselected);
        nofilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path = "/Memes/Hindi";
                nofilter.setBackgroundResource(R.drawable.filterbackselected);
                hindi.setBackgroundResource(R.drawable.filterback);
                english.setBackgroundResource(R.drawable.filterback);
                bangali.setBackgroundResource(R.drawable.filterback);
                tmail.setBackgroundResource(R.drawable.filterback);

            }
        });

        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path = "/Memes/English";
                hindi.setBackgroundResource(R.drawable.filterbackselected);
                nofilter.setBackgroundResource(R.drawable.filterback);
                english.setBackgroundResource(R.drawable.filterback);
                bangali.setBackgroundResource(R.drawable.filterback);
                tmail.setBackgroundResource(R.drawable.filterback);
            }
        });
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                path = "/Memes/Tamil";
               english.setBackgroundResource(R.drawable.filterbackselected);
                hindi.setBackgroundResource(R.drawable.filterback);
                nofilter.setBackgroundResource(R.drawable.filterback);
                bangali.setBackgroundResource(R.drawable.filterback);
                tmail.setBackgroundResource(R.drawable.filterback);
            }
        });
        bangali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bangali.setBackgroundResource(R.drawable.filterbackselected);
                hindi.setBackgroundResource(R.drawable.filterback);
                english.setBackgroundResource(R.drawable.filterback);
                nofilter.setBackgroundResource(R.drawable.filterback);
                tmail.setBackgroundResource(R.drawable.filterback);
            }
        });
        tmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tmail.setBackgroundResource(R.drawable.filterbackselected);
                hindi.setBackgroundResource(R.drawable.filterback);
                english.setBackgroundResource(R.drawable.filterback);
                bangali.setBackgroundResource(R.drawable.filterback);
                nofilter.setBackgroundResource(R.drawable.filterback);
            }
        });
        forcameraoption = view.findViewById(R.id.for_camera);
        forgalleryoption = view.findViewById(R.id.for_gallery);
        forcollageoption = view.findViewById(R.id.for_collage);
        forcameraoption.setOnClickListener(view13 -> Toast.makeText(getActivity(), "open camera", Toast.LENGTH_SHORT).show());
        forgalleryoption.setOnClickListener(view12 -> Toast.makeText(getActivity(), "open gallery", Toast.LENGTH_SHORT).show());
        forcollageoption.setOnClickListener(view1 -> Toast.makeText(getActivity(), "open collage", Toast.LENGTH_SHORT).show());

        return view;
    }


}

