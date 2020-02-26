package com.senosy.soccer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.senosy.soccer.Entity.MatchEntities.Match;
import com.senosy.soccer.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchesAdapter extends PagedListAdapter <Match,MatchesAdapter.MatchViewHolder>{

    Context context;


    public MatchesAdapter( Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.match_item,parent,false);
        return new MatchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = getItem(position);

        holder.txt_home_team.setText(match.getHomeName());
        holder.txt_away_team.setText(match.getAwayName());
    }

    private static DiffUtil.ItemCallback diffCallback = new DiffUtil.ItemCallback() {
        @Override
        public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return ((Match)oldItem).getId() ==((Match)newItem).getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return ((Match)oldItem).equals(((Match)newItem));
        }
    };

    class MatchViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.img_home_logo)
        ImageView img_home;
        @BindView(R.id.img_away_logo)
        ImageView img_away;
        @BindView(R.id.txt_home_team)
        TextView txt_home_team;
        @BindView(R.id.txt_away_team)
        TextView txt_away_team;
        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
