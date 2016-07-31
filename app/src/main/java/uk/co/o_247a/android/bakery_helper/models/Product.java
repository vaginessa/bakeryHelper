package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Product extends SugarRecord {
    //TODO: implement getters, setters, parcelables, constructors
    private String productCode;
    private String productName;
    private String productDescription;

    /**
     * on product for sale is price of sale
     * on product bought then price of purchase
     * on product made code of manufacture
     */
    private String price;

    private long stock;

}
