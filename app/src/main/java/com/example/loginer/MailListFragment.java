package com.example.loginer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MailListFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<EmailData> elist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.maillist, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter = new MailAdapter(elist, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));

        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        elist = new ArrayList<>();
        EmailData mEmail = new EmailData("Sam", "Weekend adventure",
                "Let's go fishing with John and others. We will do some barbecue and have soo much fun",
                "10:42am");
        elist.add(mEmail);
        mEmail = new EmailData("Facebook", "James, you have 1 new notification",
                "A lot has happened on Facebook since",
                "16:04pm");
        elist.add(mEmail);
        mEmail = new EmailData("Google+", "Top suggested Google+ pages for you",
                "Top suggested Google+ pages for you",
                "18:44pm");
        elist.add(mEmail);
        mEmail = new EmailData("Twitter", "Follow T-Mobile, Samsung Mobile U",
                "James, some people you may know",
                "20:04pm");
        elist.add(mEmail);
        mEmail = new EmailData("Pinterest Weekly", "Pins you’ll love!",
                "Have you seen these Pins yet? Pinterest",
                "09:04am");
        elist.add(mEmail);
        mEmail = new EmailData("Josh", "Going lunch", "Don't forget our lunch at 3PM in Pizza hut",
                "01:04am");
        elist.add(mEmail);

    }
}
