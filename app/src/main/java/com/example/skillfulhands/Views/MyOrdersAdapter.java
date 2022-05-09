package com.example.skillfulhands.Views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.R;
import com.example.skillfulhands.databinding.OrderDoneBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyOrdersAdapter extends RecyclerView.Adapter<MyOrdersAdapter.MyOrdersViewHolder> {
    private OrderDoneBinding binding;
    private List<Order> orderList = new ArrayList<>();

    @NonNull
    @Override
    public MyOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_done, parent, false);

        return new MyOrdersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrdersViewHolder holder, int position) {
        holder.bind(orderList.get(position));
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public void setItems(Collection<Order> orders) {
        orderList.addAll(orders);
        notifyDataSetChanged();
    }

    public void clearItems() {
        orderList.clear();
        notifyDataSetChanged();
    }

    class MyOrdersViewHolder extends RecyclerView.ViewHolder {
        private TextView orderNum;
        private TextView dateOfBringing;
        private TextView status;
        private TextView warranty;

        public MyOrdersViewHolder(@NonNull View itemView) {
            super(itemView);
            orderNum = binding.textView73;
            dateOfBringing = binding.dateOfBringing;
            status = binding.status;
            warranty = binding.warranty;
        }

        public void bind(Order order) {
            orderNum.setText(order.getNum());
            dateOfBringing.setText(order.getDate());
            status.setText(order.getStatus().toString());
            warranty.setText("1 год");
        }
    }
}
