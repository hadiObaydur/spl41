package com.example.iit.androidnewsappspl2.Interface;

import com.example.iit.androidnewsappspl2.Common.Common;
import com.example.iit.androidnewsappspl2.Model.News;
import com.example.iit.androidnewsappspl2.Model.WebSite;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by reale on 10/4/2017.
 */

public interface NewsService {
   // @GET("v2/sources?language=en&category=sports&apiKey="+Common.API_KEY)
    @GET
    Call<WebSite> getSources(@Url String url);

    @GET
    Call<News> getNewestArticles(@Url String url);

}
