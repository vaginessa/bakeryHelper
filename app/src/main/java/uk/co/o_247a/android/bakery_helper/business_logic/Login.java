package uk.co.o_247a.android.bakery_helper.business_logic;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.orm.query.Condition;
import com.orm.query.Select;

import uk.co.o_247a.android.bakery_helper.Interfaces.LoginCallbacks;
import uk.co.o_247a.android.bakery_helper.models.LoginModel;
import uk.co.o_247a.android.bakery_helper.models.User;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Login {
    private static UserLoginTask mAuthTask = null;
    private static LoginCallbacks mCallback = null;

    /**
     * Attempts to log the user into the system
     *
     * @param aCallback callbacks to caller
     * @param aLogin    login details
     */
    public static void attemptLogin(LoginCallbacks aCallback, LoginModel aLogin) {
        mCallback = aCallback;
        if (mAuthTask != null) {
            mCallback.loginAlreadyRunning();
        }

        if (isUserValid(aLogin.Username.get()) && isPasswordValid(aLogin.Password.get())) {
            new UserLoginTask(aLogin.Username.get(), aLogin.Password.get()).execute();
        } else {
            mCallback.fail();
        }
    }


    private static boolean isUserValid(String aUserName) {
        return !TextUtils.isEmpty(aUserName);// && aUserName.contains("@");
    }

    private static boolean isPasswordValid(String aPassword) {
        return !TextUtils.isEmpty(aPassword) && aPassword.length() > 2;
    }


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public static class UserLoginTask extends AsyncTask<Void, Void, User> {
        private final String mUsername;
        private final String mPassword;


        UserLoginTask(String aUsername, String aPassword) {
            mUsername = aUsername;
            mPassword = aPassword;
        }

        @Override
        protected User doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return null;
            }

            /**
             * Search for users with the same username and password
             * if there is one then login is successful
             * (Local lookup for when no network access)
             */

            return Select.from(User.class).
                    where(Condition.prop("user_name").eq(mUsername)).
                    and(Condition.prop("password").eq(mPassword)).
                    limit("1").first();
        }

        @Override
        protected void onPreExecute() {
            mCallback.loginStarted();
        }

        @Override
        protected void onPostExecute(final User aUser) {
            mAuthTask = null;
            mCallback.loginStopped();
            if (aUser == null) {
                mCallback.fail();
            } else if (aUser.active) {
                mCallback.success();
            } else {
                mCallback.accountLocked();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            mCallback.loginStopped();
        }
    }


}
