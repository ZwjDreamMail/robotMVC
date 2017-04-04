package net.canway.cw.theme.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import net.canway.cw.R;


/**
 * 创建者     王维波
 * 创建时间   2016/6/2
 * 更新描述   ${TODO}
 */
public class RatioLayout extends FrameLayout {

    //图片的宽高比
    private             float mPicRatio       = 1.f;
    //公式
    //图片的宽高比==RatioLayout.width/RatioLayout.height
    public static final int   RELATIVE_WIDTH  = 0;//1.已知宽度,可以动态计算高度
    public static final int   RELATIVE_HEIGHT = 1;//2.已知高度,可以动态计算宽度

    private int mRelative = RELATIVE_HEIGHT;//默认


    public void setPicRatio(float picRatio) {
        mPicRatio = picRatio;
    }

    public void setRelative(int relative) {
        mRelative = relative;
    }

    public RatioLayout(Context context) {
        this(context, null);
    }

    public RatioLayout(Context context, AttributeSet attrs) {
        super(context, attrs);


        //获取自定义的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RatioLayout);

        mRelative = typedArray.getInt(R.styleable.RatioLayout_relat, 0);
        mPicRatio = typedArray.getFloat(R.styleable.RatioLayout_picRatio, 1);

        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         UNSPECIFIED 不确定的 wrap_content
         EXACTLY 确定 match_parent 100dp
         AT_MOST 至多
         */
        //得到RatioLayout在xml中定义的Layout_width的模式
        int selfWidthMode = MeasureSpec.getMode(widthMeasureSpec);

        //得到RatioLayout在xml中定义的Layout_height的模式
        int selfHeightMode = MeasureSpec.getMode(heightMeasureSpec);


        if (selfWidthMode == MeasureSpec.EXACTLY && mRelative == RELATIVE_WIDTH) {//已知宽度
            //得到RatioLayout测绘的宽度
            int selfWidth = MeasureSpec.getSize(widthMeasureSpec);

            //动态计算RatioLayout自身应有的高度
            int selfHeight = (int) (selfWidth / mPicRatio + .5f);

            //计算孩子应有高度和宽度

            int childWith = selfWidth - getPaddingLeft() - getPaddingRight();
            int childHeigh = selfHeight - getPaddingTop() - getPaddingBottom();

            //请求孩子测绘自身,按照指定MeasureSpec(mode+size)
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWith, MeasureSpec.EXACTLY);
            int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeigh, MeasureSpec.EXACTLY);
            measureChildren(childWidthMeasureSpec, childHeightMeasureSpec);

            //保存测绘结果
            setMeasuredDimension(selfWidth, selfHeight);
        } else if (selfHeightMode == MeasureSpec.EXACTLY && mRelative == RELATIVE_HEIGHT) {//已知了高度
            //得到自身的高度
            int selfHeight = MeasureSpec.getSize(heightMeasureSpec);

            //动态计算应有的宽度
            int selfWidth = (int) (mPicRatio * selfHeight + .5f);

            //计算孩子应有高度和宽度

            int childWith = selfWidth - getPaddingLeft() - getPaddingRight();
            int childHeigh = selfHeight - getPaddingTop() - getPaddingBottom();

            //请求孩子测绘自身,按照指定MeasureSpec(mode+size)
            int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(childWith, MeasureSpec.EXACTLY);
            int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(childHeigh, MeasureSpec.EXACTLY);
            measureChildren(childWidthMeasureSpec, childHeightMeasureSpec);

            setMeasuredDimension(selfWidth, selfHeight);

        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
