package sg.edu.np.s10182489.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


    }

    public void onClick(View v)
    {
        Intent in = new Intent(this,MainActivity_game.class);
        startActivity(in);
    }

    public void onClickK(View v)
    {
        Intent in = new Intent(this,instruction.class);
        startActivity(in);
    }



    //Disable return button
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    return true;
            }
        }

        return super.dispatchKeyEvent(event);
    }

}


