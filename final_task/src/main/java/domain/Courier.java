package domain;

import java.util.List;

public class Courier extends Person {

     private  List<Delivery> deliveryList;

     public List<Delivery> getDeliveryList() {
          return deliveryList;
     }

     public void setDeliveryList(List<Delivery> deliveryList) {
          this.deliveryList = deliveryList;
     }
}
