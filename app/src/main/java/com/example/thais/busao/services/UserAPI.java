package com.example.thais.busao.services;

import com.example.thais.busao.model.Onibus;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by thais on 08/05/18.
 */

public interface UserAPI {

    @GET("/onibus/{onibus}")
    Call<Onibus> getOnibus(@Path("onibus") String onibus);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://dadosabertos.rio.rj.gov.br/apiTransporte/apresentacao/rest/index.cfm/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
