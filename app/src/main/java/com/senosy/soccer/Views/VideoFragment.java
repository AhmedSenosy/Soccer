package com.senosy.soccer.Views;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.senosy.soccer.Adapters.VideoAdapter;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;
import com.senosy.soccer.R;
import com.senosy.soccer.ViewModel.VideoViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    @BindView(R.id.rv_videos)
    RecyclerView rvVideos;


    VideoViewModel videoViewModel;
    LiveData<PagedList<VideosEntity>> videosList;
    VideoAdapter adapter;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_video, container, false);
        ButterKnife.bind(this,v);
        initObjects();
        initViews();
        return v;
    }
    private void initObjects() {
        videoViewModel = ViewModelProviders.of(this).get(VideoViewModel.class);
        videosList = videoViewModel.getVideosList();

        videosList.observe(getActivity(), pagedList ->{

            adapter.submitList(pagedList);
        });
    }

    private void initViews() {

        adapter = new VideoAdapter(getContext());
        rvVideos.setLayoutManager(new LinearLayoutManager(getContext()));
        rvVideos.setAdapter(adapter);
    }
}
