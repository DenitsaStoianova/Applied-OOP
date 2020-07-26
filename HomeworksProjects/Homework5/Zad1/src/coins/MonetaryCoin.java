package coins;

public class MonetaryCoin extends Coin {

    private int value;

    public MonetaryCoin(Face face, int value){
        super(face);
        setValue(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value < 1){
            this.value = 1;
        }
        else {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        return String.format("%s, Value: %d", super.toString(), this.value);
    }
}
