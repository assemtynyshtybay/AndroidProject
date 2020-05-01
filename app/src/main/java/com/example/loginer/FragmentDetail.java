package com.example.loginer;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FragmentDetail extends Fragment {
    private TextView text;
    private TextView author, mean;
    private Button add;
    EditText edit;
    public static FragmentDetail newInstance(Quote quote){
        FragmentDetail fragment=new FragmentDetail();
        //передаем данные в detail
        Bundle bundle = new Bundle();
        bundle.putString("quoteText", quote.getQuoteText());
        bundle.putString("quoteAuthor", quote.getQuoteAuthor());
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_act, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Detailed ");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        add = view.findViewById(R.id.addMean);
        text = view.findViewById(R.id.quoteText);
        author = view.findViewById(R.id.quoteAuthor);
        edit = view.findViewById(R.id.editMean);
        mean = view.findViewById(R.id.mean);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tx = edit.getText().toString();
                mean.setText(tx);
            }
        });
        try {
            //getArguments() от setArguments (Bundle) и мы берем каждое по ключу
            //меняем эти данные вюшек
            text.setText(getArguments().getString("quoteText"));
            author.setText(getArguments().getString("quoteAuthor"));
        }
        catch (Exception e) {
            Log.e("error", e + " ");
        }
    }
}
