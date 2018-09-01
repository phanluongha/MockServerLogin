package com.phanluongha.mockserverlogin.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.phanluongha.mockserverlogin.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CustomProgressDialog extends Dialog {

    @BindView(R.id.loadingBar)
    ProgressBar mProgressBar;

    public CustomProgressDialog(Context mContext) {
    	
        super(mContext, R.style.DiaLogStyle);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom_progress);
		ButterKnife.bind(this);
        setCancelable(false);
    }

}