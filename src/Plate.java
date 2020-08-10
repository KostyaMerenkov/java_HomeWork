
public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int amount) {
        if (amount<=food) {
            food -= amount;
            return true;
        }
        else {
            System.out.println("В миске недостаточно еды");
            return false;
        }
    }

    public void addFood(int amount){
        if (amount>0) food+=amount;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
