package co.edu.eci.ieti.android.network;

import java.io.IOException;
import java.util.List;

import co.edu.eci.ieti.android.network.data.Task;
import co.edu.eci.ieti.android.network.service.AuthService;
import co.edu.eci.ieti.android.network.service.TaskService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Santiago Carrillo
 * 4/23/19.
 */
public class RetrofitNetwork
{

    private static final String BASE_URL = "http://localhost:8080/api/";
    private AuthService authService;
    private TaskService taskService;


    public RetrofitNetwork()
    {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( "http://192.168.100.118:8080/" ) //localhost for emulator
            .addConverterFactory( GsonConverterFactory.create() ).build();


        authService = retrofit.create( AuthService.class );
        taskService = retrofit.create( TaskService.class );
        Call<List<Task>> taskList = taskService.listTasks();
        System.out.println(taskList);
    }

    public RetrofitNetwork( final String token )
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor( new Interceptor()
        {
            @Override
            public okhttp3.Response intercept( Chain chain )
                    throws IOException
            {
                Request original = chain.request();

                Request request = original.newBuilder().header( "Accept", "application/json" ).header( "Authorization",
                        "Bearer "
                                + token ).method(
                        original.method(), original.body() ).build();
                return chain.proceed( request );
            }
        } );
        Retrofit retrofitList =
                new Retrofit.Builder().baseUrl( BASE_URL ).addConverterFactory( GsonConverterFactory.create() ).client(
                        httpClient.build() ).build();

    }

    public AuthService getAuthService()
    {
        return authService;
    }

    public TaskService getTaskService(){
        return taskService;
    }
}
