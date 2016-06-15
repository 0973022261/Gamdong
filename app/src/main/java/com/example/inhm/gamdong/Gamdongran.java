package com.example.inhm.gamdong;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class Gamdongran extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView tv = new TextView(this);
        tv.setText("호출된 액티비티입니다.");
        tv.setTextSize(20);

        View view = new View(getApplicationContext());
        view.setBackgroundColor(this.getResources().getColor(R.color.tomyung));

        setContentView(tv);


        Toast.makeText(this,"호출된 액티비티입니다.",Toast.LENGTH_LONG).show();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        tv.startAnimation(animation);

    }
}
