package sg.edu.np.s10182489.game;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class instruction extends AppCompatActivity {

    Button flash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        Handler h = new Handler();
        h.postDelayed(new Runnable(){
            public void run(){
                startFlash();
            }
        }, 3000);
    }

    public void startFlash()
    {
        flash=(Button)findViewById(R.id.playbutton);

        Animation blinkanimation = new AlphaAnimation(1, 0);

        blinkanimation.setDuration(200);

        blinkanimation.setInterpolator(new LinearInterpolator());

        blinkanimation.setRepeatCount(5);

        blinkanimation.setRepeatMode(Animation.REVERSE);

        flash.startAnimation(blinkanimation);
    }

    public void onClick(View v)
    {
        Intent in = new Intent(this,MainActivity_game.class);
        startActivity(in);
    }
}
