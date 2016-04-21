package uk.co.o_247a.android.bakeryhelper.Models;

/**
 * Created by a247a01 on 21/04/16.
 */
public class ProductPack {
    //TODO: implement getters, setters, parcelables, constructors
    private long mLocalId;

    private String mPackCode;
    private String mPackName;

    //Todo: check if product should be a product list if can be mixture of products.
    private Product mProduct;

    private String mPackSize;
    private float mPackCost;


    private boolean mActive;
}
