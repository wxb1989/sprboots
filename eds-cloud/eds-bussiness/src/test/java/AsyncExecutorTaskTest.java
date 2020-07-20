import com.eds.cloud.bussiness.task.AsyncCallBackTask;
import com.eds.cloud.bussiness.task.AsyncExecutorTask;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author wxb
 * @version V1.0
 * @Package PACKAGE_NAME
 * @date 2020/7/20 13:58
 */
public class AsyncExecutorTaskTest  extends BaseTest{

    @Resource
    private AsyncExecutorTask asyncExecutorTask;

    @Resource
    private AsyncCallBackTask  asyncCallBackTask;


    @Test
    public void testAsyncCallbackTask() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncCallBackTask.doTaskOneCallback();
        Future<String> task2 = asyncCallBackTask.doTaskTwoCallback();
        Future<String> task3 = asyncCallBackTask.doTaskThreeCallback();

        // 三个任务都调用完成，退出循环等待
        while (!task1.isDone() || !task2.isDone() || !task3.isDone()) {
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void testAsyncExecutorTask() throws Exception {
        asyncExecutorTask.doTaskOne();
        asyncExecutorTask.doTaskTwo();
        asyncExecutorTask.doTaskThree();

        Thread.sleep(1000L);
    }


}
