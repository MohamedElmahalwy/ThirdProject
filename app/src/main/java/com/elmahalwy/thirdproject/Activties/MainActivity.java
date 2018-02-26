package com.elmahalwy.thirdproject.Activties;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.elmahalwy.thirdproject.Adapters.MainAdapter;
import com.elmahalwy.thirdproject.Models.MainModel;
import com.elmahalwy.thirdproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv_main;
    MainAdapter mainAdapter;
    LinearLayoutManager linearLayoutManager;
    ArrayList<MainModel> main_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitUi();

    }

    void InitUi() {
        main_list = new ArrayList<>();
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayout.VERTICAL, false);
        mainAdapter = new MainAdapter(main_list, this);

        MainModel first_model = new MainModel();
        first_model.setTv_main("Nutilla ");
        first_model.setImage(R.drawable.nuttla_cake);

        MainModel seconde_model = new MainModel();
        seconde_model.setTv_main("Brounies ");
        seconde_model.setImage(R.drawable.bronise_cake);

        MainModel third_model = new MainModel();
        third_model.setTv_main("Yellow cake ");
        third_model.setImage(R.drawable.yellow_cake);

        MainModel fourth_model = new MainModel();
        fourth_model.setTv_main("Cheese cake ");
        fourth_model.setImage(R.drawable.chese_cake);

        main_list.add(0, first_model);
        main_list.add(1, seconde_model);
        main_list.add(2, third_model);
        main_list.add(3, fourth_model);

        rv_main.setLayoutManager(linearLayoutManager);
        rv_main.setAdapter(mainAdapter);
    }

    void get_data() {
        String url = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";
        AndroidNetworking.get(url)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject current_object = response.getJSONObject(i);
                                MainModel mainModel = new MainModel();
                                mainModel.setTv_main(current_object.getString("name"));
                                mainModel.setIngredientsModels(current_object.getJSONArray("ingredients"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        if (error.getErrorCode() != 0) {
                            // received error from server
                            // error.getErrorCode() - the error code from server
                            // error.getErrorBody() - the error body from server
                            // error.getErrorDetail() - just an error detail
                            Log.e("onError errorCode : ", String.valueOf(error.getErrorCode()));
                            Log.e("onError errorBody : ", error.getErrorBody());
                            if (error.getErrorCode() == 400) {
                                Toast.makeText(MainActivity.this, "حدث خطأ ما...", Toast.LENGTH_SHORT).show();
                            }

                            if (error.getErrorCode() == 500) {
                                Toast.makeText(MainActivity.this, "خطأ فى الاتصال بالسيرفر...", Toast.LENGTH_SHORT).show();
                            }

                            // get parsed error object (If ApiError is your class)

                        } else {
                            // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                            Log.e("onError errorDetail : ", error.getErrorDetail());
                            if (error.getErrorDetail().equals("connectionError")) {
                                Toast.makeText(MainActivity.this, "خطأ فى الاتصال بالانترنت...", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }

}
