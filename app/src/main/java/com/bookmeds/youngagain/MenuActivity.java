package com.bookmeds.youngagain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    GridView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuList = (GridView) findViewById(R.id.menulist);

        ArrayList<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(R.drawable.daily_remainders, "Daily Remainder", ""));
        items.add(new MenuItem(R.drawable.medicines, "Medicines", "Buy medicines online"));
        items.add(new MenuItem(R.drawable.health_camps, "Free Health Camps", "View free health camps near you"));
        items.add(new MenuItem(R.drawable.chat, "Chat", "Chat with friends"));
        items.add(new MenuItem(R.drawable.gather, "Gatherings", "Create or attend a gathering around"));
        menuAdapter adapter = new menuAdapter(this, items);

        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MenuActivity.this, DailyRemainderActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MenuActivity.this, MedicineListActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MenuActivity.this, FreeHealthCampActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MenuActivity.this, ChatActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MenuActivity.this, GatheringsActivity.class));
                        break;
                }
            }
        });
    }
}
