package com.songr.songr.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String length;
    private  int trackNumber;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Albums albums;

    public Song() {
    }

    public Song(String title, String length, int trackNumber) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
    }

    public Song(String title, String length, int trackNumber, Albums albums) {
        this.title = title;
        this.length = length;
        this.trackNumber = trackNumber;
        this.albums = albums;
    }

    public Albums getAlbum() {
        return albums;
    }

    public void setAlbum(Albums albums) {
        this.albums = albums;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
