package com.mrlove.lock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mrlove.lock.base.AppConstants;
import com.mrlove.lock.service.LoadAppListService;
import com.mrlove.lock.service.LockService;
import com.mrlove.lock.utils.LogUtil;
import com.mrlove.lock.utils.SpUtil;

/**
 * 开机启动广播
 * Created by Mrlove
 */

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtil.i("开机启动服务....");
        context.startService(new Intent(context, LoadAppListService.class));
        if (SpUtil.getInstance().getBoolean(AppConstants.LOCK_STATE, false)) {
            context.startService(new Intent(context, LockService.class));
        }
    }
}
