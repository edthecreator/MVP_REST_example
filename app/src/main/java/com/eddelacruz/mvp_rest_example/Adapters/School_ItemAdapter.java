package com.eddelacruz.mvp_rest_example.Adapters;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.eddelacruz.mvp_rest_example.Listeners.RecyclerItemClickListener;
import com.eddelacruz.mvp_rest_example.Models.School_Item;
import com.eddelacruz.mvp_rest_example.R;

import java.util.List;

public class School_ItemAdapter extends RecyclerView.Adapter<School_ItemAdapter.EmployeeViewHolder> {

    private List<School_Item> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public School_ItemAdapter(List<School_Item> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.School_Name.setText(dataList.get(position).getSchool_name());
        holder.School_Boro.setText(dataList.get(position).getBoro());
        holder.School_PhoneNumber.setText(dataList.get(position).getPhone_number());
        holder.School_Email.setText(dataList.get(position).getSchool_email());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView School_Name, School_Boro, School_PhoneNumber, School_Email;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            School_Name =  itemView.findViewById(R.id.School_name);
            School_Boro =  itemView.findViewById(R.id.School_boro);
            School_PhoneNumber =  itemView.findViewById(R.id.School_phonenumber);
            School_Email = itemView.findViewById(R.id.School_email);

        }
    }
}