package com.senosy.soccer.Network;


import com.senosy.soccer.Entity.MatchEntities.MatchResponseEntity;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RestApi {

    String Matches = "api-client/scores/history.json";
    @GET
    Single<List<VideosEntity>> getVideosList(@Url String url, @Query("page")int page);

    @GET(Matches)
    Single<MatchResponseEntity> getMatches(@Query("key")String key,
                                                 @Query("secret")String secret,
                                                 @Query("page")int page);
}
