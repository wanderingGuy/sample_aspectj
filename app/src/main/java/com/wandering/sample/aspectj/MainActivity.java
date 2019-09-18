package com.wandering.sample.aspectj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tv)
    TextView textView;
    @BindView(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Animal animal = new Animal();
        Log.d(TAG, " onCreate fly start...");
        animal.fly();
        Log.d(TAG, " onCreate finish...");
        animal.run(100);

        animal.getName("zhangsannnnnn");

        tv2.setOnClickListener(v -> Log.d(TAG, "tv2 onclick exe..."));//lamada express Aspectj not work
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "11 onclick exe...v:" + v);
            }
        });

        animal.setAge(10);

    }

}
