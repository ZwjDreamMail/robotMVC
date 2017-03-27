package net.canway.cw.common.factory;

import net.canway.cw.common.manager.ThreadManager;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThreadPoolPoxyFactory {
    static ThreadManager mThreadManager;
    public static  ThreadManager creatThreadPoxy(){
        if(mThreadManager==null) {
            synchronized (ThreadPoolPoxyFactory.class){
                if(mThreadManager==null) {
                    mThreadManager = new ThreadManager(3,3,1000);
                }
            }
        }
        return  mThreadManager;
    }
}
