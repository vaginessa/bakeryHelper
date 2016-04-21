package uk.co.o_247a.android.bakeryhelper.Models;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Discount {
    //TODO: implement getters, setters, parcelables, constructors
    private long mLocalId;

    private String mDiscountCode;

    private boolean mActive;
    private String mStartDate;
    private String mEndDate;

    private double mDiscountAmount;
    private int mDiscountType;

    private List<Product> mProductList;
}
