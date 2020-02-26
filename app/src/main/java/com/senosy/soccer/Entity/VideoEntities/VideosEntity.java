
package com.senosy.soccer.Entity.VideoEntities;

import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideosEntity {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("embed")
    @Expose
    private String embed;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("side1")
    @Expose
    private Side1 side1;
    @SerializedName("side2")
    @Expose
    private Side2 side2;
    @SerializedName("competition")
    @Expose
    private Competition competition;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Side1 getSide1() {
        return side1;
    }

    public void setSide1(Side1 side1) {
        this.side1 = side1;
    }

    public Side2 getSide2() {
        return side2;
    }

    public void setSide2(Side2 side2) {
        this.side2 = side2;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideosEntity that = (VideosEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(embed, that.embed) &&
                Objects.equals(url, that.url) &&
                Objects.equals(thumbnail, that.thumbnail) &&
                Objects.equals(date, that.date) &&
                Objects.equals(side1, that.side1) &&
                Objects.equals(side2, that.side2) &&
                Objects.equals(competition, that.competition) &&
                Objects.equals(videos, that.videos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, embed, url, thumbnail, date, side1, side2, competition, videos);
    }
}
