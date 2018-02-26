package com.elmahalwy.thirdproject.Activties;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.elmahalwy.thirdproject.R;

import butterknife.BindView;

public class DetailsActivity extends AppCompatActivity {
    @BindView(R.id.card_view)
    CardView card_view;
    RecyclerView items_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        InitUi();
        InitEventDriven();

    }

    private void InitUi() {


    }

    private void InitEventDriven() {
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),IngredientActivity.class);
                intent.putExtra("type",getIntent().getStringExtra("type"));
                startActivity(intent);
            }
        });
    }
}
