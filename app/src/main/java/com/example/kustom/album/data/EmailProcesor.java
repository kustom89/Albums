package com.example.kustom.album.data;

public class EmailProcesor {
    public String sanitizedEmail(String email) {
        return email.replace("@", "AT").replace(".", "DOT");
    }
}
