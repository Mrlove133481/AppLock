package com.mrlove.lock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.mrlove.lock.R;
import com.mrlove.lock.bean.LockAutoTime;

import java.util.List;

/**
 * Created by Mrlove
 */

public class SelectTimeAdapter extends RecyclerView.Adapter<SelectTimeAdapter.ViewHolder> {

    private List<LockAutoTime> mTimeList;
    private Context mContext;
    private String title = "";
    private OnItemClickListener listener;

    public SelectTimeAdapter(List<LockAutoTime> timeList, Context context) {
        mTimeList = timeList;
        mContext = context;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public SelectTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SelectTimeAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lock_select_time, null));
    }

    @Override
    public void onBindViewHolder(SelectTimeAdapter.ViewHolder holder, final int position) {
        final LockAutoTime info = mTimeList.get(position);
        holder.mItemTime.setText(info.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    if (position == mTimeList.size() - 1)
                        listener.onItemClick(info, true);
                    else
                        listener.onItemClick(info, false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mItemTime;
        public View mLine;

        public ViewHolder(View itemView) {
            super(itemView);
            mItemTime = (TextView) itemView.findViewById(R.id.item_time);
            mLine = itemView.findViewById(R.id.line);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(LockAutoTime info, boolean isLast);
    }
}
