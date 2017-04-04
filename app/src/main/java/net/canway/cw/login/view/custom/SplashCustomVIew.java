package net.canway.cw.login.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.canway.cw.R;
import net.canway.cw.common.util.UIUtils;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class SplashCustomView extends LinearLayout {

    private View mView;
    // 控件id
    private ImageView mImageView;
    private TextView mSplash_anim_text;

    // 将px转为pd
    private int paintWidth = UIUtils.dp2Px(8);
    private int mCurrentDegree;

    // 控件上下左右的坐标位置
    private int mLeft;
    private int mTop;
    private int mWidth;
    private int mRight;
    private int mButtom;
    private int mCenterX;
    private boolean mRelative;
    private int mDrawable;
    private Bitmap mBitmap;
    private  String mText;
    private Context mContext;
    // 动画
    private RotateAnimation mAnimation;
    // 点击事件的回调接口
    private IloadingClick mClick;

    public SplashCustomView(Context context) {
        super(context);

    }

    public SplashCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义的属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.splash_custom);
        mRelative = typedArray.getBoolean(R.styleable.splash_custom_relative, true);
        mDrawable = typedArray.getResourceId(R.styleable.splash_custom_src, R.drawable.login_rotate);
        mText = typedArray.getString(R.styleable.splash_custom_text);
        typedArray.recycle();
        // 在构造器中初始化对应的视图
        if(mRelative) {
            mView = SplashCustomView.inflate(UIUtils.getContext(), R.layout.login_splash_right_item, this);
        }else{
            mView = SplashCustomView.inflate(UIUtils.getContext(), R.layout.login_splash_left_item, this);
        }

        mImageView = (ImageView) mView.findViewById(R.id.splash_anim_icon);
        mSplash_anim_text = (TextView) mView.findViewById(R.id.splash_anim_text);
        mImageView.setImageResource(mDrawable);
        mSplash_anim_text.setText(mText);
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


        mLeft = mImageView.getLeft();
        mRight =  mImageView.getRight();
        mButtom = mImageView.getBottom();
        mTop = mImageView.getTop();
        mWidth = mImageView.getWidth();
        mCenterX = mLeft+ mWidth/2;

        //设置图片资源
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.splash_anim_video);
        Bitmap newBitmap = Bitmap.createBitmap(mBitmap);
        Matrix matrix = new Matrix();

        //获取屏幕高度
        float scalWidth = (UIUtils.getScreenWidth()- mCenterX) / mBitmap.getWidth();
        float scalHeight =(mButtom-mTop) / mBitmap.getHeight();
        //设置缩放比例
        matrix.setScale(scalWidth, scalHeight);
        setAnimation();
        /*if(mAnimation==null) {
            setAnimation();
        }*/

        RectF rectF = new RectF(mLeft+paintWidth/2,
                mTop+paintWidth/2,
                mRight-paintWidth/2,
                mButtom-paintWidth/2);
        //初始化画笔
        Paint paint = new Paint();
        //设置画笔的颜色

        paint.setColor(Color.parseColor("#08cee4"));
        //设置画笔的宽度
        paint.setStrokeWidth(paintWidth);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置为实心绘制
        paint.setStyle(Paint.Style.STROKE);
        // 绘制步骤 直线-->圆弧-->直线
        if(mRelative) {
            // 获取到整个控件的最上方坐标
            Log.e("mCenterX", mLeft +"--1");
            //canvas.drawBitmap(mBitmap, mCenterX,mTop, paint);
            canvas.drawLine(UIUtils.getScreenWidth(),mTop+paintWidth/2, mCenterX,mTop+paintWidth/2,paint);
            canvas.drawArc(rectF,-90,-180,false,paint);
            canvas.drawLine(mCenterX,mButtom-paintWidth/2,UIUtils.getScreenWidth(),mButtom-paintWidth/2,paint);
        }else{
            Log.e("mCenterX", mLeft +"--2");
            canvas.drawLine(0,mTop+paintWidth/2, mCenterX,mTop+paintWidth/2,paint);
            canvas.drawArc(rectF,-90,180,false,paint);
            canvas.drawLine(mCenterX,mButtom-paintWidth/2,0,mButtom-paintWidth/2,paint);
        }

    }

    public void  setAnimation(){
        Log.e("mCenterX", mCenterX +"-3");
        Log.e("mCenterX", mWidth +"-4");
        mAnimation = new RotateAnimation(0,360, UIUtils.dp2Px(49), UIUtils.dp2Px(49));
        mAnimation.setRepeatCount(12);
        mAnimation.setDuration(2000);
        //开始播放动画
        mImageView.setAnimation(mAnimation);
        mAnimation=null;
    }

    public void setImageIcon(@DrawableRes int drawable){
        this.mDrawable = drawable;
        // invalidate();
    }


}
