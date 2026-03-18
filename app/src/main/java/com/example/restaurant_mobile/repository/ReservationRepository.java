package com.example.restaurant_mobile.repository;

import android.util.Log;

import com.example.restaurant_mobile.model.ReservationRequest;
import com.example.restaurant_mobile.network.ReservationApiService;
import com.example.restaurant_mobile.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationRepository {
    private ReservationApiService api;

    public ReservationRepository() {
        api = RetrofitClient
                .getInstance()
                .create(ReservationApiService.class);
    }

    public void makeReservation(ReservationRequest request) {

        api.createReservation(request)
                .enqueue(new Callback<Void>() {

                    @Override
                    public void onResponse(
                            Call<Void> call,
                            Response<Void> response) {

                        Log.d("RESERVATION", "Success");
                    }

                    @Override
                    public void onFailure(
                            Call<Void> call,
                            Throwable t) {

                        Log.e("RESERVATION", t.getMessage());
                    }
                });
    }
}
