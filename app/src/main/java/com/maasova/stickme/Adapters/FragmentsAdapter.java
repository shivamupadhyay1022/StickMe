package com.maasova.stickme.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.maasova.stickme.Fragments.MemesFragment;
import com.maasova.stickme.Fragments.StickersFragment;
import com.maasova.stickme.Fragments.TemplatesFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new MemesFragment();
            case 1: return new StickersFragment();
            case 2: return new TemplatesFragment();
            default: return new MemesFragment();
        }
    }

    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0){
            title = "MEMES";
        }
        if(position==1){
            title = "STICKERS";
        }
        if(position==2){
            title = "TEMPLATES";
        }

        return title;
    }
}
