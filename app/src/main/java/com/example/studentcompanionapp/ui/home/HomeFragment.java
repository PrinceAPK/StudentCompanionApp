package com.example.studentcompanionapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.studentcompanionapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);


        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("geo:0, 0?q=Richard Carlos Institute Jeansville Kiev");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });

        return view;
    }

    private  void setSliderViews(){
        for (int i = 0; i  <5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    //store and get fb image links
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/student-companion-app-41c05.appspot.com/o/edtech-business-Model.png?alt=media&token=ed180fb9-0509-4757-8143-575e3ccb17f0");
                    break;
                    case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/student-companion-app-41c05.appspot.com/o/347_T13A0073.jpg?alt=media&token=50c161bf-5ead-4f10-bff2-37a911dd5f51");
                    break;
                    case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/student-companion-app-41c05.appspot.com/o/Chart-1.jpg?alt=media&token=259b2e5a-b569-4d25-b27f-8247b1ed7728");
                    break;
                    case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/student-companion-app-41c05.appspot.com/o/happy_high_school_students.jpg?alt=media&token=7fa6acdb-8187-4f83-b10b-a0bfed4b0ff9");
                    break;
                    case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/student-companion-app-41c05.appspot.com/o/images.png?alt=media&token=f87bb85f-ff0b-427a-8d75-c8ab70a5e71a");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            sliderLayout.addSliderView(sliderView);
        }
    }
}