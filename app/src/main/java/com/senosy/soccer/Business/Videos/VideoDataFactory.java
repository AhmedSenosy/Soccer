package com.senosy.soccer.Business.Videos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class VideoDataFactory extends DataSource.Factory {
    private MutableLiveData<VideoDataSource> dataSource ;
    private VideoDataSource videoDataSource;

    public VideoDataFactory() {
        this.dataSource = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        videoDataSource = new VideoDataSource();
        dataSource.postValue(videoDataSource);
        return videoDataSource;
    }

    public MutableLiveData<VideoDataSource> getDataSource() {
        return dataSource;
    }
}
