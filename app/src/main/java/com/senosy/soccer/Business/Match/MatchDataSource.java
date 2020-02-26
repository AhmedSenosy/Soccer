package com.senosy.soccer.Business.Match;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;

import com.senosy.soccer.Entity.MatchEntities.Match;
import com.senosy.soccer.Entity.MatchEntities.MatchResponseEntity;
import com.senosy.soccer.Network.NetworkLayer;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class MatchDataSource extends PageKeyedDataSource<Integer, Match> {

    private static final String TAG = "MatchDataSource";
    private MutableLiveData networkState;
    private MutableLiveData initialLoading;
    private NetworkLayer service = new NetworkLayer();
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        service.getMatches(1).subscribe(new SingleObserver<MatchResponseEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(MatchResponseEntity matchResponseEntities) {
                if(matchResponseEntities.isSuccess())
                {
                    callback.onResult(matchResponseEntities.getData().getMatch(),null,2);
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
        service.getMatches((int)params.key).subscribe(new SingleObserver<MatchResponseEntity>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(MatchResponseEntity matchResponseEntity) {
                int nextKey = (int) params.key+1;
                callback.onResult(matchResponseEntity.getData().getMatch(),nextKey);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
