package uk.co.o_247a.android.bakery_helper.Interfaces;

/**
 * Created by wert2 on 01/08/2016.
 */
public interface LoginCallbacks {
    void success();

    void accountLocked();

    void fail();

    void loginStarted();

    void loginStopped();

    void loginAlreadyRunning();
}