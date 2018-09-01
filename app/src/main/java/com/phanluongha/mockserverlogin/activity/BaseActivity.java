package com.phanluongha.mockserverlogin.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.phanluongha.mockserverlogin.MockServerApplication;
import com.phanluongha.mockserverlogin.R;
import com.phanluongha.mockserverlogin.dialog.CustomProgressDialog;
import com.phanluongha.mockserverlogin.dragger.components.AppComponent;
import com.phanluongha.mockserverlogin.mvp.model.RetrofitData;
import com.phanluongha.mockserverlogin.mvp.views.BaseView;

import java.net.ConnectException;

import butterknife.ButterKnife;

/**
 * Created by phanluongha on 3/12/18.
 */

public abstract class BaseActivity extends AppCompatActivity  implements BaseView {

    protected CustomProgressDialog mProgressDialog;


    protected void injectDependencies(AppComponent appComponent) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        injectDependencies(MockServerApplication.getInstance().getApplicationComponent());
    }

    protected abstract int getLayoutId();


    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new CustomProgressDialog(this);
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);
        }
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * show toast
     */

    public void showToast(int string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    public void showToast(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    public void onApiThrowable(Throwable throwable) {
        throwable.printStackTrace();
        if (throwable.getCause() instanceof ConnectException) {
            showToast(R.string.network_error);
        } else {
            showToast(throwable.getLocalizedMessage());
        }
    }

    public void onApiError(RetrofitData result) {
        showToast(result.getError());
    }


    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    public void showError(String message) {
        showToast(message);
    }
}
