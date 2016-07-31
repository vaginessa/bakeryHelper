package uk.co.o_247a.android.bakery_helper.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.o_247a.android.bakery_helper.R;
import uk.co.o_247a.android.bakery_helper.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void success() {
        finish();
    }

    @Override
    public void createUser() {
        //do nothing for now
    }
}
