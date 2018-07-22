package sg.edu.np.s10182489.game;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import sg.edu.np.s10182489.game.R;

public class sound_effect {

    private AudioAttributes audioAttributes;
    final int SOUND_POOL_MAX= 2;

    private static SoundPool soundpool;
    private static int hitsound;
    private static int oversound;

    public sound_effect(Context context)
    {

        /*
        //SoundPool is deprecated in KITKAT
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundpool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(SOUND_POOL_MAX)
                    .build();
        }
        else
        {
            soundpool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }

*/

        soundpool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);



        hitsound = soundpool.load(context, R.raw.achieve, 1);
        oversound = soundpool.load(context, R.raw.over, 1);

    }

    public void playhitsound()
    {
//play(int sound ID, float left volume, float right volume, int priority, int loop, float rate)
        soundpool.play(hitsound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playoversound()
    {
        soundpool.play(oversound, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
