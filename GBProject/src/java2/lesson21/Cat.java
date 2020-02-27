package java2.lesson21;

public class Cat implements Actor{
    String name;
    public long maxRunLength;
    public long maxJumpHeight;

    public Cat(String name, long maxRunLength, long maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean run(long length) {
        boolean result = length >= 0 && length <= maxRunLength;
        System.out.println("Кот: " + name + ".run(" + length + ")-> результат:" + result);
        return result;
    }

    @Override
    public boolean jump(long height) {
        boolean result = height >= 0 && height <= maxJumpHeight;
        System.out.println("Кот: " + name + ".jump(" + height + ")-> результат:" + result);
        return result;
    }
}
