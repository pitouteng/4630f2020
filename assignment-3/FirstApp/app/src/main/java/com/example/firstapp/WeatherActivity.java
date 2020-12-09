package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.Math.round;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        try {
            getWeather();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getWeather() throws IOException {
        final TextView weatherTemp = findViewById(R.id.weatherTemp);
        final TextView weatherInfo = findViewById(R.id.weatherInfo);

        String key = "3584d4b627d9d0c95663c224f5a63036";
        String city = "Boston";
        String baseUrl = "https://api.openweathermap.org/";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Boston&appid=" + key + "/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        OpenWeatherApi openWeatherApi  = retrofit.create(OpenWeatherApi.class);
        Call<WeatherResponse> c = openWeatherApi.getWeather();
        c.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful()) {
                    WeatherResponse.Main m  = response.body().main;
                    weatherTemp.setText(m.getTemp() + " F°");
                    String weatherReport = "";
                    weatherReport += "Min:\t" + m.getTempMin() + " F°\n";
                    weatherReport += "Max:\t" + m.getTempMax() + " F°\n";
                    weatherReport += "Feels Like:\t" + m.getFeelsLike() + " F°\n";
                    weatherReport += "Humidity:\t" + m.getHumidity() + " %";
                    weatherInfo.setText(weatherReport);

                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

        System.out.println("HELLO in get weather");
    }
}