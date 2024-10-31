package adapter;

/**
 * MediaPlayer适配器
 */
public class AdapterTest4 {


    public static void main(String[] args) {
//        new AdapterTest4().test1();
//        new AdapterTest4().test2();
        new AdapterTest4().test3();
    }

    private void test1() {
        MediaPlayer mp3Player = new Mp3Player();
        mp3Player.play("mp3", "file.mp3");
    }

    // MediaPlayer.java
    public interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Mp3Player.java
    public class Mp3Player implements MediaPlayer {
        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file. Name: " + fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }

    private void test2() {
        AdvancedMediaPlayer vlcPlayer = new VlcPlayer();
        vlcPlayer.playVlc("vlc");
        AdvancedMediaPlayer mp4Player = new Mp4Player();
        mp4Player.playMp4("mp4");
    }

    // AdvancedMediaPlayer.java
    public interface AdvancedMediaPlayer {
        void playVlc(String fileName);

        void playMp4(String fileName);
    }

    // VlcPlayer.java
    public class VlcPlayer implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {
            System.out.println("Playing vlc file. Name: " + fileName);
        }

        @Override
        public void playMp4(String fileName) {
            // Do nothing
        }
    }

    // Mp4Player.java
    public class Mp4Player implements AdvancedMediaPlayer {
        @Override
        public void playVlc(String fileName) {
            // Do nothing
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("Playing mp4 file. Name: " + fileName);
        }
    }


    private void test3() {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "mySong.mp3");
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.play("avi", "documentary.avi");  // Not supported
    }

    // MediaAdapter.java
    public class MediaAdapter implements MediaPlayer {

        AdvancedMediaPlayer advancedMusicPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMusicPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMusicPlayer.playMp4(fileName);
            }
        }
    }

    // AudioPlayer.java
    public class AudioPlayer implements MediaPlayer {
        MediaAdapter mediaAdapter;

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file. Name: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }


}
