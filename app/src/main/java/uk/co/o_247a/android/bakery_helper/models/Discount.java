package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Discount extends SugarRecord {
    //TODO: implement getters, setters, parcelables, constructors

    public String discountCode;

    public boolean active;
    public String startDate;
    public String endDate;

    public double discountAmount;
    public int discountType;

    public List<Product> productList;
}
