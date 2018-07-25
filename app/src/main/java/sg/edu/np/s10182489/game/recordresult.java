package sg.edu.np.s10182489.game;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class recordresult extends AppCompatActivity {

    TextView scoreLabel;
    TextView highScoreLabel;
    Button viewScore;

    DatabaseReference databaseScore;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordresult);

        TextView scoreLabel = (TextView)findViewById(R.id.scoreLabel);
        TextView highScoreLabel = (TextView)findViewById(R.id.highScoreLabel);

        databaseScore = FirebaseDatabase.getInstance().getReference("scores");

        int score = getIntent().getIntExtra("SCORE", 0);

        scoreLabel.setText(score + "");

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);

        int highScore = settings.getInt("HIGH_SCORE", 0);

        if(score > highScore)
        {
            highScoreLabel.setText("High Score : " + score);

//save
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE", score);
            editor.commit();
        }
        else
            {

            highScoreLabel.setText("High Score: " + highScore);

            }

       /* viewScore.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return false;
            }
        });
*/
    }

    //method to add score  into the database
   private void addScore()
    {
        //Value of the score
        String Score = scoreLabel.getText().toString();
        if(!TextUtils.isEmpty(Score))
        {
            //to generate the unique key and get the key form the database.
           String scoreID = databaseScore.push().getKey();
           //note the code ontop may not be necessary.

            Score score = new Score(Score);

            databaseScore.child(scoreID).setValue(Score);
            //the code below would be implemented when the code above is not implemented.
            //databaseScore.setValue(Score);
        }

    }
    public void goMenu(View view)
    {
        startActivity(new Intent(getApplicationContext(), menu.class));
    }

    public void tryAgain(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity_game.class));
    }
    /*
    public void viewScore(View view)
    {
        startActivity(new Intent(getApplicationContext(), game_recyclerview.class));
    }
    */

}
