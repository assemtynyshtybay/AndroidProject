package com.example.loginer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity  extends AppCompatActivity implements CallbackFragment {
    Fragment fragment;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment();
    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    @Override

    protected void onResume(){
        super.onResume();
    }
    protected void onPause(){
        super.onPause();
    }
    protected void onStop(){
        super.onStop();
    }
    protected void onRestart(){
        super.onRestart();
    }
    public void addFragment() {
        FragmentLogin fragment = new FragmentLogin();
        fragment.setCallbackFragment(this);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
    public void replaceFragment(){
        fragment= new FragmentRegister();
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    @Override
    public void changeFragment() {
        replaceFragment();
    }


}
