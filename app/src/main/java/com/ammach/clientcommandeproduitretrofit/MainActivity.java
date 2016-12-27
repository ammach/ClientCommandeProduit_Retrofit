package com.ammach.clientcommandeproduitretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bean.Client;
import interfaces.ClientInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText editId;
    EditText editNom;
    EditText editVille;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        editId= (EditText) findViewById(R.id.idClient);
        editNom= (EditText) findViewById(R.id.nom);
        editVille= (EditText) findViewById(R.id.ville);
    }

    public void createClient(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:28075/clientCommandeProduit(test6)/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClientInterface clientService = retrofit.create(ClientInterface.class);
        Client client=new Client(editId.getText().toString(),editNom.getText().toString(),editVille.getText().toString());
        Call<Void> createClient = clientService.createClient(client);
        createClient.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(MainActivity.this, "user created", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    public void listClients(View view) {
        startActivity(new Intent(this,ListClientsActivity.class));
    }
}
