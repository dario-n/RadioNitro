package ndj.daro.radiotu;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;


public class RadioService extends Service implements MediaPlayer.OnPreparedListener {
    private MediaPlayer player;

    @Override
    public void onCreate() {
        player = new MediaPlayer();

        try {
            player.reset();
            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource("http://us1.internet-radio.com:11094");
            player.setOnPreparedListener(this);
            player.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (player.isPlaying()){
            player.pause();
        }
        else{
            player.start();
        }
        return START_STICKY;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        player.start();
    }

    @Override
    public void onDestroy() {
        player.release();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}