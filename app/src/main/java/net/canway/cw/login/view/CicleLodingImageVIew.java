package net.canway.cw.login.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;



/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class CicleLodingImageVIew extends LinearLayout {

    private View mView;
    private ImageView mImageView;
    private int paintWidth = UIUtils.px2Dip(8);
    private int mCurrentDegree;

    private int mLeft;
    private int mTop;
    private int mWidth;
    private RotateAnimation mAnimation;
    private IloadingClick mClick;

    public CicleLodingImageVIew(Context context) {
        super(context);
        mView = CicleLodingImageVIew.inflate(UIUtils.getContext(), R.layout.login_circle_item, this);
        mImageView = (ImageView) mView.findViewById(R.id.splash_quan);
    }

    public CicleLodingImageVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = CicleLodingImageVIew.inflate(UIUtils.getContext(), R.layout.login_circle_item, this);
        mImageView = (ImageView) mView.findViewById(R.id.splash_quan);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void setClick(IloadingClick click){
        this.mClick = click;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :

                break;
            case MotionEvent.ACTION_UP :
                if(mClick!=null) {
                    mClick.onClick(this);
                }
                break;
        }
        return true;
    }

    //进行视图的绘制
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if(mAnimation==null) {
            setAnimation();
        }
        RectF rectF = new RectF(mImageView.getLeft()+paintWidth/2,
                mImageView.getTop()+paintWidth/2,
                mImageView.getRight()-paintWidth/2,
                mImageView.getBottom()-paintWidth/2);
        //初始化画笔
        Paint paint = new Paint();
        //设置画笔的颜色
        paint.setColor(Color.YELLOW);
        //设置画笔的宽度
        paint.setStrokeWidth(paintWidth);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置为实心绘制
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF,0,mCurrentDegree,false,paint);
    }

    public void  setAnimation(){
        mLeft = mImageView.getLeft();
        mTop = mImageView.getTop();
        mWidth = mImageView.getWidth();
        mAnimation = new RotateAnimation(0,360,mLeft+mWidth/2,mTop+mWidth/2);
        mAnimation.setRepeatCount(12);
        mAnimation.setDuration(2000);
        //开始播放动画
        mImageView.setAnimation(mAnimation);
    }

    public void setCurrentDegree(int degree){
        this.mCurrentDegree = degree;
        invalidate();
    }
}
