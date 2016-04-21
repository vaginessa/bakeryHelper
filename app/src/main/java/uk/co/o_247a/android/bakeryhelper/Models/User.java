package uk.co.o_247a.android.bakeryhelper.Models;

/**
 * Created by a247a01 on 21/04/16.
 */
public class User {
    private long mLocalId;

    private String mUserName;

    private String mFirstName;
    private String mSurname;

    private String mPassword;//Do not store as plain text

    private long mPermissions;//Flag Based

    private boolean mActive;
}
