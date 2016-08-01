package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Customer extends SugarRecord {
    public String firstName;
    public String surname;
    public String custCode;
    public Address deliveryAddress;
    public Address invoiceAddress;

    public DiscountGroup discountGroup;

    public List<Discount> individualDiscounts() {
        return Discount.find(Discount.class, "customer = ?", getId().toString());
    }
}
