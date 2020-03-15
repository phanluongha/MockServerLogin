package com.phanluongha.mockserverlogin.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.phanluongha.mockserverlogin.R;
import com.phanluongha.mockserverlogin.dragger.components.AppComponent;
import com.phanluongha.mockserverlogin.dragger.modules.LoginModule;
import com.phanluongha.mockserverlogin.mvp.presenters.LoginPresenter;
import com.phanluongha.mockserverlogin.mvp.views.LoginView;
import com.phanluongha.mockserverlogin.utils.CommonUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.email)
    AppCompatAutoCompleteTextView mEmail;

    @BindView(R.id.password)
    AppCompatEditText mPassword;

    @Inject
    protected LoginPresenter loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void injectDependencies(AppComponent appComponent) {
        appComponent.plus(new LoginModule(this)).inject(this);
    }

    @OnClick(R.id.email_sign_in_button)
    public void onButtonSignClick() {
        String email = mEmail.getText().toString();
        String password = mPassword.getText().toString();
		
		//branch 2 commit 1
		
		// branch 2 commit 2
		
		// branch 2 commit @@@
		
		// branch 1 commit @@@@@

		// branch 2 commit xyz
		
		// branch 1 commit abc
		
		//branch 2 commot o

        // Check for a valid email address. dfdf
        if (TextUtils.isEmpty(email)) {
            mEmail.setError(getString(R.string.error_field_required));
            mEmail.requestFocus();
            return;
        } else if (!CommonUtils.isValidEmail(email)) {
            mEmail.setError(getString(R.string.error_invalid_email));
            mEmail.requestFocus();
            return;
        }

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password)) {
            mPassword.setError(getString(R.string.error_invalid_password));
            mPassword.requestFocus();
            return;
        }
        login(email, password);
    }

    /**
     * function login by email and password
     *
     * @param email
     * @param password
     */
    private void login(String email, String password) {
        loginPresenter.login(email, password);
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onDestroy() {
        loginPresenter.cancel();
        super.onDestroy();
    }
}

