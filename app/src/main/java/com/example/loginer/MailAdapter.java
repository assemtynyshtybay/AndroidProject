package com.example.loginer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MailAdapter extends RecyclerView.Adapter<MailViewHolder>{
    private List<EmailData> EmailDatas;
    private Context mContext;

    public MailAdapter(List<EmailData> emailDatas, Context mContext) {
        EmailDatas = emailDatas;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,
                parent, false);
        return new MailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MailViewHolder holder, int position) {
        holder.mSender.setText(EmailDatas.get(position).getmSender());
        holder.mEmailTitle.setText(EmailDatas.get(position).getmTitle());
        holder.mEmailDetails.setText(EmailDatas.get(position).getmDetails());
        holder.mEmailTime.setText(EmailDatas.get(position).getmTime());
        holder.mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.mFavorite.getColorFilter() != null) {
                    holder.mFavorite.clearColorFilter();
                } else {
                    holder.mFavorite.setColorFilter(ContextCompat.getColor(mContext,
                            R.color.colorOrange));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return EmailDatas.size();
    }

}
