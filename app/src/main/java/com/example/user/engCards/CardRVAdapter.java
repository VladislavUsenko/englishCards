package com.example.user.engCards;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class CardRVAdapter extends RecyclerView.Adapter<CardRVAdapter.CategoryViewHolder>{

    private List<Card> cards;

    public CardRVAdapter(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public CardRVAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        CardRVAdapter.CategoryViewHolder pvh = new CardRVAdapter.CategoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final CardRVAdapter.CategoryViewHolder holder, int position) {

        final Card card = cards.get(position);

        holder.textView.setText(card.getCard_name_en());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tmp = (String) holder.textView.getText();

                if(tmp.equals(card.getCard_name_en())){
                    holder.textView.setText(card.getCard_name_ru());
                }else  holder.textView.setText(card.getCard_name_en());
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView textView;

        CategoryViewHolder(View itemView) {

            super(itemView);
            cv = itemView.findViewById(R.id.card_card);
            textView = itemView.findViewById(R.id.frond_text_card);
        }
    }
}
