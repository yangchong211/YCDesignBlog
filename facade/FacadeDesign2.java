package facade;

public class FacadeDesign2 {

    public static void main(String[] args) {
        new FacadeDesign2().test();
    }

    private void test() {
        Computer computer = new Computer();
        System.out.println("播放视频步骤：");
        // 播放视频
        computer.openVideo();
        System.out.println("关闭视频步骤：");
        // 关闭视频
        computer.stopVideo();
    }

    public interface Facade {
        void open();
        void stop();
    }

    public class Music implements Facade{

        @Override
        public void open() {
            System.out.println("加载音乐");
        }
        @Override
        public void stop() {
            System.out.println("关闭音乐");
        }
    }

    public class Video implements Facade{

        @Override
        public void open() {
            System.out.println("打开视频");
        }

        @Override
        public void stop() {
            System.out.println("关闭视频");
        }
    }

    public class Internet implements Facade{

        @Override
        public void open() {
            System.out.println("连接网络");
        }

        @Override
        public void stop() {
            System.out.println("断开网络");
        }
    }

    public class Computer {
        private Music music;
        private Video video;
        private Internet internet;

        public Computer() {
            this.music = new Music();
            this.video = new Video();
            this.internet = new Internet();
        }

        public void openVideo() {
            internet.open();
            music.open();
            video.open();
        }

        public void stopVideo() {
            video.stop();
            music.stop();
            internet.stop();
        }
    }
}
