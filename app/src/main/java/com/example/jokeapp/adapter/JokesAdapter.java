package com.example.jokeapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jokeapp.R;
import com.example.jokeapp.model.JokeClass;
import java.util.ArrayList;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.ViewHolder> {

    final ArrayList<JokeClass> jokesArrayList;

    public JokesAdapter(ArrayList<JokeClass> jokesArrayList) {
        this.jokesArrayList = jokesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JokeClass jokeClass = jokesArrayList.get(position);
        if (jokeClass.joke!=null)
            holder.tvJoke.setText(jokeClass.joke);
        if (jokeClass.setup!=null)
            holder.tvJoke.setText(jokeClass.setup);
        if (jokeClass.delivery!=null) {
            holder.tvDelivery.setVisibility(View.VISIBLE);
            holder.tvDelivery.setText(jokeClass.delivery);
        }
    }

    @Override
    public int getItemCount() {
        return jokesArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvJoke;
        private final TextView tvDelivery;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvJoke = itemView.findViewById(R.id.tvJoke);
            tvDelivery = itemView.findViewById(R.id.tvDelivery);
        }
    }
}
