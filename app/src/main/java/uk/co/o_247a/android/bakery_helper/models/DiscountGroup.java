package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class DiscountGroup extends SugarRecord {
    public String name;
    public boolean active;

    public List<Customer> customerList() {
        return Customer.find(Customer.class, "discount_group = ?", getId().toString());
    }

    public List<Discount> discountList() {
        return Discount.find(Discount.class, "discount_group = ?", getId().toString());
    }
}
