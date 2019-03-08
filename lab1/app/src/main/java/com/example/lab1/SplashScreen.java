package com.example.lab1;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;


public class SplashScreen extends AppCompatActivity {

    private SleepTask sleepTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        sleepTask = new SleepTask(this);
        sleepTask.execute();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        sleepTask.cancel(true);
    }

    public void onSplashScreenEnd() {
        Intent i = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private static class SleepTask extends AsyncTask<Void, Void, Void> {
        final SplashScreen listener;

        SleepTask(SplashScreen listener) {
            super();
            this.listener = listener;
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (listener != null)
                listener.onSplashScreenEnd();
        }
    }
}
