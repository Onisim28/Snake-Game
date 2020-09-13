package Snake;

public class Fruit {
    private int fruitX = (int) (Math.random() * 520);
    private int fruitY = (int) (Math.random() * 520);

    public int display_aFruitX() {
        fruitX = (int) (Math.random() * 520);
        return fruitX;
    }

    public int display_aFruitY() {
        fruitY = (int) (Math.random() * 520);
        return fruitY;
    }

    public int getFruitX() {
        return fruitX;
    }

    public int getFruitY() {
        return fruitY;
    }
}
