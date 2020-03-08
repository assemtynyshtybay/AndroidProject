package com.example.loginer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MailViewHolder extends RecyclerView.ViewHolder {
        TextView mIcon;
        TextView mSender;
        TextView mEmailTitle;
        TextView mEmailDetails;
        TextView mEmailTime;
        ImageView mFavorite;

        MailViewHolder(View itemView) {
        super(itemView);

        mIcon = itemView.findViewById(R.id.tvIcon);
        mSender = itemView.findViewById(R.id.tvEmailSender);
        mEmailTitle = itemView.findViewById(R.id.tvEmailTitle);
        mEmailDetails = itemView.findViewById(R.id.tvEmailDetails);
        mEmailTime = itemView.findViewById(R.id.tvEmailTime);
        mFavorite = itemView.findViewById(R.id.tvFavorite);

        }
}
