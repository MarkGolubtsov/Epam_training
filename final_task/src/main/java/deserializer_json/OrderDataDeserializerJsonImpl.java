package deserializer_json;

import com.google.gson.*;
import domain.Delivery;
import domain.TypeDelivery;
import domain.TypePay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDataDeserializerJsonImpl implements OrderDataDeserializer {

    private String json;
    private JsonParser parser = new JsonParser();
    private JsonElement rootNode ;
    private JsonObject details;

    public OrderDataDeserializerJsonImpl(String json) {
        this.json=json;
        rootNode = parser.parse(json);
        details = rootNode.getAsJsonObject();
    }

    public int  readUserId(){
        return  details.get("user_id").getAsInt();
    }

    public List<Integer> readIdChoseProducts() {
        ArrayList<Integer> result =new ArrayList<>();
        JsonArray list=details.get("chose_product").getAsJsonArray();
        for (JsonElement element:
                list) {
            result.add(element.getAsInt());
        }
        return result;
    }

    public TypePay readTypePay() {
        return TypePay.valueOf(details.get("type_pay").getAsString());
    }

    public TypeDelivery readDeliveryType() {
        return TypeDelivery.valueOf(details.get("delivery_type").getAsString());
    }
    public BigDecimal readTotalCost() {
        return details.get("final_cost").getAsBigDecimal();
    }

}
