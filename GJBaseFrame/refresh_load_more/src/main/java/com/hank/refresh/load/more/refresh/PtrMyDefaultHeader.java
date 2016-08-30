package com.hank.refresh.load.more.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hank.refresh.load.more.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by yubaokang on 16-6-23.
 */
public class PtrMyDefaultHeader extends FrameLayout implements PtrUIHandler {
    private TextView textView;

    public PtrMyDefaultHeader(Context context) {
        super(context);
        initViews();
    }

    public PtrMyDefaultHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public PtrMyDefaultHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initViews();
    }

    protected void initViews() {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.my_default_header, this);
        textView = (TextView) header.findViewById(R.id.textView);
    }

    //step 1 下拉-未达到释放刷新的位置
    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        textView.setText("下拉");
    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {
        final int mOffsetToRefresh = frame.getOffsetToRefresh();
        final int currentPos = ptrIndicator.getCurrentPosY();
        final int lastPos = ptrIndicator.getLastPosY();
        if (currentPos < mOffsetToRefresh && lastPos >= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                crossRotateLineFromBottomUnderTouch();
            }
        } else if (currentPos > mOffsetToRefresh && lastPos <= mOffsetToRefresh) {
            if (isUnderTouch && status == PtrFrameLayout.PTR_STATUS_PREPARE) {
                crossRotateLineFromTopUnderTouch();
            }
        }
    }

    //step 2 下拉-达到了释放刷新的位置
    private void crossRotateLineFromTopUnderTouch() {
        textView.setText("释放刷新");
    }

    //step 2 达到释放刷新的位置继续往上移动到不可释放刷新的位置
    private void crossRotateLineFromBottomUnderTouch() {
        textView.setText("下拉2");
    }

    //step 3 正在刷新
    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        textView.setText("正在刷新");
    }

    //step 4 刷新完成
    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        textView.setText("完成");
    }

    //step 5 刷新完成之后，Header消失
    @Override
    public void onUIReset(PtrFrameLayout frame) {
    }
}
