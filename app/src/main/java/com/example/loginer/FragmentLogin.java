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
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentLogin extends Fragment {
    Button btnlog, btnreg;
    EditText name,password;

    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    CallbackFragment callbackFragment;
    String username, pass;
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
        View view = inflater.inflate (R.layout.login_frag, container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Sign in ");
        name=view.findViewById(R.id.editName);
        password=view.findViewById(R.id.editPassword);

        btnlog=view.findViewById(R.id.btnlogin);
        btnreg=view.findViewById(R.id.btnsignup);

        btnlog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                username = name.getText().toString();
                pass=password.getText().toString();
                String uname,upass;
                uname= sharedPreferences.getString("username",null);
                upass=sharedPreferences.getString("pass",null);

                if(username.equals(uname)&& pass.equals(upass)){
//                  Toast.makeText(getContext(),"Login",Toast.LENGTH_SHORT).show();
                    fragment= new FragmentList();
                    fragmentManager=getFragmentManager();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.fragmentContainer, FragmentList.newInstance())
                            .addToBackStack("second")
                            .commit();


                }else{
                    Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT).show();;
                }
            }


        });

        btnreg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(callbackFragment!=null)
                {
                    callbackFragment.changeFragment();
                }
            }
        });

        return view;
    }

    public void setCallbackFragment(CallbackFragment callbackFragment){
        this.callbackFragment = callbackFragment;
    }
}
