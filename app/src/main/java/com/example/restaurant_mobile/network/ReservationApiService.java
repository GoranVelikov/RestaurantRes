package com.example.restaurant_mobile.network;

import com.example.restaurant_mobile.model.ReservationRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ReservationApiService {
    @POST("/reservations")
    Call<Void> createReservation(
            @Body ReservationRequest request
    );
}
