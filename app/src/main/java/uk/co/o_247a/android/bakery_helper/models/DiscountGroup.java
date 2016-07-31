package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class DiscountGroup extends SugarRecord {
    public String name;

    public List<Customer> customerList;
    public List<Discount> discountList;

    public boolean active;
}
