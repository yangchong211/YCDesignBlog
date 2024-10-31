package adapter;

/**
 * 读卡器适配案例
 */
public class AdapterTest3 {


    public static void main(String[] args) {
        //new AdapterTest3().test1();
        new AdapterTest3().test2();
    }

    private  void test2() {
        //计算器适配，读卡器，去读TF卡中的内容
        Computer computer = new Computer();
        //创建适配器对象，完全没有影响之前计算机读SD卡的逻辑
        SDAdapterTF sdAdapterTF = new SDAdapterTF();
        computer.readSD(sdAdapterTF);
    }


    private  void test1() {
        //计算机读SD卡
        Computer computer = new Computer();
        SDCardImpl sdCard = new SDCardImpl();
        computer.readSD(sdCard);
    }

    public interface SDCard {
        //从SD卡中读取数据
        String readSD();

        //往SD卡中写数据
        void writeSD(String msg);
    }

    //具体的SD卡
    public  class SDCardImpl implements SDCard {
        @Override
        public String readSD() {
            String msg = "SDCard read msg : SD";
            System.out.println(msg);
            return msg;
        }

        @Override
        public void writeSD(String msg) {
            System.out.println("SDCard write msg : " + msg);
        }
    }

    //计算机类
    public  class Computer {

        //从SD卡中读取数据
        public String readSD(SDCard sdCard) {
            if (sdCard == null) {
                throw new NullPointerException("sd card is null");
            }
            return sdCard.readSD();
        }
    }

    //适配者类的接口
    public interface TFCard {

        //从TF卡中读取数据
        String readTF();

        //往TF卡中写数据
        void writeTF(String msg);

    }

    //适配者类
    public  class TFCardImpl implements TFCard {

        @Override
        public String readTF() {
            String msg = "TFCard read msg : TF";
            System.out.println(msg);
            return msg;
        }

        @Override
        public void writeTF(String msg) {
            System.out.println("TFCard write msg : " + msg);
        }
    }

    //适配器类
    public  class SDAdapterTF extends TFCardImpl implements SDCard {

        @Override
        public String readSD() {
            System.out.println("adapter read tf card");
            return readTF();
        }

        @Override
        public void writeSD(String msg) {
            System.out.println("adapter wrete tf card");
            writeTF(msg);
        }
    }


}
