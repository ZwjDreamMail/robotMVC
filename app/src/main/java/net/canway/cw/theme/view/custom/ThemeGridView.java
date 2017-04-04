package net.canway.cw.theme.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThemeGridView extends GridView {
    public ThemeGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThemeGridView(Context context) {
        super(context);
    }

    public ThemeGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    //	// 通过重新dispatchTouchEvent方法来禁止滑动
    //	@Override
    //	public boolean dispatchTouchEvent(MotionEvent ev) {
    //		if (ev.getAction() == MotionEvent.ACTION_MOVE) {
    //			Log.e("jj", "滑动");
    //			return false;// 禁止Gridview进行滑动
    //		}
    //		return super.dispatchTouchEvent(ev);
    //	}

    //	/** touch 事件处理 **/
    //	@Override
    //	public boolean onTouchEvent(MotionEvent ev) {
    //		if (ev.getAction()!= MotionEvent.ACTION_DOWN) {
    //			return false;
    //		}
    //		return super.onTouchEvent(ev);
    //	}

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
