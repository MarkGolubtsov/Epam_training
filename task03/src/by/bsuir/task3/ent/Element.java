package by.bsuir.task3.ent;

public class Element {
    private int value;
    private boolean canChange =  true ;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        canChange = false;
        this.value = value;
    }

    public boolean isCanChange() {
        return canChange;
    }

}
