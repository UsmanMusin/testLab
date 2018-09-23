package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Song {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("album")
    private String album;
    @JsonProperty("date")
    private int date;
    @JsonProperty("duration")
    private int duration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    /*public Song(String name, String artist, String album, int date, int duration){
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.date = date;
        this.duration = duration;
    }*/

    public boolean customComparator(Song song){
        if((this.name.equals(song.name))|| (song.name == null)&
        (this.artist.equals(song.artist))|| (song.artist == null)&
        (this.album.equals(song.album))|| (song.album == null)&
        (this.date == song.date)||(song.date == 0)&
        (this.duration == song.duration)||(song.duration == 0)){
            return true;
        }
        else return false;
    }


    @Override
    public String toString() {
        return id + ", " +
                artist + ", " +
                album + ", " +
                date + ", " +
                duration + "; ";
    }
}