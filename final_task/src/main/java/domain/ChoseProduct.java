package domain;

import java.util.List;

public class ChoseProduct  extends Entity {

   private Product product;

   private  int count;

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }
}
