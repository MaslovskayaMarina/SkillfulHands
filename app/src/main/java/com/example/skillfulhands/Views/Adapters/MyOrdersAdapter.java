package com.example.skillfulhands.Views.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.Models.Status;
import com.example.skillfulhands.R;

import java.util.ArrayList;

public class MyOrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Order> orderList;
    Context context;

    public MyOrdersAdapter(ArrayList<Order> data, Context context) {
        this.orderList = data;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder vh;
        View itemLayoutView;

        //загружаем разметку в зависимости от типа и возвращаем
        //нужный холдер
        switch (viewType)
        {
            case 0:
                itemLayoutView = inflater.inflate(R.layout.order_in_proccess, parent, false);
                vh = new ProccessViewHolder(itemLayoutView);
                break;
            case 1:
                itemLayoutView = inflater.inflate(R.layout.order_waiting, parent, false);
                vh = new WaitingViewHolder(itemLayoutView);
                break;
            case 2:
                itemLayoutView = inflater.inflate(R.layout.order_done, parent, false);
                vh = new DoneViewHolder(itemLayoutView);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (this.getItemViewType(position))
        {
            case 0:
                ProccessViewHolder proccessViewHolder = (ProccessViewHolder) holder;
                ((ProccessViewHolder) holder).id.setText(orderList.get(position).getNum());
                break;
            case 1:
                WaitingViewHolder waitingViewHolder = (WaitingViewHolder) holder;
                //наполняем данными разметку для нулевого типа
                ((WaitingViewHolder) holder).id.setText(orderList.get(position).getNum());
                break;
            case 2:
                DoneViewHolder doneViewHolder = (DoneViewHolder) holder;
                //наполняем данными разметку для нулевого типа
                ((DoneViewHolder) holder).id.setText(orderList.get(position).getNum());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (orderList.get(position).getStatus().equals(Status.PROCESS)) {
            return 0;
        } else if (orderList.get(position).getStatus().equals(Status.WAITING)) {
            return 1;
        } else if (orderList.get(position).getStatus().equals(Status.DONE)) {
            return 2;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class ProccessViewHolder extends RecyclerView.ViewHolder {
        public TextView id, dateOfBringing, status, cost, dateToGet;

        public ProccessViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView3);
            dateOfBringing = itemView.findViewById(R.id.order_proccess_date);
            status = itemView.findViewById(R.id.proccess_status);
            cost = itemView.findViewById(R.id.proccess_cost);
            dateToGet = itemView.findViewById(R.id.textView4);
        }
    }

    public static class WaitingViewHolder extends RecyclerView.ViewHolder {
        public TextView id, dateOfBringing, status, cost;

        public WaitingViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.waiting_num);
            dateOfBringing = itemView.findViewById(R.id.waiting_date);
            status = itemView.findViewById(R.id.waiting_status);
            cost = itemView.findViewById(R.id.waiting_cost);
        }
    }

    public static class DoneViewHolder extends RecyclerView.ViewHolder {
        public TextView id, date, status, warranty;

        public DoneViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textView73);
            date = itemView.findViewById(R.id.date_of_bringing);
            status = itemView.findViewById(R.id.status);
            warranty = itemView.findViewById(R.id.warranty);
        }
    }
}
