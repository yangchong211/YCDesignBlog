package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDesign3 {

    public static void main(String[] args) {
        new CompositeDesign3().test();
    }

    private void test() {
        AbstractFile m1 = new MusicFile("尽头.mp3");
        AbstractFile m2 = new MusicFile("飘洋过海来看你.mp3");
        AbstractFile m3 = new MusicFile("曾经的你.mp3");
        AbstractFile m4 = new MusicFile("take me to your heart.mp3");

        AbstractFile v1 = new VideoFile("战狼2.mp4");
        AbstractFile v2 = new VideoFile("理想.avi");
        AbstractFile v3 = new VideoFile("琅琊榜.avi");

        AbstractFile i1 = new ImageFile("敦煌.png");
        AbstractFile i2 = new ImageFile("baby.jpg");
        AbstractFile i3 = new ImageFile("girl.jpg");

        AbstractFile aa = new Folder("aa");
        aa.add(i3);

        AbstractFile bb = new Folder("bb");
        bb.add(m4);
        bb.add(v3);

        AbstractFile top = new Folder("top");
        top.add(aa);
        top.add(bb);
        top.add(m1);
        top.add(m2);
        top.add(m3);
        top.add(v1);
        top.add(v2);
        top.add(i1);
        top.add(i2);

        top.print();
    }

    public abstract class AbstractFile {
        public void add(AbstractFile file) {
            throw new UnsupportedOperationException();
        }

        public void remove(AbstractFile file) {
            throw new UnsupportedOperationException();
        }

        public AbstractFile getChild(int i) {
            throw new UnsupportedOperationException();
        }

        public void print() {
            throw new UnsupportedOperationException();
        }
    }

    public class MusicFile extends AbstractFile {
        private String name;

        public MusicFile(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(name);
        }
    }

    public class VideoFile extends AbstractFile {
        private String name;

        public VideoFile(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(name);
        }
    }

    public class ImageFile extends AbstractFile {
        private String name;

        public ImageFile(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(name);
        }
    }

    public class Folder extends AbstractFile {
        private String name;
        private List<AbstractFile> files = new ArrayList<AbstractFile>();

        public Folder(String name) {
            this.name = name;
        }

        @Override
        public void add(AbstractFile file) {
            files.add(file);
        }

        @Override
        public void remove(AbstractFile file) {
            files.remove(file);
        }

        @Override
        public AbstractFile getChild(int i) {
            return files.get(i);
        }

        @Override
        public void print() {
            for (AbstractFile file : files) {
                file.print();
            }
        }
    }
}
