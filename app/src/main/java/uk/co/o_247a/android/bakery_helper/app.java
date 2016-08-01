package uk.co.o_247a.android.bakery_helper;

/**
 * Created by wert2 on 01/08/2016.
 */

import android.app.Application;

import com.orm.SugarContext;

import uk.co.o_247a.android.bakery_helper.models.User;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SugarContext.init(this);

        //Insert Backdoor account which is only active when in debug
        if (User.count(User.class) == 0) {
            User user = new User();
            user.active = BuildConfig.BUILD_TYPE.equals("debug");
            user.password = "test";
            user.firstName = "back";
            user.surname = "door";
            user.userName = "backdoor";
            user.setPermissions(0xFFFFFFFF);//Giv all permissions
            user.save();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        SugarContext.terminate();
    }

}