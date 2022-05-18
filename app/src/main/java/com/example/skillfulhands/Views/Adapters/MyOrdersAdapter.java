package com.example.skillfulhands.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.R;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder> {
    private ArrayList<Order> orderList;
    Context context;

    public MyOrdersAdapter(ArrayList<Order> data, Context context) {
        this.orderList = data;
        this.context=context;
    }

    @NonNull
    @Override
    public MyOrdersAdapter.MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.order_done, parent, false);
        return new MyOrdersAdapter.MyOrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyOrdersAdapter.MyOrdersViewHolder holder, int position) {
        final Order temp = orderList.get(position);

        holder.id.setText(orderList.get(position).getNum());
        holder.date.setText(orderList.get(position).getDate());
        holder.status.setText(orderList.get(position).getStatus().getTitle());
        holder.warranty.setText("1 year");

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    class MyOrdersViewHolder extends RecyclerView.ViewHolder {
        TextView id, date, status, warranty;

        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView73);
            date = itemView.findViewById(R.id.date_of_bringing);
            status = itemView.findViewById(R.id.status);
            warranty = itemView.findViewById(R.id.warranty);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
