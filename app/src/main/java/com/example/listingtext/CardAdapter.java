package com.example.listingtext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<String> cardTexts;

    public CardAdapter(List<String> cardTexts) {
        this.cardTexts = cardTexts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = cardTexts.get(position);
        holder.cardText.setText(text);
    }

    @Override
    public int getItemCount() {
        return cardTexts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cardText;

        public ViewHolder(View itemView) {
            super(itemView);
            cardText = itemView.findViewById(R.id.card_text);
        }
    }
}