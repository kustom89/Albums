package com.example.kustom.album.adapters;

import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kustom.album.R;
import com.example.kustom.album.data.Nodes;
import com.example.kustom.album.models.Album;
import com.example.kustom.album.models.AlbumListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class AlbumsAdapter extends FirebaseRecyclerAdapter<Album, AlbumsAdapter.AlbumHolder>{


    private final AlbumListener listener;

    public AlbumsAdapter(LifecycleOwner lifecycleOwner, AlbumListener listener) {
        super(new FirebaseRecyclerOptions.Builder<Album>()
               // .setQuery(new Nodes().pending(new EmailProcesor().sanitizedEmail(new CurrentUser().email())), Place.class)
                .setLifecycleOwner(lifecycleOwner)
                .build()
        );
        this.listener = listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull final AlbumHolder holder, int position, @NonNull Album model) {
        if (model.getRanking() != 0) {
            holder.itemRatedTV.setVisibility(View.VISIBLE);
            holder.itemRatedTV.setText(String.valueOf(model.getRanking()));
            holder.starIV.setVisibility(View.VISIBLE);
            if(model.getBand().length() > 40)
            {
                String detail = model.getBand();
                String detailShow = detail.substring(0,40);
                holder.name.setText(detailShow+"...");
            }else
            {
                holder.name.setText(model.getBand());
            }

        } else {
            holder.itemRatedTV.setVisibility(View.INVISIBLE);
            holder.starIV.setVisibility(View.INVISIBLE);
            holder.itemRatedTV.setText("0.0");
            holder.name.setVisibility(View.INVISIBLE);
        }

        holder.itemRatedTV.setText(model.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Album auxPlace = getItem(holder.getAdapterPosition());
                listener.clicked(auxPlace);
            }
        });

        holder.placeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Album auxPlace = getItem(holder.getAdapterPosition());
                listener.clicked2(auxPlace);
            }
        });

    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public static class AlbumHolder extends RecyclerView.ViewHolder{

        private TextView name, band, release, itemRatedTV;
        private ImageView starIV;
        private ImageView placeBTN;


        public AlbumHolder(View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.nameTv);
            band=itemView.findViewById(R.id.bandTv);
            release=itemView.findViewById(R.id.releaseTv);
            itemRatedTV = itemView.findViewById(R.id.itemRated);
            starIV = itemView.findViewById(R.id.starIV);
            placeBTN = itemView.findViewById(R.id.placeImgBtn);

        }

    }
}
