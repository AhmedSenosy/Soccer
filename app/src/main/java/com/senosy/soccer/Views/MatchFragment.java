package com.senosy.soccer.Views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.senosy.soccer.Adapters.MatchesAdapter;
import com.senosy.soccer.Entity.MatchEntities.Match;
import com.senosy.soccer.R;
import com.senosy.soccer.ViewModel.MatchViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {


    @BindView(R.id.rv_matches)
    RecyclerView rvMatches;
    MatchesAdapter adapter;
    LiveData<PagedList<Match>> matchList;
    MatchViewModel matchViewModel;
    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_match, container, false);
        ButterKnife.bind(this,v);
        initObjects();
        initViews();
        return v;
    }

    private void initObjects() {
        matchViewModel = ViewModelProviders.of(this).get(MatchViewModel.class);
        matchList = matchViewModel.getMatchList();

        matchList.observe(getActivity(),pagedList ->{

            adapter.submitList(pagedList);
        });
    }

    private void initViews() {

        adapter = new MatchesAdapter(getContext());
        rvMatches.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMatches.setAdapter(adapter);
    }

}
