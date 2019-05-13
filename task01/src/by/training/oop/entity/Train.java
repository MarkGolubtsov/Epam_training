package by.training.oop.entity;

import by.training.oop.exception.NotCorrectData;
import by.training.oop.validator.WagonValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {

    private Wagon head;

    private Wagon tail;

    private int countPassagers;

    private int countBaggage;

    private int size;
    private List<Wagon> wagons = new ArrayList<>();

    private  void countCharacteristic()
    {
        countBaggage=0;
        countPassagers=0;
        size=wagons.size();

        for (Wagon wagon : wagons) {
            int localCountBaggage = ((PassengerWagon)wagon).getCountItems();
            countBaggage=countBaggage+localCountBaggage ;

            int localCountPeople = ((PassengerWagon)wagon).getCountPassengers();
            countPassagers=countPassagers+ localCountPeople;
        }
    }

    public void addWagon(Wagon wagon)
    {
        if ( !WagonValidator.isLocomative(wagon) ) {
            wagons.add(wagon);
        }
    }

    public  Wagon getWagon(int index) throws NotCorrectData {
        if((index>-1)&&(index<=size))
        {
            return wagons.get(index);
        }
        throw new NotCorrectData("not correct i");
    }

    public void deleteWagon(Wagon wagon)
    {
        wagons.remove(wagon);
    }

    public Wagon getHead() {
        return head;
    }

    public void setHead(Wagon head) {
        this.head = head;
    }

    public Wagon getTail() {
        return tail;
    }

    public void setTail(Wagon tail) {
        this.tail = tail;
    }


    public void setWagons(List<Wagon> wagons) {
        countCharacteristic();
        this.wagons = wagons;
    }

    public int getCountPassagers() {
        return countPassagers;
    }

    public void setCountPassagers(int countPassagers) {
        this.countPassagers = countPassagers;
    }

    public int getCountBaggage() {
        return countBaggage;
    }

    public void setCountBaggage(int countBaggage) {
        this.countBaggage = countBaggage;
    }

    public int getSize() {
        return size;
    }




    //TODO GOOD!!!!!!!!!!!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return countPassagers == train.countPassagers &&
                countBaggage == train.countBaggage &&
                size == train.size &&
                Objects.equals(head, train.head) &&
                Objects.equals(tail, train.tail) &&
                Objects.equals(wagons, train.wagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, countPassagers, countBaggage, size, wagons);
    }
}
