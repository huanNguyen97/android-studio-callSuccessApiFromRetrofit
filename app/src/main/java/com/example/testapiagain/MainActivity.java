package com.example.testapiagain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.testapiagain.api.ApiService;
import com.example.testapiagain.model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textViewTerms, textViewSource, textViewUsdVnd;
    Button btnCallApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTerms = findViewById(R.id.textView_terms);
        textViewSource = findViewById(R.id.textView_source);
        textViewUsdVnd = findViewById(R.id.textView_privacy);
        btnCallApi = findViewById(R.id.btn);

        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService.apiService.convertUsdToVnd(
            "843d4d34ae72b3882e3db642c51e28e6",
            "VND",
            "USD",
            1
        ).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                textViewSource.setText(user.getSource());
                textViewTerms.setText(user.getTerms());
                textViewUsdVnd.setText(user.getQuotes().getUSDVND());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}