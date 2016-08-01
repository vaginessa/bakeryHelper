package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.HashMap;

/**
 * Created by a247a01 on 21/04/16.
 */
public class StandingOrder extends SugarRecord {

    public Customer customer;
    @Ignore
    public HashMap<Product, Long> productOrderList;
    @Ignore
    public HashMap<ProductPack, Long> productPackOrderList;

    public String startDate;
    public String holdStartDate;
    public String holdEndDate;

    public boolean active;
}
