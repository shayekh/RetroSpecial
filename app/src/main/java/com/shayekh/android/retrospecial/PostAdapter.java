package com.shayekh.android.retrospecial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter  extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private List<Item>items;

    public PostAdapter(Context context, List<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            Item item=items.get(position);
            holder.title.setText(item.getTitle());
           holder.description.setText(item.getContent());
//        Document document = Jsoup.parse(item.getContent());
//        holder.description.setText(document.text());
//
//        Elements elements = document.select("img");
//        Glide.with(context).load(elements.get(0).attr("src")).into(holder.imageView);


        // Glide.with(context).load(tokens.)
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title;
        TextView description;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.image);
            title=(TextView)itemView.findViewById(R.id.postTitle);
            description=(TextView)itemView.findViewById(R.id.postDetails);


        }
    }
}
