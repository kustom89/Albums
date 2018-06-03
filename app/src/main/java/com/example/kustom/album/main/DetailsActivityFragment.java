package com.example.kustom.album.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.kustom.album.R;
import com.example.kustom.album.data.CurrentUser;
import com.example.kustom.album.data.EmailProcesor;
import com.example.kustom.album.data.Nodes;
import com.example.kustom.album.models.Album;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsActivityFragment extends Fragment {
    public static final String ALBUM = "com.example.kustom.album.main.KEY.ALBUM";
    private Album album;
    CurrentUser user = new CurrentUser();
    String emailSanitized = new EmailProcesor().sanitizedEmail(user.email());
    private TextView textViewRating;
    private EditText editTextDescription;
    private RatingBar ratingBar;
    private float ranking;


    public DetailsActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);


    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        album = (Album) getActivity().getIntent().getSerializableExtra(MainActivityFragment.ALBUM);
        getActivity().setTitle(album.getName());

        ratingBar = view.findViewById(R.id.starDetail);
        textViewRating = view.findViewById(R.id.itemTextRanking);
        editTextDescription = view.findViewById(R.id.placeDetailTv);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ranking = rating;

                if (ranking == 0.0 || ranking == 0.5) {

                    textViewRating.setText("Horrible");
                } else if (ranking == 1.0 || ranking == 1.5) {
                    textViewRating.setText("Malisimo");
                } else if (ranking == 2.0 || ranking == 2.5) {
                    textViewRating.setText("Más o menos");
                } else if (ranking == 3.0 || ranking == 3.5) {
                    textViewRating.setText("Bueno");
                } else if (ranking == 4.0 || ranking == 4.5) {
                    textViewRating.setText("Muy Bueno");
                } else if (ranking == 5.0) {
                    textViewRating.setText("Excelente!!!");
                }
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        album.setGender(editTextDescription.getText().toString());
        album.setRanking(ranking);
        if (album.getGender() != null || album.getRanking() != 0) {
            album.setViewed(true);
        }

        new Nodes().pending(emailSanitized).child(album.getUid()).child("description").setValue(album.getBand());
        new Nodes().pending(emailSanitized).child(album.getUid()).child("ranking").setValue(album.getRanking());
        new Nodes().pending(emailSanitized).child(album.getUid()).child("visited").setValue(album.isViewed());
    }

    @Override
    public void onResume() {
        super.onResume();
        if (album.getBand() != null) {
            float ranking = album.getRanking();
            editTextDescription.setText(album.getBand());
            ratingBar.setRating(ranking);


        }
    }



}
