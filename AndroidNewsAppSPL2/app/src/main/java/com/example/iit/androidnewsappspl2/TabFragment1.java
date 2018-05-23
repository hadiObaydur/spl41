package com.example.iit.androidnewsappspl2;
 
import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iit.androidnewsappspl2.Adapter.ListSourceAdapter;
import com.example.iit.androidnewsappspl2.Common.Common;
import com.example.iit.androidnewsappspl2.Interface.NewsService;
import com.example.iit.androidnewsappspl2.Model.WebSite;
import com.google.gson.Gson;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabFragment1 extends Fragment {
    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mService;
    ListSourceAdapter adapter;
    AlertDialog dialog;
    SwipeRefreshLayout swipeLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_of_sources_layout, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // getActivity().setTitle("Home");

        Paper.init(getActivity());

        //Init Service
        mService = Common.getNewsService();

        //Init View
        swipeLayout = getActivity().findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadWebsiteSource(true);

            }
        });

        listWebsite = getActivity().findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        listWebsite.setLayoutManager(layoutManager);

        dialog = new SpotsDialog(getActivity());

        loadWebsiteSource(true);

    }

    private void loadWebsiteSource(boolean isRefreshed) {
//        if(!isRefreshed)
//        {
//
//            String cache = Paper.book().read("cache");
//            if(cache != null && !cache.isEmpty() && !cache.equals("null")) // If have cache
//            {
//                WebSite website = new Gson().fromJson(cache,WebSite.class); // Convert cache from Json to Object
//                adapter = new ListSourceAdapter(getContext(),website);
//                adapter.notifyDataSetChanged();
//                listWebsite.setAdapter(adapter);
//            }
//            else // If not have cache
//            {
//                dialog.show();
//                //Fetch new data
//                mService.getSources("").enqueue(new Callback<WebSite>() {
//                    @Override
//                    public void onResponse(Call<WebSite> call, Response<WebSite> response) {
//                        adapter  = new ListSourceAdapter(getContext(),response.body());
//                        adapter.notifyDataSetChanged();
//                        listWebsite.setAdapter(adapter);
//
//                        //Save to cache
//                        Paper.book().write("cache",new Gson().toJson(response.body()));
//
//                        dialog.dismiss();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<WebSite> call, Throwable t) {
//
//                    }
//                });
//            }
//        }
//        else // If from Swipe to Refresh
//        {
//
//            swipeLayout.setRefreshing(true);
//            //Fetch new data
//            mService.getSources("g").enqueue(new Callback<WebSite>() {
//                @Override
//                public void onResponse(Call<WebSite> call, Response<WebSite> response) {
//                    adapter  = new ListSourceAdapter(getContext(),response.body());
//                    adapter.notifyDataSetChanged();
//                    listWebsite.setAdapter(adapter);
//
//                    //Save to cache
//                    Paper.book().write("cache",new Gson().toJson(response.body()));
//
//                    //Dismiss refresh progressring
//                    swipeLayout.setRefreshing(false);
//                }
//
//                @Override
//                public void onFailure(Call<WebSite> call, Throwable t) {
//
//                }
//            });
//
//        }
//    }
    }
}