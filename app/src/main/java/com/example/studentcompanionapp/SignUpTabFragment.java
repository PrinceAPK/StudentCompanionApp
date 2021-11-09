package com.example.studentcompanionapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class SignUpTabFragment extends Fragment {
    EditText uEmail, pass, confirmpass;
    Button register;
    TextView fab_google;
    FirebaseFirestore fStore;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    String userID, email, password;

    // comeback
    float v = 0;
    // 1
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        // call rootnode student-companion-app-41c05-default-rtdb
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Register");
        reference.setValue("First data stored");


        /*
        //Checking if user is signed in
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();


        };
*/
        //2
        mAuth = FirebaseAuth.getInstance();


        fStore = FirebaseFirestore.getInstance();

     /*   if (mAuth.getCurrentUser() != null){
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }

      */
        uEmail = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.userPassword);
        confirmpass = root.findViewById(R.id.confirmUserPassword);
        register = root.findViewById(R.id.registerbutton);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = uEmail.getText().toString().trim();
                String password = pass.getText().toString().trim();
                String confirmPass = confirmpass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    uEmail.setError("Email is Required.");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    pass.setError("Password is Required.");
                    return;
                }
                if (TextUtils.isEmpty(confirmPass)) {
                    pass.setError("Password is Required.");
                    return;
                }

                if (confirmPass.equals(password)) {
                    Toast.makeText(getContext(), "Passwords Match", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), DashboardActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                    pass.getText().clear();
                    confirmpass.getText().clear();
                }


                if (password.length() < 6) {
                    pass.setError("Password Must have at least 6 Characters!");
                    return;
                }

                if (  uEmail.equals("admin") && pass.equals("admin")) {
                    Intent intent = new Intent(getContext(), DashboardActivity.class);
                    startActivity(intent);
                    Toast.makeText(getContext(), "LOGIN SUCCESS", Toast.LENGTH_SHORT).show();
                    uEmail.getText().clear();
                    pass.getText().clear();
                } else {
                    Toast.makeText(getContext(), "WELCOME USER!", Toast.LENGTH_SHORT).show();
                    uEmail.getText().clear();
                    pass.getText().clear();
                }
            }
        });

        // register user in Firebase
/*
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            //Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "onSuccess:user Profile is created for " + userID);
                            Toast.makeText(getContext(), "Your Account Has Been Created. Please Login to Continue", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            userID = mAuth.getCurrentUser().getUid();
                            //UpdateUI(user);
                            Intent intent = new Intent(getActivity(), LoginTabFragment.class);
                            startActivity(intent);

                        } else {
                            // if sign in fails, display a message to user
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            //task(null);
                        }
                    }
                });

 */


        uEmail.setTranslationX(800);
        pass.setTranslationX(800);
        confirmpass.setTranslationX(800);
        register.setTranslationX(800);

        uEmail.setAlpha(v);
        pass.setAlpha(v);
        confirmpass.setAlpha(v);
        register.setAlpha(v);


        uEmail.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        pass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        confirmpass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        register.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
    }
}