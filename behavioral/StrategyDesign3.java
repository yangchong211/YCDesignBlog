package behavioral;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 策略模式官方demo
 */
public class StrategyDesign3 {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Sorter sorter = new Sorter();
        sorter.sortFile("path");
    }

    public static class Sorter {
        private static final long GB = 1000 * 1000 * 1000;

        public void sortFile(String filePath) {
            // 省略校验逻辑
            File file = new File(filePath);
            long fileSize = file.length();
            if (fileSize < 6 * GB) { // [0, 6GB)
                quickSort(filePath);
            } else if (fileSize < 10 * GB) { // [6GB, 10GB)
                externalSort(filePath);
            } else if (fileSize < 100 * GB) { // [10GB, 100GB)
                concurrentExternalSort(filePath);
            } else { // [100GB, ~)
                mapreduceSort(filePath);
            }
        }

        private void quickSort(String filePath) {
            // 快速排序
        }

        private void externalSort(String filePath) {
            // 外部排序
        }

        private void concurrentExternalSort(String filePath) {
            // 多线程外部排序
        }

        private void mapreduceSort(String filePath) {
            // 利用MapReduce多机排序
        }
    }

    public class SorterDesign {
        private static final long GB = 1000 * 1000 * 1000;
        public void sortFile(String filePath) {
            // 省略校验逻辑
            File file = new File(filePath);
            long fileSize = file.length();
            ISortAlg sortAlg;
            if (fileSize < 6 * GB) { // [0, 6GB)
                sortAlg = new QuickSort();
            } else if (fileSize < 10 * GB) { // [6GB, 10GB)
                sortAlg = new ExternalSort();
            } else if (fileSize < 100 * GB) { // [10GB, 100GB)
                sortAlg = new ConcurrentExternalSort();
            } else { // [100GB, ~)
                sortAlg = new MapReduceSort();
            }
            sortAlg.sort(filePath);
        }
    }

    public interface ISortAlg {
        void sort(String filePath);
    }

    public static class QuickSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public static class ExternalSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public static class ConcurrentExternalSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public static class MapReduceSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }


    public static class SortAlgFactory {
        private static final Map<String, ISortAlg> algs = new HashMap<>();

        static {
            algs.put("QuickSort", new QuickSort());
            algs.put("ExternalSort", new ExternalSort());
            algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
            algs.put("MapReduceSort", new MapReduceSort());
        }

        public static ISortAlg getSortAlg(String type) {
            if (type == null || type.isEmpty()) {
                throw new IllegalArgumentException("type should not be empty.");
            }
            return algs.get(type);
        }
    }

    public class Sorter3 {
        private static final long GB = 1000 * 1000 * 1000;

        public void sortFile(String filePath) {
            // 省略校验逻辑
            File file = new File(filePath);
            long fileSize = file.length();
            ISortAlg sortAlg;
            if (fileSize < 6 * GB) { // [0, 6GB)
                sortAlg = SortAlgFactory.getSortAlg("QuickSort");
            } else if (fileSize < 10 * GB) { // [6GB, 10GB)
                sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
            } else if (fileSize < 100 * GB) { // [10GB, 100GB)
                sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
            } else { // [100GB, ~)
                sortAlg = SortAlgFactory.getSortAlg("MapReduceSort");
            }
            sortAlg.sort(filePath);
        }
    }

    public static class Sorter4 {
        private static final long GB = 1000 * 1000 * 1000;
        private static final List<AlgRange> algs = new ArrayList<>();
        static {
            algs.add(new AlgRange(0, 6*GB, SortAlgFactory.getSortAlg("QuickSort")));
            algs.add(new AlgRange(6*GB, 10*GB, SortAlgFactory.getSortAlg("ExternalSort")));
            algs.add(new AlgRange(10*GB, 100*GB, SortAlgFactory.getSortAlg("ConcurrentExternalSort")));
            algs.add(new AlgRange(100*GB, Long.MAX_VALUE, SortAlgFactory.getSortAlg("MapReduceSort")));
        }

        public void sortFile(String filePath) {
            // 省略校验逻辑
            File file = new File(filePath);
            long fileSize = file.length();
            ISortAlg sortAlg = null;
            for (AlgRange algRange : algs) {
                if (algRange.inRange(fileSize)) {
                    sortAlg = algRange.getAlg();
                    break;
                }
            }
            sortAlg.sort(filePath);
        }

        private static class AlgRange {
            private long start;
            private long end;
            private ISortAlg alg;

            public AlgRange(long start, long end, ISortAlg alg) {
                this.start = start;
                this.end = end;
                this.alg = alg;
            }

            public ISortAlg getAlg() {
                return alg;
            }

            public boolean inRange(long size) {
                return size >= start && size < end;
            }
        }
    }
}
