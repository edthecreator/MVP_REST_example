package com.eddelacruz.mvp_rest_example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eddelacruz.mvp_rest_example.Adapters.School_ItemAdapter;
import com.eddelacruz.mvp_rest_example.Listeners.GETCall;
import com.eddelacruz.mvp_rest_example.Listeners.MainPresenterInteract;
import com.eddelacruz.mvp_rest_example.Listeners.PVContract;
import com.eddelacruz.mvp_rest_example.Listeners.RecyclerItemClickListener;
import com.eddelacruz.mvp_rest_example.Models.School_Item;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements PVContract.MainView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;

    private PVContract.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeRecyclerView();
        initProgressBar();


        presenter = new MainPresenterInteract(this, new GETCall());
        presenter.requestDataFromServer();

    }

    private void initializeRecyclerView() {

        recyclerView = findViewById(R.id.recycler_view_employee_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


    }

    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER);
        relativeLayout.addView(progressBar);

        RelativeLayout.LayoutParams params = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        progressBar.setVisibility(View.INVISIBLE);

        this.addContentView(relativeLayout, params);
    }

    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(School_Item School_Item) {
        }
    };


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }


    @Override
    public void setDataToRecyclerView(final List<School_Item> School_ItemArrayList) {

        this.runOnUiThread(new Runnable() {
            public void run() {
                School_ItemAdapter adapter = new School_ItemAdapter(School_ItemArrayList , recyclerItemClickListener);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this,
                "error: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }



}
