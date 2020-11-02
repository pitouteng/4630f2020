package com.example.firstapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenWeatherApi {
    @GET("data/2.5/weather?q=Boston&units=imperial&appid=3584d4b627d9d0c95663c224f5a63036")
    Call<WeatherResponse> getWeather();

}
