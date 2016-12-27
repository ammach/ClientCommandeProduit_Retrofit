package com.ammach.clientcommandeproduitretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.ClientAdapter;
import bean.Client;
import interfaces.ClientInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListClientsActivity extends AppCompatActivity {

    ListView listView;
    ClientAdapter clientAdapter;
    List<Client> clients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_clients);

        listView= (ListView) findViewById(R.id.listView);

        getData();

        clientAdapter=new ClientAdapter(clients,this);
        listView.setAdapter(clientAdapter);

    }

    private void getData() {
        clients=new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.5:28075/clientCommandeProduit(test6)/webresources/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClientInterface clientService = retrofit.create(ClientInterface.class);
        Call<List<Client>> callClients = clientService.listClients();
        callClients.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                for (Client client : response.body()) {
                    clients.add(client);
                }
                clientAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {

            }
        });
    }
}
