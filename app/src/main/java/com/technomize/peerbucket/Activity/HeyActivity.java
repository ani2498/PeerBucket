package com.technomize.peerbucket.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.technomize.peerbucket.Adapter.NewNotificationAdapter;
import com.technomize.peerbucket.Adapter.OldNotificationAdapter;
import com.technomize.peerbucket.R;

/**
 * Created by rishi on 10/1/2018.
 */

public class HeyActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView newNotiRecyclerView,oldNotiRecylerView;
    private FloatingActionButton floatingActionButton;
    private LinearLayout mtab_start_activity_LL,closeFabLayout,mtab_start_me_LL,mtab_start_home_LL;
    private CardView fabLayout,mcv_search_expand;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hey);

        initUI();
        initToolbar();

        initNewNotiRecyclerView();
        initOldNotiRecyclerView();
    }

    private void initNewNotiRecyclerView () {
        newNotiRecyclerView = findViewById(R.id.new_notification_recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        newNotiRecyclerView.setLayoutManager(linearLayoutManager);

        NewNotificationAdapter adapter = new NewNotificationAdapter();
        newNotiRecyclerView.setAdapter(adapter);

    }

    private void initOldNotiRecyclerView () {
        oldNotiRecylerView = findViewById(R.id.old_notification_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        oldNotiRecylerView.setLayoutManager(linearLayoutManager);

        OldNotificationAdapter adapter = new OldNotificationAdapter();
        oldNotiRecylerView.setAdapter(adapter);
    }

    private void initUI () {

        floatingActionButton = findViewById(R.id.fab);
        fabLayout = findViewById(R.id.fab_layout);
        closeFabLayout = findViewById(R.id.close_fab_layout);

        mtab_start_activity_LL=(LinearLayout)findViewById(R.id.tab_start_activity_LL);
        mtab_start_home_LL=(LinearLayout)findViewById(R.id.tab_start_home_LL);
        mtab_start_me_LL=(LinearLayout)findViewById(R.id.tab_start_me_LL);
        mcv_search_expand=(CardView)findViewById(R.id.cv_search_expand);

        mcv_search_expand.setOnClickListener(this);
        closeFabLayout.setOnClickListener(this);
        floatingActionButton.setOnClickListener(this);
        mtab_start_activity_LL.setOnClickListener(this);
        mtab_start_me_LL.setOnClickListener(this);
        mtab_start_home_LL.setOnClickListener(this);

    }

    private void initToolbar () {

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);
        collapsingToolbar.setCollapsedTitleTextAppearance(R.style.collapsingToolbarLayoutTitleColor);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                mcv_search_expand.setVisibility(View.VISIBLE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tab_start_activity_LL:
                Intent startActivityScreen= new Intent(this,ActivityScreen.class);
                startActivity(startActivityScreen);
                finish();
                break;

            case R.id.tab_start_me_LL:
                Intent activity = new Intent(this,MeActivity.class);
                startActivity(activity);
                finish();
                break;

            case R.id.tab_start_home_LL:
                Intent activity1 = new Intent(this,HomeActivity.class);
                startActivity(activity1);
                finish();
                break;

            case R.id.fab:
                floatingActionButton.setVisibility(View.GONE);
                fabLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.close_fab_layout:
                fabLayout.setVisibility(View.GONE);
                floatingActionButton.setVisibility(View.VISIBLE);
                break;
        }
    }

}
