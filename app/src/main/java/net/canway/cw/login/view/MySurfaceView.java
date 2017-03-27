package net.canway.cw.login.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import net.canway.cw.R;
import net.canway.cw.common.manager.SparkManager;


/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class MySurfaceView extends SurfaceView implements
        SurfaceHolder.Callback, Runnable {
    //上下文路径
    private Context mContext;
    //surfaceholder
    private SurfaceHolder mHolder;
    //创建一个粒子管理成员变量
    private SparkManager mSparkManager;
    //画布
    private Canvas mCanvas;
    //标志符
    private boolean isRun;
    //绘制的背景图片
    public Bitmap mBitmap;
    //屏幕的宽高
    float mWidth;
    float mheight;
    //触摸点的x,y坐标
    double X, Y;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mSparkManager.isActive = true;
                X = event.getX();
                Y = event.getY();
                break;

            case MotionEvent.ACTION_UP:
                mSparkManager.isActive = false;
                break;

        }
        return true;
    }

    public MySurfaceView(Context context) {
        super(context);
        mContext = context;
        mSparkManager = new SparkManager();
        mHolder = this.getHolder();
        mHolder.addCallback(this);
        isRun = true;
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mSparkManager = new SparkManager();
        mHolder = this.getHolder();
        mHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        isRun = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        isRun = false;
    }

    @Override
    public void run() {
        //初始化粒子数组
        int[][] sparks = new int[200][10];

        while (isRun) {
            try {
                mCanvas = mHolder.lockCanvas();
                //清屏操作
                mCanvas.drawColor(Color.GRAY, PorterDuff.Mode.CLEAR);
                //设置图片资源
                mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.login_splash);
                Bitmap newBitmap = Bitmap.createBitmap(mBitmap);
                Matrix matrix = new Matrix();
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //获取屏幕高度
                mheight = display.getHeight();
                mWidth = display.getWidth();
                float scalWidth = mWidth / mBitmap.getWidth();
                float scalHeight = mheight / mBitmap.getHeight();
                //设置缩放比例
                matrix.setScale(scalWidth, scalHeight);
                mCanvas.drawBitmap(mBitmap, matrix, new Paint());
                for ( int[] n : sparks){
                    n = mSparkManager.drawSpark(mCanvas, (int) X, (int) Y, n);
                }

                Thread.sleep(10);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(mCanvas!=null) {
                    mHolder.unlockCanvasAndPost(mCanvas);
                }
            }
        }
    }

}
