package com.example.studentcompanionapp.ui.about;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.studentcompanionapp.DashboardActivity;
import com.example.studentcompanionapp.DynamicRVAdapter;
import com.example.studentcompanionapp.DynamicRVModel;
import com.example.studentcompanionapp.MainActivity;
import com.example.studentcompanionapp.R;
import com.example.studentcompanionapp.StaticRecycleViewAdapter;
import com.example.studentcompanionapp.StaticRecyclerViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AboutFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {


    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private androidx.appcompat.widget.Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    //List<DynamicRVModel> items = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;
    private Object MenuItem;
    private ImageView menu;
    private RecyclerView recyclerView;
    private StaticRecycleViewAdapter staticRecycleViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navController = Navigation.findNavController(getActivity(), R.id.fragment_layout);

        navigationView = view.findViewById(R.id.slide_navigation_view);
       // drawerLayout.addDrawerListener(toggle);
        //toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


            NavigationView navigationView = (NavigationView) view.findViewById(R.id.slide_navigation_view);
            navigationView.setNavigationItemSelectedListener(this);


        //open panel
      //  menu = view.findViewById(R.id.notice);

     //   menu.setOnClickListener(new View.OnClickListener() {
     //       @Override
    //        public void onClick(View v) {
       //         Intent intent = new Intent(getContext(), MainActivity.class);
   //             startActivity(intent);
    //        }
    //    });
        return view;
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        return false;
    }


/*
    ArrayList<StaticRecyclerViewModel> item = new ArrayList<>(){
        item.add(new StaticRecyclerViewModel(R.drawable.ic_book_24, "Documents"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_info_24, "About"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_announcement_24, "Newsfeed"));
        item.add(new StaticRecyclerViewModel(R.drawable.ic_domain_24, "Misc"));
    }

    recyclerView = findViewById(R.id.recyclerView1);
    staticRecycleViewAdapter = new StaticRecycleViewAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
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

    RecyclerView drv = findViewById(R.id.recyclerView2);
        drv.setLayoutManager(new LinearLayoutManager(this));

    dynamicRVAdapter = new DynamicRVAdapter(drv, this, items);
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
                Toast.makeText(AboutFragment.this, "Data Completed", Toast.LENGTH_SHORT).show();
        }
    });


 */
}
