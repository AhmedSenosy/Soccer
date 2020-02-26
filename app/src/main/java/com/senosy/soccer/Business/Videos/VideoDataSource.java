package com.senosy.soccer.Business.Videos;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.senosy.soccer.Entity.MatchEntities.Match;
import com.senosy.soccer.Entity.MatchEntities.MatchResponseEntity;
import com.senosy.soccer.Entity.VideoEntities.Video;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;
import com.senosy.soccer.Network.NetworkLayer;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class VideoDataSource extends PageKeyedDataSource<Integer, Match> {

    private static final String TAG = "VideoDataSource";
    private MutableLiveData networkState;
    private MutableLiveData initialLoading;
    private NetworkLayer service = new NetworkLayer();
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        service.getVideos(1).subscribe(new SingleObserver<List<VideosEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<VideosEntity> videosEntities) {
                if(videosEntities.size()>0)
                {
                    callback.onResult(videosEntities,null,2);
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {
        Log.i(TAG, "Loading Rang " + params.key + " Count " + params.requestedLoadSize);
        service.getVideos((int)params.key).subscribe(new SingleObserver<List<VideosEntity>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(List<VideosEntity> videosEntities) {
                int nextKey = (int) params.key+1;
                callback.onResult(videosEntities,nextKey);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
