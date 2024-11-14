package strategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class StrategyDesign4 {

    public static void main(String[] args) {

    }

    public class SortAlgFactory {
        private final Map<String, ISortAlg> algs = new HashMap<>();

        public SortAlgFactory() {
            algs.put("QuickSort", new QuickSort());
            algs.put("ExternalSort", new ExternalSort());
            algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
            algs.put("MapReduceSort", new MapReduceSort());
        }

        public ISortAlg getSortAlg(String type) {
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
            SortAlgFactory sortAlgFactory = new SortAlgFactory();
            ISortAlg sortAlg;
            if (fileSize < 6 * GB) { // [0, 6GB)
                sortAlg = sortAlgFactory.getSortAlg("QuickSort");
            } else if (fileSize < 10 * GB) { // [6GB, 10GB)
                sortAlg = sortAlgFactory.getSortAlg("ExternalSort");
            } else if (fileSize < 100 * GB) { // [10GB, 100GB)
                sortAlg = sortAlgFactory.getSortAlg("ConcurrentExternalSort");
            } else { // [100GB, ~)
                sortAlg = sortAlgFactory.getSortAlg("MapReduceSort");
            }
            sortAlg.sort(filePath);
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

    public class QuickSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public class ExternalSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public class ConcurrentExternalSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
    }

    public class MapReduceSort implements ISortAlg {
        @Override
        public void sort(String filePath) {
            //...
        }
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

}
