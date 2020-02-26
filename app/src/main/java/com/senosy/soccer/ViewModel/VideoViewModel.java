package com.senosy.soccer.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.senosy.soccer.Business.Match.MatchDataFactory;
import com.senosy.soccer.Business.Videos.VideoDataFactory;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;

public class VideoViewModel extends ViewModel {
    private LiveData<PagedList<VideosEntity>> videosList;

    public VideoViewModel() {
        init();
    }

    private void init(){
        VideoDataFactory videoDataFactory = new VideoDataFactory();
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();

        videosList =(new LivePagedListBuilder(videoDataFactory,pagedListConfig)
        .build());
    }

    public LiveData<PagedList<VideosEntity>> getVideosList() {
        return videosList;
    }
}
