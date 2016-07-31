package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Address extends SugarRecord {
    //TODO: implement getters, setters, parcelables, constructors
    public String addressLine1;
    public String addressLine2;
    public String county;
    public String country;
    public String postCode;

    public Address() {
    }
}
