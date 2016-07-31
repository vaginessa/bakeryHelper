package uk.co.o_247a.android.bakery_helper.business_logic;

import android.os.AsyncTask;
import android.text.TextUtils;

import uk.co.o_247a.android.bakery_helper.models.LoginModel;

/**
 * Created by a247a01 on 21/04/16.
 */
public class Login {
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

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
            mCallback.success();
        } else {
            mCallback.fail();
        }
    }


    private static boolean isUserValid(String aUserName) {
        //TODO: Replace this with your own logic
        return !TextUtils.isEmpty(aUserName) && aUserName.contains("@");
    }

    private static boolean isPasswordValid(String aPassword) {
        //TODO: Replace this with your own logic
        return !TextUtils.isEmpty(aPassword) && aPassword.length() > 4;
    }

    public interface LoginCallbacks {
        void success();

        void accountLocked();

        void fail();

        void loginStarted();

        void loginStopped();

        void loginAlreadyRunning();
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final LoginModel mLogin;

        UserLoginTask(LoginModel aLogin) {
            mLogin = aLogin;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mLogin.Username.get())) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mLogin.Password.get());
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPreExecute() {
            mCallback.loginStarted();
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            mCallback.loginStopped();
            if (success) {
                mCallback.success();
            } else {
                mCallback.fail();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            mCallback.loginStopped();
        }
    }
}
