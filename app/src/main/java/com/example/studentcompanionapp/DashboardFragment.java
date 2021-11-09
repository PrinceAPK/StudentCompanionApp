package com.example.studentcompanionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.studentcompanionapp.DRVinterface.LoadMore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.Inflater;

public class DashboardFragment extends Fragment {

    private ImageView menu;

    private RecyclerView recyclerView;
    private StaticRecycleViewAdapter staticRecycleViewAdapter;

    List<DynamicRVModel> items = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_dashboard_fragment, container, false);

        final ArrayList<StaticRecyclerViewModel> item = new ArrayList<>();
        item.add(new StaticRecyclerViewModel(R.drawable.ic_book_24, "Documents"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_info_24, "About"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_announcement_24, "Newsfeed"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_domain_24, "Misc"));

        recyclerView = root.findViewById(R.id.recyclerView1);
        staticRecycleViewAdapter = new StaticRecycleViewAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRecycleViewAdapter);

        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));

        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));

        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));

        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));
        items.add(new DynamicRVModel("Documents"));

        RecyclerView drv = (RecyclerView) root.findViewById(R.id.recyclerView2);
        drv.setLayoutManager(new LinearLayoutManager(getActivity()));

        dynamicRVAdapter = new DynamicRVAdapter(drv, getActivity(), items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if (items.size() <= 10 ){
                    items.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());


                            int index = items.size();
                            int end = index + 10;
                            for (int i = index; i<end; i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                            }
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();
                        }
                    }, 4000);
                }
                else
                    Toast.makeText(getActivity(), "Data Completed", Toast.LENGTH_SHORT).show();
            }
        });


        return  root;
    }
}