package com.example.studentcompanionapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.Objects;
import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;

public class LoginTabFragment extends Fragment {

    DatabaseReference reference;
    private FirebaseAuth mAuth;
    EditText etPass, etEmail;
    String Email, Password;
    TextView forgotpass, fab;
    Button login;
    float v = 0;
    //String userID;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);


        //mAuth = FirebaseAuth.getInstance();

        etEmail = root.findViewById(R.id.email);
        etPass = root.findViewById(R.id.userPassword);
        forgotpass = root.findViewById(R.id.forgotPassword);
        login = root.findViewById(R.id.loginButton);
        fab = root.findViewById(R.id.fab_google);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = etEmail.getText().toString().toLowerCase();
                String Password = etPass.getText().toString().toLowerCase();

                if (TextUtils.isEmpty(Email)) {
                    etEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(Password)) {
                    etPass.setError("Password is Required.");
                    return;
                }

                if (Password.length() < 5) {
                    etPass.setError("Password Must Be at least 5 Characters Long!");
                    return;
                }

                if (etEmail.getText().toString().equals("student") && etPass.getText().toString().equals("student")) {
                    Toast.makeText(getContext(), "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), DashboardActivity.class);
                    startActivity(intent);

                    etEmail.getText().clear();
                    etPass.getText().clear();

                }

                if (etEmail.getText().toString().equals("student@gmail.com") && etPass.getText().toString().equals("admin") || etEmail.getText().toString().equals("") && etPass.getText().toString().equals("12345")) {
                    Toast.makeText(getContext(), "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), DashboardActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
                    //fab.setVisibility(View.VISIBLE);
                    etEmail.getText().clear();
                    etPass.getText().clear();
                }
            }
        });

/*
        mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                  //updateUI(null);
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                   //updateUI(null);
                }
            }
        });
*/


       etEmail.setTranslationX(800);
       etPass.setTranslationX(800);
       forgotpass.setTranslationX(800);
       login.setTranslationX(800);

        etEmail.setAlpha(v);
        etPass.setAlpha(v);
        forgotpass.setAlpha(v);
        login.setAlpha(v);


       etEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
       etPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
       forgotpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
       login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();

       return root;
    }

    /*
    private void updateUI(Object o) {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if(user != null){
            //Name, email, address
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            Toast.makeText(getContext(),"You Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(getContext(), DashboardActivity.class));
            boolean emailVerified = user.isEmailVerified();

            //assign userID, unique to Firebase Project
            user.getUid();

        }else {
            Toast.makeText(getContext(),"You Didnt sign in",Toast.LENGTH_LONG).show();
        }

    }

     */
    }

