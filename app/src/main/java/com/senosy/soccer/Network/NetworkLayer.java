package com.senosy.soccer.Network;


import com.senosy.soccer.Entity.MatchEntities.MatchResponseEntity;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;
import com.senosy.soccer.Utils.PublicKeys;
import com.senosy.soccer.Utils.RetrofitInstance;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NetworkLayer {
    RestApi api = RetrofitInstance.getRetrofitInstance().create(RestApi.class);

    public Single<MatchResponseEntity> getMatches(int page){
        return api.getMatches(PublicKeys.API_KEY,PublicKeys.API_SECRET,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<List<VideosEntity>> getVideos(int page)
    {
        return api.getVideosList(PublicKeys.Videos,page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
