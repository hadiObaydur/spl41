package com.example.iit.androidnewsappspl2;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.iit.androidnewsappspl2.Adapter.ListSourceAdapter;
import com.example.iit.androidnewsappspl2.Common.Common;
import com.example.iit.androidnewsappspl2.Interface.NewsService;
import com.example.iit.androidnewsappspl2.Model.WebSite;
import com.google.gson.Gson;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFragmentForYou extends Fragment {
    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mService;
    ForYouAdapter adapter;
    AlertDialog dialog;
    SwipeRefreshLayout swipeLayout;

    private int position;
    ArrayList<String>preferSources=new ArrayList<String>();
    ArrayList<String>preferSourcesForAdapter=new ArrayList<String>();
   // private String category;
    //private String selectedCountry;
    // private TextView content;
    // private ImageView image;

    public static Fragment getInstance(int position) {
        TabFragmentForYou f = new TabFragmentForYou();
        Bundle args = new Bundle();
        args.putInt("position", position);
        //args.putString("category", category);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position=getArguments().getInt("position");
        //get data from Argument

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,@Nullable Bundle savedInstanceState) {

        // category = getArguments().getString("category");

        return inflater.inflate(R.layout.list_of_prefersources_layout, container, false);
    }

    @Override
    public void onViewCreated(View view , @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // Toast.makeText(getActivity(),""+position,Toast.LENGTH_LONG).show();
        //image = (ImageView) view.findViewById(R.id.image);
        //content = (TextView) view.findViewById(R.id.textView);
        preferSources=SingletonForUserInformation.getSingletonForUserInformation().getPreferSources();
        preferSourcesForAdapter=SingletonForUserInformation.getSingletonForUserInformation().getPreferSourcesForAdapter();

        //Paper.init(getContext());

        //Init Service
        //mService = Common.getNewsService();

        //Init View
       // swipeLayout = getActivity().findViewById(R.id.swipeRefresh);
//        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                loadForYouSource();
//
//            }
//        });

       listWebsite =view.findViewById(R.id.list_prefersource);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        listWebsite.setLayoutManager(layoutManager);
        adapter  = new ForYouAdapter(getContext(), preferSources,preferSourcesForAdapter);
        adapter.notifyDataSetChanged();
        listWebsite.setAdapter(adapter);

        //dialog = new SpotsDialog(getActivity());

       // loadForYouSource();
        //Toast.makeText(getContext(),""+SingletonForUserInformation.getSingletonForUserInformation().getBlockSourcesForAdapter().get(0),Toast.LENGTH_LONG).show();
    }
    private void loadForYouSource() {


                    adapter  = new ForYouAdapter(getContext(),preferSources,preferSourcesForAdapter);
                    adapter.notifyDataSetChanged();
                    listWebsite.setAdapter(adapter);



             //swipeLayout.setRefreshing(false);


    }
}