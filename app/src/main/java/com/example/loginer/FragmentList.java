package com.example.loginer;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentList extends Fragment {
    public RecyclerView recyclerView;
    public FragmentManager fragmentManager;
    public QuoteAdapter adapter;
    public List<Quote> jobs = new ArrayList<>();
    private ItemClickListener listener = null;
    private Retrofit retrofit;
    private ApiService api;

    public static FragmentList newInstance(String qT, String qA) {
        FragmentList fragment = new FragmentList();
        Bundle bundle = new Bundle();
        bundle.putString("quoteText", qT);
        bundle.putString("quotaAuthor", qA);
        fragment.setArguments(bundle);
        return fragment;
    }
    public static FragmentList newInstance() {
        return new FragmentList();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.quotelist, container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Quotes");
        setHasOptionsMenu(true);
        recyclerView=view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        //при нажатии на отдельный айтем "открывается" DetailFragment
        listener = new ItemClickListener() {
            @Override
            public void itemclick(int position, Quote quote) {
                fragmentManager = getFragmentManager();
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, FragmentDetail.newInstance(quote))
                        .addToBackStack("second")
                        .commit();
            }
        };
        adapter= new QuoteAdapter(jobs, listener);
        recyclerView.setAdapter(adapter);
        return view;
    }

    //инициализация сервиса
    public void initService(){
        try{
            //логирует наш запрос
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//насколько информативно должны быть логи который приходит с сервера
            //клиент который делает наши запросы, можем разные условии указать
            OkHttpClient okHttpClient=new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();
            //создаем инстанс ретрофита
            retrofit=new Retrofit.Builder()
                    .baseUrl("https://quote-garden.herokuapp.com/") //ссылка нашей базы
                    .addConverterFactory(GsonConverterFactory.create()) //нужен чтобы спарсить приходящий json в наш класс
                    .client(okHttpClient)
                    .build();
            //создаем интанс нашего сервиса внутри которого есть наши методы
            api= retrofit.create(ApiService.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getJobs(){
        Call<List<Quote>> call = api.getQuotes();
        call.enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                Log.e("Responses #",response.body().size()+"");
            }
            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.e("error is",t.getMessage());
            }

        });
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Call<List<Quote>> call = api.getQuotesBySearch(query);
                call.enqueue(new Callback<List<Quote>>() {
                    @Override
                    public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                        fetchResponse(response);
                    }

                    @Override
                    public void onFailure(Call<List<Quote>> call, Throwable t) {
                        Log.e("Search was reject: ", t.getMessage());
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void fetchResponse(Response<List<Quote>> response) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return false;
    }
}
