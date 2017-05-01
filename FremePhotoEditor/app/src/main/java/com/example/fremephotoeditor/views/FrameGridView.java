package com.example.fremephotoeditor.views;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.fremephotoeditor.R;

/**
 * Created by user on 2017/05/01.
 */

public class FrameGridView extends RelativeLayout {

    private Context context = null;

    private int cellSizeWidth = 0;
    private int cellSizeHight = 0;

    private static final int FRAME_SPACE = 10;

    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;


    public FrameGridView(Context context) {
        super(context);

        this.context = context;
    }

    public FrameGridView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

        this.context = context;

    }

    public FrameGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;

        init();
    }

    /**
     * pixelからdpへの変換
     * @param px
     * @param context
     * @return float dp
     */
    public static float convertPx2Dp(int px, Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return px / metrics.density;
    }

    private void init(){

        mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                setupFrameCell();

                getViewTreeObserver().removeOnGlobalLayoutListener(mGlobalLayoutListener);
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(mGlobalLayoutListener);

    }

    private void setupFrameCell(){
        cellSizeWidth = getWidth() / 3;
        cellSizeHight = getHeight() / 4;

        LinearLayout ll = new LinearLayout(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                new LayoutParams(cellSizeWidth, cellSizeHight));

        ll.setLayoutParams(lp);
        ll.setBackgroundColor(Color.BLACK);

        addView(ll);
    }

}
