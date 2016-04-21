package uk.co.o_247a.android.bakeryhelper.Models;

import java.util.HashMap;

/**
 * Created by a247a01 on 21/04/16.
 */
public class StandingOrder {
    //TODO: implement getters, setters, parcelables, constructors
    private long mLocalId;
    private Customer mCustomer;
    private HashMap<Product,Long> mProductOrderList;
    private HashMap<ProductPack,Long> mProductPackOrderList;

    private String mStartDate;
    private String mHoldStartDate;
    private String mHoldEndDate;

    private boolean mActive;
}
