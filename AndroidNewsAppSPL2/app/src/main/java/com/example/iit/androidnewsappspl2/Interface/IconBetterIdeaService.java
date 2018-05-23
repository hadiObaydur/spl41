package com.example.iit.androidnewsappspl2.Interface;

import com.example.iit.androidnewsappspl2.Model.IconBetterIdea;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by reale on 10/4/2017.
 */

public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}
