package sg.edu.np.s10182489.game;

import android.content.Intent;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity_game extends AppCompatActivity {

    private TextView scoreLabel;
    private TextView startLabel;
    private ImageView player;
    private ImageView pink_gem;
    private ImageView pink_gem1;
    private ImageView blue_gem;
    private ImageView red_gem;
    private ImageView treasure_box;

    //SIZE
    private int frameHeight;
    private int playerSize;
    private int screenWidth;
    private int screenHeight;

    /*Animation
    private Animation idle;
    private Animation walkRight;
    private Animation walkLeft;
    */
    //private AnimationManager animManager;

    //Position
    private int playerY;
    private int pink_gemX;
    private int pink_gemY;

    private int pink_gem1X;
    private int pink_gem1Y;

    private int blue_gemX;
    private int blue_gemY;

    private int red_gemX;
    private int red_gemY;

    private int treasure_boxX;
    private int treasure_boxY;

    //sg.edu.np.s10182489.game.Score
    private int score = 0;

    //Initialize class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    private sound_effect sound;

    //Status check
    private boolean action_stat = false;
    private boolean start_stat = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        sound = new sound_effect(this);
        //hello this is a test
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        startLabel = (TextView) findViewById(R.id.startLabel);
        player = (ImageView) findViewById(R.id.player);
        pink_gem = (ImageView) findViewById(R.id.pink_gem);
        pink_gem1 = (ImageView) findViewById(R.id.pink_gem1);
        blue_gem = (ImageView) findViewById(R.id.blue_gem);
        red_gem = (ImageView) findViewById(R.id.red_gem);
        treasure_box = (ImageView) findViewById(R.id.treasurebox);

        //Get screen size.

        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        //Move to out of screen
        pink_gem.setX(-80);
        pink_gem.setY(-80);

        pink_gem1.setX(-80);
        pink_gem1.setY(-80);

        blue_gem.setX(-80);
        blue_gem.setY(-80);

        red_gem.setX(-80);
        red_gem.setY(-80);

        treasure_box.setX(-80);
        treasure_box.setY(-80);


        scoreLabel.setText("sg.edu.np.s10182489.game.Score: 0");



    }

    public void changePosition(){

        collideCheck();

        //pink_gem
        pink_gemX -=12;
        if(pink_gemX < 0){
            pink_gemX = screenWidth + 20;
            pink_gemY = (int)Math.floor(Math.random()*(frameHeight-pink_gem.getHeight()));
        }
        pink_gem.setX(pink_gemX);
        pink_gem.setY(pink_gemY);

        //pink_gem1
        pink_gem1X -=12;
        if(pink_gem1X < 0){
            pink_gem1X = screenWidth + 20;
            pink_gem1Y = (int)Math.floor(Math.random()*(frameHeight-pink_gem1.getHeight()));
        }
        pink_gem1.setX(pink_gem1X);
        pink_gem1.setY(pink_gem1Y);

        //treasurebox
        treasure_boxX -=12;
        if(treasure_boxX < 0){
            treasure_boxX = screenWidth + 20;
            treasure_boxY = (int)Math.floor(Math.random()*(frameHeight-treasure_box.getHeight()));
        }
        treasure_box.setX(treasure_boxX);
        treasure_box.setY(treasure_boxY);

        //blue gem
        blue_gemX -=16;
        if(blue_gemX < 0){
            blue_gemX = screenWidth + 10;
            blue_gemY = (int)Math.floor(Math.random()*(frameHeight-blue_gem.getHeight()));
        }
        blue_gem.setX(blue_gemX);
        blue_gem.setY(blue_gemY);

        //red gem
        red_gemX -=20;
        if(red_gemX < 0){
            red_gemX = screenWidth + 5000;
            red_gemY = (int)Math.floor(Math.random()*(frameHeight-red_gem.getHeight()));
        }
        red_gem.setX(red_gemX);
        red_gem.setY(red_gemY);

        //Move Box
        if(action_stat==true){
            //touching
            playerY -= 20;
        }else{
            //releasing
            playerY += 20;
        }

        if(playerY < 0)
            playerY = 0;
        if (playerY > frameHeight - playerSize)
            playerY = frameHeight - playerSize;

        player.setY(playerY);

        scoreLabel.setText("sg.edu.np.s10182489.game.Score:" + score);
    }

    public void collideCheck(){
        //If the center of the gems hit the player, it counts as 1 hit

        //pink gem
        int pink_gemCenterX = pink_gemX + pink_gem.getWidth() / 2;
        int pink_gemCenterY = pink_gemY + pink_gem.getHeight() / 2;


        if(0<=pink_gemCenterX && pink_gemCenterX <=playerSize && playerY <= pink_gemCenterY && pink_gemCenterY <= playerY + playerSize) {
            score +=10;

            pink_gemX -= 10;

            sound.playhitsound();
        }


        //pink gem1
        int pink_gem1CenterX = pink_gem1X + pink_gem1.getWidth() / 2;
        int pink_gem1CenterY = pink_gem1Y + pink_gem1.getHeight() / 2;

//0 <= pink_gemCenterX <=boxWidth
//playerY <=pink)gemCenterY <=playerY + playerHeight

        if(0<=pink_gem1CenterX && pink_gem1CenterX <=playerSize && playerY <= pink_gem1CenterY && pink_gem1CenterY <= playerY + playerSize) {
            score +=10;

            pink_gem1X -= 10;

            sound.playhitsound();
        }

        //treasurebox
        int treasure_boxCenterX = treasure_boxX + treasure_box.getWidth() / 2;
        int treasure_boxCenterY = treasure_boxY + treasure_box.getHeight() / 2;


        if(0<=treasure_boxCenterX && treasure_boxCenterX <=playerSize && playerY <= treasure_boxCenterY && treasure_boxCenterY <= playerY + playerSize) {
            score +=10;

            treasure_boxX -= 10;

            sound.playhitsound();
        }




        //blue gem
        int blue_gemCenterX = blue_gemX + blue_gem.getWidth() / 2;
        int blue_gemCenterY = blue_gemY + blue_gem.getHeight() / 2;

        if(0<=blue_gemCenterX && blue_gemCenterX <=playerSize && playerY <= blue_gemCenterY && blue_gemCenterY <= playerY + playerSize) {

/*
            score +=30;

            blue_gemX -= 10;
*/

            timer.cancel();
            timer = null;

            sound.playoversound();
            //show Result
            Intent intent = new Intent(getApplicationContext(), recordresult.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }

        //red gem

        //red_gem
        int red_gemCenterX = red_gemX + red_gem.getWidth() / 2;
        int red_gemCenterY = red_gemY + red_gem.getHeight() / 2;

        if(0<=red_gemCenterX && red_gemCenterX <=playerSize && playerY <= red_gemCenterY && red_gemCenterY <= playerY + playerSize) {
            //stop timer

            timer.cancel();
            timer = null;
            sound.playoversound();

            //show Result
            Intent intent = new Intent(getApplicationContext(), recordresult.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }

    }



    public boolean onTouchEvent(MotionEvent me){

        if(start_stat == false){

            start_stat = true;

            //Why get frame and player height there?
            //bECAUSE THE UI HAS NOT BEEN SET ON SCREEN IN oNcREATE

            FrameLayout frame=(FrameLayout) findViewById(R.id.frame);
            frameHeight = frame.getHeight();

            playerY = (int)player.getY();

            playerSize = player.getHeight();

            startLabel.setVisibility(View.GONE);


            timer.schedule(new TimerTask(){
                public void run(){
                    handler.post(new Runnable(){
                        public void run(){
                            changePosition();
                        }
                    });
                }
            }, 0, 15);



        }else{

            if(me.getAction() == MotionEvent.ACTION_DOWN) {
                action_stat = true;

            }else if (me.getAction()==MotionEvent.ACTION_UP){
                action_stat = false;
        }

        }


        return true;
        }
    }


