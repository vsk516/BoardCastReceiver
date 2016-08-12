package com.example.vamsisaikrishna.boardcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    CheckBox myChechBox;
    private IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_TICK);

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(getBaseContext(), "Action_Time_Tick intent Received", Toast.LENGTH_LONG).show();
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myChechBox = (CheckBox) findViewById(R.id.myCheckBox);

    }

    @Override
    protected void onResume() {
        this.registerReceiver(receiver, filter);
        super.onResume();
    }


    @Override
    protected void onPause() {
        this.unregisterReceiver(receiver);
        super.onPause();
    }
}
