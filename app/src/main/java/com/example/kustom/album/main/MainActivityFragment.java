package com.example.kustom.album.main;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kustom.album.R;
import com.example.kustom.album.adapters.AlbumsAdapter;
import com.example.kustom.album.data.CurrentUser;
import com.example.kustom.album.models.Album;
import com.example.kustom.album.models.AlbumListener;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivityFragment extends Fragment implements AlbumListener {
    public static final String ALBUM = "com.example.kustom.album.main.KEY.ALBUM";
    private AlbumsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.show();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerVW);


        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new AlbumsAdapter(getActivity(), this);
        recyclerView.setAdapter(adapter);

        getActivity().setTitle(new CurrentUser().email());

        final Timer timer;
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {



                progressDialog.cancel();
                timer.cancel();
            }
        }, 1800 ,1800);
    }

    @Override
    public void clicked(Album album) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(ALBUM, (Parcelable) album);
        startActivity(intent);



    }

    @Override
    public void clicked2(Album album) {

    }
}
