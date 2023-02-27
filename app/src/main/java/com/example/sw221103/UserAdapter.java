package com.example.sw221103;

import android.accounts.AbstractAccountAuthenticator;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserVH> {

    private Context context;

    ArrayList<User1> list = new ArrayList<>();

    public UserAdapter(Context context, ArrayList<User1> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new UserVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserVH holder, int position) {
        User1 user1 = list.get(holder.getBindingAdapterPosition());

        holder.nameText.setText(user1.getUser_name());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("key", user1.getUser_key());
                intent.putExtra("name", user1.getUser_name());
                intent.putExtra("age", user1.getUser_content());
                intent.putExtra("date", user1.getUser_date());
                intent.putExtra("orderdate", user1.getUser_order_date());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserVH extends RecyclerView.ViewHolder{
        TextView nameText;
        CardView cardView;

        public UserVH(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.name_text);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
