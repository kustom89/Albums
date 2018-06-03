package com.example.kustom.album.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {

    private DatabaseReference root= FirebaseDatabase.getInstance().getReference();

    public DatabaseReference albums() {
        return root.child("albums");
    }

    public DatabaseReference albums(String key) {
        return albums().child(key);
    }

    public DatabaseReference pending(String key) {
        return albums(key).child("pendings");
    }


}
