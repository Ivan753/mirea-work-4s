package com.example.lab1.adapter;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.lab1.R;
import com.example.lab1.utils.NumberToString;


public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewAdapter>  {

    private int itemCounts;
    private NumberToString converter;

    public CardAdapter(int n){
        this.itemCounts = n;
        this.converter = new NumberToString();
    }

    @NonNull
    @Override
    public CardViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new CardViewAdapter(view, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewAdapter holder, int position) {

        TextView text = holder.text;
        text.setText(this.converter.numberToString(position+1));

        int backgroundColor = ContextCompat.getColor(holder.itemView.getContext(),
                (position+1) % 2 == 0 ? R.color.gray : R.color.white);

        holder.linearLayout.setBackgroundColor(backgroundColor);
    }

    @Override
    public int getItemCount() {
        return itemCounts;
    }


    class CardViewAdapter extends RecyclerView.ViewHolder {

        public View linearLayout;
        private ImageView image;
        private TextView text;

        public CardViewAdapter(View itemView, int number) {
            super(itemView);
            image = itemView.findViewById(R.id.my_image);
            text = itemView.findViewById(R.id.my_text);
            linearLayout = itemView.findViewById(R.id.line);
        }

    }
}
