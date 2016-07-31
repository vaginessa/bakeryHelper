package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

import java.util.HashMap;

/**
 * Created by a247a01 on 21/04/16.
 */
public class StandingOrder extends SugarRecord {

    public Customer customer;
    public HashMap<Product, Long> productOrderList;
    public HashMap<ProductPack, Long> productPackOrderList;

    public String startDate;
    public String holdStartDate;
    public String holdEndDate;

    public boolean active;
}
