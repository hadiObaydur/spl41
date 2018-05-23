package com.example.iit.androidnewsappspl2;

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

import java.util.ArrayList;

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

        source_image = (CircleImageView) itemView.findViewById(R.id.prefersource_image);
        source_title = (TextView)itemView.findViewById(R.id.prefersource_name);

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

public class ForYouAdapter extends RecyclerView.Adapter<ListSourceViewHolder>{
    private Context context;
    //private WebSite webSite;
    ArrayList<String>preferSources=new ArrayList<String>();
    ArrayList<String>preferSourcesForAdapter=new ArrayList<String>();
    private IconBetterIdeaService mService;

    public ForYouAdapter(Context context, ArrayList<String>preferSources,ArrayList<String>preferSourcesForAdapter) {
        this.context = context;
        //this.webSite = webSite;
        this.preferSources=preferSources;
        this.preferSourcesForAdapter=preferSourcesForAdapter;

       // mService = Common.getIconService();
    }

    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.card_view_each_prefersource,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {

        holder.source_image.setImageResource(R.drawable.article);
        holder.source_title.setText(preferSources.get(position).replace('-',' '));

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, PreferListNews.class);
                intent.putExtra("source",preferSources.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return preferSources.size();
    }
}
