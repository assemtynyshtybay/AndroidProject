package com.example.loginer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v2/quotes/all?page=1&limit=200")
    Call<List<Quote>> getQuotes();
    @GET("api/v2/quotes/all?page=1&limit=200")
    Call<List<Quote>> getQuotesBySearch(String query);
}
