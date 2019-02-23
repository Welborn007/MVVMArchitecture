package in.kesari.mvvmarchitecture;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import in.kesari.mvvmarchitecture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

        ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Thread myThread = new Thread()
        {
            @Override
            public void run() {
                try {
                    sleep(4000);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startApp();
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }

    public void startApp()
    {
        activityMainBinding.WelcomeScreen.setVisibility(View.VISIBLE);
        activityMainBinding.splashImage.setVisibility(View.GONE);

        activityMainBinding.getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityMainBinding.WelcomeScreen.setVisibility(View.GONE);
                activityMainBinding.splashImage.setVisibility(View.GONE);
                activityMainBinding.Dashboard.setVisibility(View.VISIBLE);
            }
        });

        activityMainBinding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        activityMainBinding.contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        activityMainBinding.subjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
