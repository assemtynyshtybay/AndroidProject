package com.example.loginer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FragmentRegister extends Fragment {
    Button btnreg;
    EditText name,password;
    String username,pass;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    public void onAttach(Context context){
        sharedPreferences=context.getSharedPreferences("usersFile",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        super.onAttach(context);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate (R.layout.register_frag, container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Sign up ");

        name=view.findViewById(R.id.newName);
        password=view.findViewById(R.id.newPassword);

        btnreg=view.findViewById(R.id.btnregister);

        btnreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                username=name.getText().toString();
                pass=password.getText().toString();

                editor.putString("username",username);
                editor.putString("pass",pass);
                editor.apply();
                Toast.makeText(getContext(),"Registered",Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}
