package java2.lesson22;

public class MyArrayDataException extends Exception{

    private long x;
    private long y;

    public MyArrayDataException(long x, long y) {
        super();
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "MyArrayDataException{Ошибка в данных в элементе: " +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
