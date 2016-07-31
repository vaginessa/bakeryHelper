package uk.co.o_247a.android.bakery_helper.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.o_247a.android.bakery_helper.R;
import uk.co.o_247a.android.bakery_helper.business_logic.Login;
import uk.co.o_247a.android.bakery_helper.databinding.FragmentLoginBinding;
import uk.co.o_247a.android.bakery_helper.models.LoginModel;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.LoginFragmentCallbacks} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements Login.LoginCallbacks {

    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private FragmentLoginBinding mBinding;
    private LoginFragmentCallbacks mCallbacks;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoginFragmentCallbacks) {
            mCallbacks = (LoginFragmentCallbacks) context;

        } else {
            throw new RuntimeException(context.toString()
                    + " must implement LoginFragmentCallbacks");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        mBinding.setLogin(new LoginModel());
        mBinding.password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        mBinding.signIn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        attemptLogin();
                    }
                });
        // Inflate the layout for this fragment
        return mBinding.getRoot();
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        // Reset errors.
        mBinding.email.setError(null);
        mBinding.password.setError(null);

        Login.attemptLogin(this, mBinding.getLogin());
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mBinding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
            mBinding.loginForm.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mBinding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mBinding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            mBinding.loginProgress.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mBinding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mBinding.loginProgress.setVisibility(show ? View.VISIBLE : View.GONE);
            mBinding.loginForm.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public void success() {
        Context context = mCallbacks.getApplicationContext();
        CharSequence text = "Login attempt success";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        mCallbacks.success();
    }

    @Override
    public void accountLocked() {
        mBinding.email.setError(getString(R.string.error_account_locked));
        mBinding.email.requestFocus();
    }

    @Override
    public void fail() {
        mBinding.email.setError(getString(R.string.error_invalid_login));
        mBinding.email.requestFocus();
    }

    @Override
    public void loginStarted() {
        showProgress(true);
    }

    @Override
    public void loginStopped() {
        showProgress(false);
    }

    @Override
    public void loginAlreadyRunning() {
        Context context = mCallbacks.getApplicationContext();
        CharSequence text = "Login attempt already running, ignoring new request";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    public interface LoginFragmentCallbacks {
        Context getApplicationContext();

        void success();

        void createUser();
    }
}
