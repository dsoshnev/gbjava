package lesson7;

public class Cat {

    private String nickname;
    private int eatingCapacity;
    private boolean hungry;
    private int energy;

    public Cat(String nickname, int eatingCapacity) {
        this.nickname = nickname;
        setEatingCapacity(eatingCapacity);
        setEnergy(0);
    }

    public void setEatingCapacity(int eatingCapacity) {
        this.eatingCapacity = eatingCapacity <= 0 ? 0 : eatingCapacity;
    }

    public void setEnergy(int energy) {
        if (energy <= 0) {
            this.energy = 0;
            setHungry(true);
        } else {
            this.energy = energy;
            setHungry(energy < eatingCapacity);
        }
    }

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void eat(Plate p) {
        if(p.getFood()>=eatingCapacity) {
            p.decreaseFood(eatingCapacity);
            setEnergy(energy + eatingCapacity);
            System.out.println(getNickname());
        }
    }
    public void run() {
        setEnergy(energy - eatingCapacity/2);

    }

    @Override
    public String toString() {
        return "Cat{" +
                "nickname='" + nickname + '\'' +
                ", eatingCapacity=" + eatingCapacity +
                ", hungry=" + isHungry() +
                ", energy=" + energy +
                '}';
    }
}
