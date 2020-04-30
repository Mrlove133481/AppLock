package com.mrlove.lock.base;

import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.mrlove.lock.LockApplication;
import com.mrlove.lock.R;
import com.mrlove.lock.utils.SystemBarHelper;

/**
 * Created by xian on 2017/2/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView mCustomTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LockApplication.getInstance().doForCreate(this);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        initData();
        initAction();
    }

    public abstract int getLayoutId();

    protected abstract void initViews(Bundle savedInstanceState);

    protected void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setTitle("");
            SystemBarHelper.immersiveStatusBar(this);
            SystemBarHelper.setHeightAndPadding(this, mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            resetToolbar();
            getSupportActionBar().setDisplayShowCustomEnabled(true);
            getSupportActionBar().setElevation(0);
        }
    }

    public void resetToolbar() {
        if (mCustomTitleTextView == null) {
            mCustomTitleTextView = (TextView) getLayoutInflater().inflate(R.layout.layout_toolbar_title, null);
        }
        getSupportActionBar().setCustomView(mCustomTitleTextView, new ActionBar.LayoutParams(Gravity.CENTER));
        if (getTitle() != null) {
            mCustomTitleTextView = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbar_title);
            mCustomTitleTextView.setText(getTitle());
        }
    }

    public void hiddenActionBar() {
        getSupportActionBar().hide();
    }

    protected abstract void initData();

    protected abstract void initAction();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LockApplication.getInstance().doForFinish(this);
    }

    public final void clear() {
        super.finish();
    }
}
