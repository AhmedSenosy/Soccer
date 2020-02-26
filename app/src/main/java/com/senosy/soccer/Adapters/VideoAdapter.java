package com.senosy.soccer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.senosy.soccer.Entity.MatchEntities.Match;
import com.senosy.soccer.Entity.VideoEntities.VideosEntity;
import com.senosy.soccer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoAdapter extends PagedListAdapter<VideosEntity, VideoAdapter.MatchViewHolder> {

    Context context;


    public VideoAdapter(Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.video_item, parent, false);
        return new MatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        VideosEntity video = getItem(position);

        String html = video.getVideos().get(0).getEmbed();
        String mime = "text/html";
        String encoding = "utf-8";
        holder.webView.loadData(html, mime, encoding);
        holder.webView.setWebChromeClient(new WebChromeClient());
        holder.webView.getSettings().setLoadsImagesAutomatically(true);
        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView.getSettings().setAllowFileAccess(true);
        holder.webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        holder.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        holder.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        holder.webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    private static DiffUtil.ItemCallback diffCallback = new DiffUtil.ItemCallback() {
        @Override
        public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return ((VideosEntity) oldItem).getTitle().equals(((VideosEntity) newItem).getTitle());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return ((VideosEntity) oldItem).equals(((VideosEntity) newItem));
        }
    };

    class MatchViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.webView)
        WebView webView;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
