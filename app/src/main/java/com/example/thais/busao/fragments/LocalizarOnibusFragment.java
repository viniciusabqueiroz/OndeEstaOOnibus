package com.example.thais.busao.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thais.busao.R;
import com.example.thais.busao.model.Onibus;
import com.example.thais.busao.services.UserAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LocalizarOnibusFragment extends Fragment {

    Button btnLocalizarOnibus;
    Button btnExibirLocalizacao;
    EditText edtLocalizarOnibus;
    TextView txtExibirOnibus;

    Context context;

    View view;

    public LocalizarOnibusFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_localizar_onibus, container, false);

        edtLocalizarOnibus = view.findViewById(R.id.edtLocalizarOnibus);
        btnLocalizarOnibus = view.findViewById(R.id.btnLocalizarOnibus);
        btnExibirLocalizacao = view.findViewById(R.id.btnExibirLocalizacao);
        txtExibirOnibus = view.findViewById(R.id.txtExibirOnibus);

        btnLocalizarOnibus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserAPI userAPI = UserAPI.retrofit.create(UserAPI.class);
                final Call<Onibus> call = userAPI.getOnibus(edtLocalizarOnibus.getText().toString());
                call.enqueue(new Callback<Onibus>() {
                    @Override
                    public void onResponse(Call<Onibus> call, Response<Onibus> response) {
                        int code = response.code();
                        if (code == 200) {

                            Onibus onibus = response.body();
                            txtExibirOnibus.setText(onibus.toString());
                        } else {
                            Toast.makeText(context,
                                    "Falha:  " + String.valueOf(code),
                                    Toast.LENGTH_LONG).show();
                        }
                    }


                    @Override
                    public void onFailure(Call<Onibus> call, Throwable t) {

                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });


            }
        });

        return view;
    }


}

