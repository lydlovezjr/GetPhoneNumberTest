package com.example.administrator.getphonenumbertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bt_in)
    Button btIn;
    @BindView(R.id.bt_in_cancel)
    Button btInCancel;
    @BindView(R.id.bt_out)
    Button btOut;
    @BindView(R.id.bt_out_cancel)
    Button btOutCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_in, R.id.bt_in_cancel, R.id.bt_out, R.id.bt_out_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_in:
                Intent startIncomingService = new Intent(this, IncomingCallService.class);
                startService(startIncomingService);
                Toast.makeText(this, "获取来电号码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_in_cancel:
                Intent stopIncomingService = new Intent(this, IncomingCallService.class);
                stopService(stopIncomingService);
                Toast.makeText(this, "不获取来电号码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_out:
                Intent startOutgoingService = new Intent(this, OutgoingCallService.class);
                startService(startOutgoingService);
                Toast.makeText(this, "获取去电号码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_out_cancel:
                Intent stopOutgoingService = new Intent(this, OutgoingCallService.class);
                stopService(stopOutgoingService);
                Toast.makeText(this, "不获取去电号码", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
