package uk.co.o_247a.android.bakeryhelper.Models;

import java.util.List;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Customer {
    private long mLocalId;

    private String mFirstName;
    private String mSurname;

    private String mCustCode;

    private Address mDeliveryAddress;
    private Address mInvoiceAddress;


    private List<Discount> mIndividualDiscounts;
}
