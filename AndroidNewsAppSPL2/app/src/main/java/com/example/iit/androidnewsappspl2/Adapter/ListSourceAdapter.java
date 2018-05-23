package com.example.iit.androidnewsappspl2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.iit.androidnewsappspl2.Common.Common;
import com.example.iit.androidnewsappspl2.Interface.IconBetterIdeaService;
import com.example.iit.androidnewsappspl2.Interface.ItemClickListener;
import com.example.iit.androidnewsappspl2.ListNews;
import com.example.iit.androidnewsappspl2.Model.IconBetterIdea;
import com.example.iit.androidnewsappspl2.Model.WebSite;
import com.example.iit.androidnewsappspl2.R;
import com.squareup.picasso.Picasso;

/**
 * Created by reale on 10/4/2017.
 */

class ListSourceViewHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener
{
    ItemClickListener itemClickListener;

    TextView source_title;
    CircleImageView source_image;

    public ListSourceViewHolder(View itemView) {
        super(itemView);

        source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
        source_title = (TextView)itemView.findViewById(R.id.source_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}

public class ListSourceAdapter extends RecyclerView.Adapter<ListSourceViewHolder>{
    private Context context;
    private WebSite webSite;

    private IconBetterIdeaService mService;

    public ListSourceAdapter(Context context, WebSite webSite) {
        this.context = context;
        this.webSite = webSite;

        mService = Common.getIconService();
    }

    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_view_for_each_source,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {


        StringBuilder iconBetterApi=new StringBuilder("http://i.olsh.me/allicons.json?url=");
        iconBetterApi.append(webSite.getSources().get(position).getUrl());
        mService.getIconUrl(iconBetterApi.toString())
                .enqueue(new Callback<IconBetterIdea>() {
                    public void onResponse(Call<IconBetterIdea> call, Response<IconBetterIdea> response) {
                        if (response.body()!= null && response.body().getIcons().size()>0 ){
                                    Picasso.with(context)
                                    .load(response.body().getIcons().get(0).getUrl())
                                    .into(holder.source_image);
                        }
                        else holder.source_image.setImageResource(R.drawable.article);
                    }

                    public void onFailure(Call<IconBetterIdea> call, Throwable t) {

                    }
                });
        holder.source_title.setText(webSite.getSources().get(position).getName());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
               Intent intent = new Intent(context, ListNews.class);
                intent.putExtra("source",webSite.getSources().get(position).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return webSite.getSources().size();
    }
}
