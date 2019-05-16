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

    private int countWagon;

    private int id;


    private List<Wagon> wagons = new ArrayList<>();

    private  void countCharacteristic()
    {
        countBaggage=0;
        countPassagers=0;
        countWagon=wagons.size();

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
        countCharacteristic();
    }

    public  Wagon getWagon(int index) throws NotCorrectData {
        if((index>-1)&&(index<=countWagon))
        {
            return wagons.get(index);
        }
        throw new NotCorrectData("not correct i");
    }

    public void deleteWagon(Wagon wagon)
    {
        wagons.remove(wagon);
        countCharacteristic();
    }

    public Wagon getHead() {
        return head;
    }

    public void setHead(Wagon head) {
        if (WagonValidator.isLocomative(head)) {
            this.head = head;
        }
    }

    public Wagon getTail() {
        return tail;
    }

    public void setTail(Wagon tail) {
        if (WagonValidator.isLocomative(tail)) {
            this.tail = tail;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
        countCharacteristic();
    }

    public int getCountPassagers() {
        return countPassagers;
    }

    public int getCountBaggage() {
        return countBaggage;
    }

    public int getCountWagon() {
        return countWagon;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return countPassagers == train.countPassagers &&
                countBaggage == train.countBaggage &&
                countWagon == train.countWagon &&
                Objects.equals(head, train.head) &&
                Objects.equals(tail, train.tail) &&
                Objects.equals(wagons, train.wagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, countPassagers, countBaggage, countWagon,wagons);
    }

    @Override
    public String toString() {
        return "Train{" +
                "head=" + head +
                ", tail=" + tail +
                ", countPassagers=" + countPassagers +
                ", countBaggage=" + countBaggage +
                ", size=" + countWagon +
                ", wagons=" + wagons +
                '}';
    }
}
