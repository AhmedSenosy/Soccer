package com.senosy.soccer.Business.Match;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class MatchDataFactory extends DataSource.Factory {
    private MutableLiveData<MatchDataSource> dataSource ;
    private MatchDataSource matchDataSource;

    public MatchDataFactory() {
        this.dataSource = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        matchDataSource = new MatchDataSource();
        dataSource.postValue(matchDataSource);
        return matchDataSource;
    }

    public MutableLiveData<MatchDataSource> getDataSource() {
        return dataSource;
    }
}
