package com.serpider.github.retrofit_sample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.serpider.github.retrofit_sample.R;
import com.serpider.github.retrofit_sample.api.RetrofitClient;
import com.serpider.github.retrofit_sample.model.PersonPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
Developed for users by @Serpider
Please read the comments thoroughly before use
*/

public class ListActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ListView listView;
    MaterialButton btnRefresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        /*function to call the view to Java code*/
        initView();
        /*function to Retrofit*/
        loadData();
    }

    private void initView() {
        listView = findViewById(R.id.list_item);
        progressBar = findViewById(R.id.progress_circular);
        btnRefresh = findViewById(R.id.btnRefresh);

        /*Click for Refresh Data from Server*/
        btnRefresh.setOnClickListener(v -> {
            loadData();
        });
    }

    private void loadData() {
        /*The appearance of the loader*/
        progressBar.setVisibility(View.VISIBLE);
        /* By pouring the information received by RetrofitClient in the form of a JSON file, it saves it in the person's model list */
        Call<List<PersonPOJO>> call = RetrofitClient.getInstance().getApi().getPerson();
        /* Send request and receive information */
        call.enqueue(new Callback<List<PersonPOJO>>() {
            @Override
            public void onResponse(Call<List<PersonPOJO>> call, Response<List<PersonPOJO>> response) {
                /* Display the received information in the list view */
                listView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                List<PersonPOJO> personList = response.body();
                String[] perons = new String[personList.size()];

                for (int i = 0; i<personList.size(); i++) {
                    perons[i] = personList.get(i).getFirst_name();
                }

                listView.setAdapter(new ArrayAdapter<>(ListActivity.this, android.R.layout.simple_list_item_1, perons));

                /*Click List Item*/
                listView.setOnItemClickListener((parent, view, position, id) -> {
                    Toast.makeText(getApplicationContext(), personList.get(position).getFirst_name(), Toast.LENGTH_SHORT).show();
                });

            }
            /* If there is a problem with the server side codes, you can find the problems with the error message */
            @Override
            public void onFailure(Call<List<PersonPOJO>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage() , Toast.LENGTH_SHORT).show();
                listView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }
        });

    }
}