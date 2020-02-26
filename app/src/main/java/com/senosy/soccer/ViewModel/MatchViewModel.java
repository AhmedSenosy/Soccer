package com.senosy.soccer.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.senosy.soccer.Business.Match.MatchDataFactory;
import com.senosy.soccer.Entity.MatchEntities.Match;

public class MatchViewModel extends ViewModel {
    private LiveData<PagedList<Match>> matchList;

    public MatchViewModel() {
        init();
    }

    private void init(){
        MatchDataFactory matchDataFactory = new MatchDataFactory();
        PagedList.Config pagedListConfig = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10).build();

        matchList =(new LivePagedListBuilder(matchDataFactory,pagedListConfig)
        .build());
    }

    public LiveData<PagedList<Match>> getMatchList() {
        return matchList;
    }
}
