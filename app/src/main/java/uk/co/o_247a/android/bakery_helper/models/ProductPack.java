package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

/**
 * Created by a247a01 on 21/04/16.
 */
public class ProductPack extends SugarRecord {

    public String packCode;
    public String packName;

    //Todo: check if product should be a product list if can be mixture of products.
    public Product product;

    public String packSize;
    public float packCost;


    public boolean active;
}
