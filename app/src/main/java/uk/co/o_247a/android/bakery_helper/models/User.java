package uk.co.o_247a.android.bakery_helper.models;

import com.orm.SugarRecord;

/**
 * Created by a247a01 on 21/04/16.
 */
public class User extends SugarRecord {

    public String userName;
    public String password;//Do not store as plain text

    public String firstName;
    public String surname;

    public boolean active;
    private long mPermissions;//Flag Based

    public long getPermissions() {
        return mPermissions;
    }

    public void setPermissions(long aPermissions) {
        mPermissions = aPermissions;
    }
}
