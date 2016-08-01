package uk.co.o_247a.android.bakery_helper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import uk.co.o_247a.android.bakery_helper.Interfaces.LoginFragmentCallbacks;
import uk.co.o_247a.android.bakery_helper.R;

public class LoginActivity extends AppCompatActivity implements LoginFragmentCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void success() {
        startActivity(new Intent(this, MainActivity.class));
    }
}
