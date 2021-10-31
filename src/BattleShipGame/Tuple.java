package BattleShipGame;

public class Tuple<T, K> {
    private T x;
    private K y;

    public Tuple(T t, K k) {
        this.x = t;
        this.y = k;
    }

    public K getY() {
        return y;
    }

    public T getX() {
        return x;
    }
}
