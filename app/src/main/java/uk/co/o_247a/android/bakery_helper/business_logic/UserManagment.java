package uk.co.o_247a.android.bakery_helper.business_logic;


import uk.co.o_247a.android.bakery_helper.models.User;

/**
 * Created by a247a01 on 21/04/16.
 */
public class UserManagment {
    public static final byte FULL_AUTH = 2;
    public static final byte PART_AUTH = 1;
    public static final byte NO_AUTH = 0;

    /**
     * Check if the user is Authorized to access the requested area
     *
     * @param aUser     User to verify
     * @param aAuthMask mask to check perms
     * @return indicator of authorization
     */
    public static byte isAuthorised(User aUser, long aAuthMask) {
        if ((aUser.getPermissions() & aAuthMask) == aAuthMask) {
            return FULL_AUTH;
        } else if ((aUser.getPermissions() & aAuthMask) > 0) {
            return PART_AUTH;
        } else {
            return NO_AUTH;
        }
    }

    /**
     * Changes a users password
     *
     * @param aUser        the user to change the password of
     * @param aNewPassword the new password to use
     * @return if the password change succeeded
     */
    public boolean changePassword(User aUser, String aNewPassword) {
        //TODO: implement
        return false;
    }

    /**
     * Changes a users password
     *
     * @param aUser        the user to change the password of
     * @param aNewPassword the new password to use
     * @return if the password change succeeded
     */
    public boolean changeName(User aUser, String aNewPassword) {
        //TODO: implement
        return false;
    }

    /**
     * Changes a users username
     *
     * @param aUser        the user to change the username of
     * @param aNewUserName the new password to use
     * @return if the password change succeeded
     */
    public boolean changeUserName(User aUser, String aNewUserName) {
        //TODO: implement
        return false;
    }

    /**
     * set weather a user is active and possible to login
     *
     * @param aUser   user alter
     * @param aActive weather to lock the user out
     * @return true if successful
     */
    public boolean setActive(User aUser, String aActive) {
        //TODO: implement
        return false;
    }

    /**
     * sets the user permissions to those passed
     *
     * @param aUser           user to alter
     * @param aPermissionMask permissions to set
     * @return if permission set was successful
     */
    public boolean setPermissions(User aUser, long aPermissionMask) {
        //TODO: implement
        aUser.setPermissions(aPermissionMask);
        return false;
    }

    /**
     * adds the passed permissions to the user
     *
     * @param aUser           user to alter
     * @param aPermissionMask permissions to add
     * @return if permission add was successful
     */
    public boolean addPermissions(User aUser, long aPermissionMask) {
        //TODO: implement
        aUser.setPermissions(aUser.getPermissions() | aPermissionMask);
        return false;
    }

    /**
     * removes the passed permissions from the user
     *
     * @param aUser           user to alter
     * @param aPermissionMask permissions to remove
     * @return if permission removal was successful
     */
    public boolean removePermissions(User aUser, long aPermissionMask) {
        //TODO: implement
        aUser.setPermissions(aUser.getPermissions() & ~aPermissionMask);
        return false;
    }

    /**
     * Creates a new user and saves to the db
     *
     * @param aActive      if the new user is to be set as active
     * @param aUserName    the username of the new user
     * @param aFirstName   first name of the new user
     * @param aSurname     last name of the new user
     * @param aPassword    password of the new user
     * @param aPermissions permissions of the new user
     * @return an instance of the new user
     */
    public User newUser(boolean aActive, String aUserName, String aFirstName, String aSurname, String aPassword, long aPermissions) {
        //TODO: implement
        return new User();
    }
}
