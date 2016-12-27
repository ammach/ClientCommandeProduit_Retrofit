package interfaces;

import java.util.List;

import bean.Client;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ammach on 10/29/2016.
 */
public interface ClientInterface {
    @GET("client/list")
    Call<List<Client>> listClients();

    @POST("client")
    Call<Void> createClient(@Body Client client);
}
