package com.example.iit.androidnewsappspl2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//import com.example.iit.androidnewsappspl2.Common.Common;
//import com.example.iit.androidnewsappspl2.Interface.IconBetterIdeaService;
//import com.example.iit.androidnewsappspl2.Interface.ItemClickListener;
//import com.example.iit.androidnewsappspl2.ListNews;
//import com.example.iit.androidnewsappspl2.Model.IconBetterIdea;
//import com.example.iit.androidnewsappspl2.Model.WebSite;
//import com.squareup.picasso.Picasso;

//import de.hdodenhof.circleimageview.CircleImageView;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

/**
 * Created by reale on 10/4/2017.
 */


public class ListCategoryAdapterForItemList extends RecyclerView.Adapter<ListCategoryAdapterForItemList.ListSourceViewHolder>{
    private Context context;
    private ArrayList<String> webSite=new ArrayList<String>();
    private ArrayList<String> deletArrayList =new ArrayList<String>();
    private int count;

    //private IconBetterIdeaService mService;

    public ListCategoryAdapterForItemList(Context context, ArrayList<String> webSite,int count) {
        this.context = context;

        this.webSite = webSite;
        this.count=count;
       // mService = Common.getIconService();
    }

    @Override
    public ListSourceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.each_category_view,parent,false);
        return new ListSourceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ListSourceViewHolder holder, int position) {



        holder.source_title.setText(webSite.get(position));
        //holder.delete.setImageResource(R.drawable.copy);
        if(position<count)holder.deleteOrAddImage.setImageResource(R.drawable.delete);
        else holder.deleteOrAddImage.setImageResource(R.drawable.add);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return webSite.size();
    }
    class ListSourceViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener
    {
        //ItemClickListener itemClickListener;

        TextView source_title;
        ImageView deleteOrAddImage;
        ImageView copy;
        //CircleImageView source_image;

        @SuppressLint("NewApi")
        public ListSourceViewHolder(View itemView) {
            super(itemView);

            //source_image = (CircleImageView) itemView.findViewById(R.id.source_image);
            source_title = (TextView)itemView.findViewById(R.id.source_name);
            deleteOrAddImage=(ImageView)itemView.findViewById(R.id.deleteOrAddImg);
//            delete.setImageResource(R.drawable.delete);
//            copy = (ImageView)itemView.findViewById(R.id.copy);
//            copy.setImageResource(R.drawable.copy);
            // itemView=(ImageView)itemView.findViewById(R.id.img);
            //itemView.setOnClickListener(this);
        }

        public void setListeners() {
           // delete.setOnClickListener(ListSourceViewHolder.this);
            //copy.setOnClickListener(ListSourceViewHolder.this);
            //this.itemClickListener = itemClickListener;
            deleteOrAddImage.setOnClickListener(ListSourceViewHolder.this);
        }

        @Override
        public void onClick(View view) {
//            switch ((view.getId().s)){
//                case R.id.delete :
//                    removeItem(getAdapterPosition(),webSite.get(getAdapterPosition()));
//                    break;
//                case R.id.copy:
//                    addItem(getAdapterPosition());
//            }
            //itemClickListener.onClick(view,getAdapterPosition(),false);
            if(getAdapterPosition()<count)removeItem(getAdapterPosition(),webSite.get(getAdapterPosition()));
            else addItem(getAdapterPosition(),webSite.get(getAdapterPosition()));
        }
    }

    public void removeItem(int position,String removeItemName){
          webSite.remove(position);
          notifyItemRemoved(position);
          notifyItemRangeChanged(position,webSite.size());
          count=count-1;
          webSite.add(count,removeItemName);
          notifyItemInserted(count);
          notifyItemRangeChanged(count,webSite.size());
          SingletonForUserInformation.getSingletonForUserInformation().deleteCategoryForUser(removeItemName);
          //notifyDataSetChanged();
    }
    public void addItem(int position,String addItemName){
        webSite.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,webSite.size());
        count=count+1;
        webSite.add(count-1,addItemName);
        notifyItemInserted(count-1);
        notifyItemRangeChanged(count-1,webSite.size());
        SingletonForUserInformation.getSingletonForUserInformation().addCategoryForUser(addItemName);

        //notifyDataSetChanged();
    }

}
