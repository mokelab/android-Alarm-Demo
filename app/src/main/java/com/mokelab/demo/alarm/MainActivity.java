package com.mokelab.demo.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
            }
        });
    }

    private void setAlarm() {
        EditText messageEdit = (EditText) findViewById(R.id.edit_message);
        String message = messageEdit.getText().toString();
        if (TextUtils.isEmpty(message)) {
            return;
        }

        Context context = this;
        AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent it = new Intent(context, MessageService.class);
        it.putExtra(Intent.EXTRA_TEXT, message);
        int requestCode = 1;
        PendingIntent pendingIntent = PendingIntent.getService(context, requestCode, it, PendingIntent.FLAG_UPDATE_CURRENT);
        manager.set(AlarmManager.ELAPSED_REALTIME, 3000, pendingIntent);
        Toast.makeText(context, R.string.start, Toast.LENGTH_SHORT).show();
    }
}
