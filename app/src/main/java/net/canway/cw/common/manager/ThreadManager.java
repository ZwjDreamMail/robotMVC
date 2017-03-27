package net.canway.cw.common.manager;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class ThreadManager {
    ThreadPoolExecutor mExecutor;

    int mCoreThreadSize;
    int mMaxThreadSize;
    long mKeepAliveTime;


    public ThreadManager(int coreThreadSize,int maxThreadSize,long keepAliveTime){
        this.mCoreThreadSize = coreThreadSize;
        this.mMaxThreadSize = maxThreadSize;
        this.mKeepAliveTime = keepAliveTime;
    }

    public void  initThreadpoolExecuter(){
        if(mExecutor==null||mExecutor.isShutdown()||mExecutor.isTerminated()) {
            synchronized (ThreadManager.class) {
                if (mExecutor == null || mExecutor.isShutdown() || mExecutor.isTerminated()) {
                    TimeUnit unit = TimeUnit.MILLISECONDS;
                    BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
                    ThreadFactory factory = Executors.defaultThreadFactory();
                    RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
                    mExecutor = new ThreadPoolExecutor(
                            mCoreThreadSize,
                            mMaxThreadSize,
                            mKeepAliveTime,
                            unit,
                            workQueue,
                            factory,
                            handler
                    );
                }
            }
        }
    }

    public void ExecutorTask(Runnable task){
        initThreadpoolExecuter();
        mExecutor.execute(task);
    }

    public void removeTask(Runnable task){
        initThreadpoolExecuter();
        if(mExecutor!=null) {
            mExecutor.remove(task);
        }
    }
}
