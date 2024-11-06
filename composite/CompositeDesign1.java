package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CompositeDesign1 {

    public static void main(String[] args) {
        new CompositeDesign1().test();
    }

    private void test() {
        // 创建一个根文件夹，并添加两个文本文件和一个子文件夹
        File root = new Folder("root");
        root.add(new TextFile("a.txt"));
        root.add(new TextFile("b.txt"));
        File subFolder = new Folder("subFolder");
        root.add(subFolder);

        // 在子文件夹中添加两个文本文件
        subFolder.add(new TextFile("c.txt"));
        subFolder.add(new TextFile("d.txt"));

        // 打印根文件夹的路径
        root.printPath(0);
    }

    public interface File {
        // 获取文件名称
        String getName();
        // 添加子文件
        void add(File file);
        // 删除子文件
        void remove(File file);
        // 获取子文件
        List<File> getChildren();
        // 打印文件路径
        void printPath(int space);
    }

    public class TextFile implements File {
        private String name;

        public TextFile(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void add(File file) {
            throw new UnsupportedOperationException("Text file cannot add child file");
        }

        @Override
        public void remove(File file) {
            throw new UnsupportedOperationException("Text file cannot remove child file");
        }

        @Override
        public List<File> getChildren() {
            throw new UnsupportedOperationException("Text file has no child file");
        }

        @Override
        public void printPath(int space) {
            StringBuilder sp = new StringBuilder();
            for (int i = 0; i < space; i++) {
                sp.append(" ");
            }
            System.out.println(sp + name);
        }
    }

    public class Folder implements File {
        private String name;
        private List<File> children;

        public Folder(String name) {
            this.name = name;
            children = new ArrayList<>();
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void add(File file) {
            children.add(file);
        }

        @Override
        public void remove(File file) {
            children.remove(file);
        }

        @Override
        public List<File> getChildren() {
            return children;
        }

        @Override
        public void printPath(int space) {
            StringBuilder sp = new StringBuilder();
            for (int i = 0; i < space; i++) {
                sp.append(" ");
            }
            System.out.println(sp + name);
            space += 2;
            for (File child : children) {
                child.printPath(space);
            }
        }
    }

}
