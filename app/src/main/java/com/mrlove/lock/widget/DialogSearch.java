package com.mrlove.lock.widget;

import android.animation.AnimatorSet;
import android.content.Context;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mrlove.lock.R;
import com.mrlove.lock.adapter.MainAdapter;
import com.mrlove.lock.bean.CommLockInfo;
import com.mrlove.lock.mvp.contract.LockMainContract;
import com.mrlove.lock.mvp.p.LockMainPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mrlove
 */

public class DialogSearch extends BaseDialog implements LockMainContract.View {

    private Context mContext;
    private EditText mEditSearch;
    private RecyclerView mRecyclerView;
    private ImageView mBtnBack;
    private MainAdapter mMainAdapter;
    private LockMainPresenter mLockMainPresenter;

    public DialogSearch(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getAttributes().gravity = Gravity.TOP;
    }

    @Override
    protected float setWidthScale() {
        return 1;
    }

    @Override
    protected AnimatorSet setEnterAnim() {
        return null;
    }

    @Override
    protected AnimatorSet setExitAnim() {
        return null;
    }

    @Override
    protected void init() {
        mLockMainPresenter = new LockMainPresenter(this, mContext);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mEditSearch = (EditText) findViewById(R.id.edit_search);
        mBtnBack = (ImageView) findViewById(R.id.btn_back);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mMainAdapter = new MainAdapter(mContext);
        mRecyclerView.setAdapter(mMainAdapter);

        mEditSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0) {
                    mMainAdapter.setLockInfos(new ArrayList<CommLockInfo>());
                } else {
                    mLockMainPresenter.searchAppInfo(editable.toString(), new LockMainPresenter.ISearchResultListener() {
                        @Override
                        public void onSearchResult(List<CommLockInfo> commLockInfos) {
                            mMainAdapter.setLockInfos(commLockInfos);
                        }
                    });
                }
            }
        });
        
        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.dialog_search;
    }


    @Override
    public void loadAppInfoSuccess(List<CommLockInfo> list) {

    }
}
