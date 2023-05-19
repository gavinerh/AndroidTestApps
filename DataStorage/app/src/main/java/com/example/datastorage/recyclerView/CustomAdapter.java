package com.example.datastorage.recyclerView;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.datastorage.R;
import com.example.datastorage.dao.UserDao;
import com.example.datastorage.database.AppDatabase;
import com.example.datastorage.entity.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<User> userList;
    Context context;
    private CustomClickListener clickListener;
    private AppDatabase appDatabase;
    private DeleteListener deleteListener;

    public CustomAdapter(Context context, List<User> userList, CustomClickListener clickListener, DeleteListener deleteListener) {
        this.clickListener = clickListener;
        this.context = context;
        this.userList = userList;
        this.deleteListener = deleteListener;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View cardItem = inflater.inflate(R.layout.card_item,parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(cardItem, deleteListener);
        viewHolder.setCustomClickListener(clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        User user = userList.get(position);
        holder.editTextFirstName.setText(user.firstName);
        holder.editTextLastName.setText(user.lastName);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

}
