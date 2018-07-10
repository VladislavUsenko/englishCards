package com.example.user.engCards;


import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CategoryRVAdapter extends RecyclerView.Adapter<CategoryRVAdapter.CategoryViewHolder>{

    List<Category> categories;
    CategoryRVAdapter(List<Category> categories){
        this.categories = categories;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categary, parent, false);
        CategoryViewHolder pvh = new CategoryViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, final int i) {

        final Category category = categories.get(i);

        holder.textView.setText(category.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CardsActivity.class);
                intent.putExtra("CategoryName",category.getName());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView textView;

        CategoryViewHolder(View itemView) {

            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.category_card);
            textView = (TextView)itemView.findViewById(R.id.category_text);
        }
    }
}
