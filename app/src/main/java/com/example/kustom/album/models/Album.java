package com.example.kustom.album.models;

public class Album {

    private String band;
    private String name;
    private String gender;
    private String uid;
    private int relesase;
    private float ranking;

    public Album() {

    }

    public Album(String band, String name, String gender, String uid, int relesase, float ranking, boolean viewed) {
        this.band = band;
        this.name = name;
        this.gender = gender;
        this.uid = uid;
        this.relesase = relesase;
        this.ranking = ranking;
        this.viewed = viewed;
    }

    public boolean isViewed() {
        return viewed;
    }

    public void setViewed(boolean viewed) {
        this.viewed = viewed;
    }

    private boolean viewed;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }



    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }


    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getRelesase() {
        return relesase;
    }

    public void setRelesase(int relesase) {
        this.relesase = relesase;
    }
}
