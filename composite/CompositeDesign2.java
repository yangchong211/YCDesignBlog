package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesign2 {

    public static void main(String[] args) {
        new CompositeDesign2().test();
    }

    private void test() {
        MusicFile m1 = new MusicFile("尽头.mp3");
        MusicFile m2 = new MusicFile("飘洋过海来看你.mp3");
        MusicFile m3 = new MusicFile("曾经的你.mp3");
        MusicFile m4 = new MusicFile("take me to your heart.mp3");

        VideoFile v1 = new VideoFile("战狼2.mp4");
        VideoFile v2 = new VideoFile("理想.avi");
        VideoFile v3 = new VideoFile("琅琊榜.avi");

        ImageFile i1 = new ImageFile("敦煌.png");
        ImageFile i2 = new ImageFile("baby.jpg");
        ImageFile i3 = new ImageFile("girl.jpg");

        Folder aa = new Folder("aa");
        aa.addImage(i3);
        Folder bb = new Folder("bb");
        bb.addMusic(m4);
        bb.addVideo(v3);
        Folder top = new Folder("top");
        top.addFolder(aa);
        top.addFolder(bb);
        top.addMusic(m1);
        top.addMusic(m2);
        top.addMusic(m3);
        top.addVideo(v1);
        top.addVideo(v2);
        top.addImage(i1);
        top.addImage(i2);
        top.print();
    }

    public class MusicFile {
        private String name;

        public MusicFile(String name){
            this.name = name;
        }

        public void print(){
            System.out.println(name);
        }
    }

    public class VideoFile {
        private String name;

        public VideoFile(String name){
            this.name = name;
        }

        public void print(){
            System.out.println(name);
        }
    }

    public class ImageFile {
        private String name;

        public ImageFile(String name){
            this.name = name;
        }

        public void print(){
            System.out.println(name);
        }
    }

    public class Folder {
        private String name;
        //音乐
        private List<MusicFile> musicList = new ArrayList<MusicFile>();
        //视频
        private List<VideoFile> videoList = new ArrayList<VideoFile>();
        //图片
        private List<ImageFile> imageList = new ArrayList<ImageFile>();
        //文件夹
        private List<Folder> folderList = new ArrayList<Folder>();

        public Folder(String name){
            this.name = name;
        }

        public void addFolder(Folder folder){
            folderList.add(folder);
        }

        public void addImage(ImageFile image){
            imageList.add(image);
        }

        public void addVideo(VideoFile video){
            videoList.add(video);
        }

        public void addMusic(MusicFile music){
            musicList.add(music);
        }

        public void print(){
            for (MusicFile music : musicList){
                music.print();
            }
            for (VideoFile video : videoList){
                video.print();
            }
            for(ImageFile image : imageList){
                image.print();
            }
            for (Folder folder : folderList){
                folder.print();
            }
        }
    }

}
