package deserializer_json;

import domain.TypeDelivery;
import domain.TypePay;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDataDeserializer {
    int  readUserId();
    List<Integer> readIdChoseProducts();
    TypePay readTypePay();
    TypeDelivery readDeliveryType();
    BigDecimal readTotalCost();
}
