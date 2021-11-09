package com.example.studentcompanionapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentcompanionapp.DRVinterface.LoadMore;

import java.util.List;

class LoadingView extends RecyclerView.ViewHolder{

    public ProgressBar progressBar;

    public LoadingView(@NonNull View itemView) {
        super(itemView);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
    }
}

class itemViewHolder extends RecyclerView.ViewHolder{

    public TextView name;

    public itemViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.itemName);
    }
}

public class DynamicRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final int VIEW_TYPE_ITEM = 0, VIEW_TYPE_LOADING = 1;
    LoadMore loadMore;
    boolean isLoading;
    Activity activity;
    List<DynamicRVModel> items;
    int visibleThreshold = 5;
    int lastVisibleItem, totalItemCount;
    private itemViewHolder itemViewHolder;

    public DynamicRVAdapter(RecyclerView recyclerView, Activity activity, List<DynamicRVModel> items) {
        this.activity = activity;
        this.items = items;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if(isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)){
                    if (loadMore != null){
                        loadMore.onLoadMore();
                        isLoading = true;
                    }
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position) == null ? VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;
    }

    public void setLoadMore(LoadMore loadMore){
        this.loadMore = loadMore;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == VIEW_TYPE_ITEM){
            View view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_item_layout, parent, false);
            return new LoadingView(view);
        }
        else if (viewType == VIEW_TYPE_LOADING){
            View view = LayoutInflater.from(activity).inflate(R.layout.dyanamic_rv_progress_bar, parent, false);
            return new LoadingView(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MenuView.ItemView){
            DynamicRVModel item = items.get(position);
            itemViewHolder = (itemViewHolder) holder;
            itemViewHolder.name.setText(items.get(position).getName());
        }
        else if (holder instanceof LoadingView){
            LoadingView loadingView = (LoadingView) holder;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setLoaded(){
        isLoading = false;
    }
}
