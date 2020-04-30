package com.mrlove.lock.mvp.contract;

import android.content.Context;

import com.mrlove.lock.base.BasePresenter;
import com.mrlove.lock.base.BaseView;
import com.mrlove.lock.bean.CommLockInfo;
import com.mrlove.lock.mvp.p.LockMainPresenter;

import java.util.List;

/**
 * Created by Mrlove
 */

public interface LockMainContract {
    interface View extends BaseView<Presenter> {

        void loadAppInfoSuccess(List<CommLockInfo> list);
    }

    interface Presenter extends BasePresenter {
        void loadAppInfo(Context context);

        void searchAppInfo(String search, LockMainPresenter.ISearchResultListener listener);

        void onDestroy();
    }
}
