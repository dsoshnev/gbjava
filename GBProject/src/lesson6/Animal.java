package lesson6;

public class Animal {

    private String nickName;

    private double maxRunLength;
    private double maxSwimLength;
    private double maxJumpHeight;

    @Override
    public String toString() {
        return nickName + "{бегает=" + maxRunLength +
                ", плавает=" + maxSwimLength +
                ", прыгает=" + maxJumpHeight +
                '}';
    }

    public Animal(String nickName, double maxRunLength, double maxSwimLength, double maxJumpHeight) {
        this.nickName = nickName;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
        this.maxJumpHeight = maxJumpHeight;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getMaxRunLength() {
        return maxRunLength;
    }

    public void setMaxRunLength(double maxRunLength) {
        this.maxRunLength = maxRunLength;
    }

    public double getMaxSwimLength() {
        return maxSwimLength;
    }

    public void setMaxSwimLength(double maxSwimLength) {
        this.maxSwimLength = maxSwimLength;
    }

    public double getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(double maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }

    //4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
    // (Например, dog1.run(150); -> результат: run: true)
    public boolean run (double length) {
        boolean result = length >= 0 && length <= maxRunLength;
        System.out.println(nickName + ".run(" + length + ")-> результат:" + result);
        return result;
    }

    public boolean swim (double length) {
        boolean result = length >= 0 && length <= maxSwimLength;
        System.out.println(nickName + ".swim(" + length + ")-> результат:" + result);
        return result;
    }

    public boolean jump (double height) {
        boolean result = height >= 0 && height <= maxJumpHeight;
        System.out.println(nickName + ".jump(" + height + ")-> результат:" + result);
        return result;
    }

}
