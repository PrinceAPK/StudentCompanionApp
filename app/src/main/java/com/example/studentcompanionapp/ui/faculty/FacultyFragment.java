package com.example.studentcompanionapp.ui.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studentcompanionapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {
    private RecyclerView isDepartment, quantData, baDepartment, csDepartment;
    private LinearLayout isNoData, quantNoData, baNoData, csNoData;
    private List<TeacherData> list1, list2, list3, list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        isDepartment = view.findViewById(R.id.isDepartment);
        quantData = view.findViewById(R.id.quantDepartment);
        baDepartment = view.findViewById(R.id.baDepartment);
        csDepartment = view.findViewById(R.id.csDepartment);

        isNoData = view.findViewById(R.id.isNoData);
        quantNoData = view.findViewById(R.id.quantNoData);
        baNoData = view.findViewById(R.id.baNoData);
        csNoData = view.findViewById(R.id.csNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        quantData();
        baDepartment();
        isDepartment();

        return view;
    }

    private void isDepartment() {
        dbRef = reference.child("Information Systems");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    isNoData.setVisibility(View.VISIBLE);
                    isDepartment.setVisibility(View.GONE);
                } else {
                    isNoData.setVisibility(View.GONE);
                    isDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    isDepartment.setHasFixedSize(true);
                    isDepartment.setLayoutManager(new LinearLayoutManager( getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    isDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void baDepartment() {
        dbRef = reference.child("Business Administration");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    baNoData.setVisibility(View.VISIBLE);
                    baDepartment.setVisibility(View.GONE);
                } else {
                    baNoData.setVisibility(View.GONE);
                    baDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    baDepartment.setHasFixedSize(true);
                    baDepartment.setLayoutManager(new LinearLayoutManager( getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    baDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void quantData() {
        dbRef = reference.child("Quantum Computing");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    quantNoData.setVisibility(View.VISIBLE);
                    quantData.setVisibility(View.GONE);
                } else {
                    quantNoData.setVisibility(View.GONE);
                    quantData.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    quantData.setHasFixedSize(true);
                    quantData.setLayoutManager(new LinearLayoutManager( getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    quantData.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Information Systems");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                } else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager( getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}