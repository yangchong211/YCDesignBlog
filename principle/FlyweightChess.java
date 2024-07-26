package principle;

import java.util.HashMap;
import java.util.Map;

/**
 * 休闲棋类使用享元模式
 */
public class FlyweightChess {

    public static void main(String[] args) {
        test1();
        test2();
    }

    /*---------------------使用普通模式开发棋牌游戏--------------------------------------------*/
    private static void test1() {
        for (int i = 0; i < 10000; i++) {
            ChessBoard chessBoard = new ChessBoard();
            chessBoard.init();
            chessBoard.move(1, 1, 2);
        }
    }

    public static class ChessPiece {//棋子
        private int id;
        private String text;
        private Color color;
        private int positionX;
        private int positionY;

        public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
            this.id = id;
            this.text = text;
            this.color = color;
            this.positionX = positionX;
            this.positionY = positionX;
        }

        public static enum Color {
            RED, BLACK
        }

        // ...省略其他属性和getter/setter方法...
    }

    public static class ChessBoard {//棋局
        private final Map<Integer, ChessPiece> chessPieces = new HashMap<>();

        public ChessBoard() {
            init();
        }

        private void init() {
            chessPieces.put(1, new ChessPiece(1, "車", ChessPiece.Color.BLACK, 0, 0));
            chessPieces.put(2, new ChessPiece(2, "馬", ChessPiece.Color.BLACK, 0, 1));
            //...省略摆放其他棋子的代码...
        }

        public void move(int chessPieceId, int toPositionX, int toPositionY) {
            //...省略...
        }
    }
    /*---------------------使用享元模式开发棋牌游戏--------------------------------------------*/
    private static void test2() {
        for (int i = 0; i < 10000; i++) {
            ChessBoard2 chessBoard = new ChessBoard2();
            chessBoard.init();
            chessBoard.move(1, 1, 2);
        }
    }

    // 享元类
    public static class ChessPieceUnit {
        private int id;
        private String text;
        private Color color;

        public ChessPieceUnit(int id, String text, Color color) {
            this.id = id;
            this.text = text;
            this.color = color;
        }

        public static enum Color {
            RED, BLACK
        }

        // ...省略其他属性和getter方法...
    }

    public static class ChessPieceUnitFactory {
        private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

        static {
            pieces.put(1, new ChessPieceUnit(1, "車", ChessPieceUnit.Color.BLACK));
            pieces.put(2, new ChessPieceUnit(2,"馬", ChessPieceUnit.Color.BLACK));
            //...省略摆放其他棋子的代码...
        }

        public static ChessPieceUnit getChessPiece(int chessPieceId) {
            return pieces.get(chessPieceId);
        }
    }

    public static class ChessPiece2 {
        private ChessPieceUnit chessPieceUnit;
        private int positionX;
        private int positionY;

        public ChessPiece2(ChessPieceUnit unit, int positionX, int positionY) {
            this.chessPieceUnit = unit;
            this.positionX = positionX;
            this.positionY = positionY;
        }
        // 省略getter、setter方法
    }

    public static class ChessBoard2 {
        private Map<Integer, ChessPiece2> chessPieces = new HashMap<>();

        public ChessBoard2() {
            init();
        }

        private void init() {
            chessPieces.put(1, new ChessPiece2(
                    ChessPieceUnitFactory.getChessPiece(1), 0,0));
            chessPieces.put(1, new ChessPiece2(
                    ChessPieceUnitFactory.getChessPiece(2), 1,0));
            //...省略摆放其他棋子的代码...
        }

        public void move(int chessPieceId, int toPositionX, int toPositionY) {
            //...省略...
        }
    }

}
