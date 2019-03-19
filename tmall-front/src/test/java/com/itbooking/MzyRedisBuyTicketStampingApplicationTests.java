package com.itbooking;

import java.util.concurrent.CountDownLatch;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.itbooking.service.item.ContentDubboService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MzyRedisBuyTicketStampingApplicationTests {

	long timed = 0L;
	
	@Before
	public void starter() {
		System.out.println("==========测试开始===========");
		timed = System.currentTimeMillis();
	}
	
	@After
	public void end() {
		System.out.println("==========测试结束===========消耗时长是："+(System.currentTimeMillis() - timed)+"ms");
	}
	
	
	@Autowired
	ContentDubboService contentDubboService;
	
	//车次
	private static final Long CATEGORY_ID = 1L;
	//模拟请求的数量
	private static final int THREAD_NUM = 100;
	
	//倒计数器：juc包常用工具类
	private CountDownLatch countDownLatch= new CountDownLatch(THREAD_NUM);
	
	@Test
	public void benchmark() {
		//创建，并不是马上发起请求，模拟并发请求
		Thread[] threads = new Thread[THREAD_NUM];
		for (int i = 0; i < THREAD_NUM; i++) {
			
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("=========================ok");
					//代码在这里等待，阻塞，等待countDownLatch变成0，代表所有线程都start,在运行后续的代码
					try {
						countDownLatch.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					//http请求，实际上就是多线程调用这个方法
					contentDubboService.findContents(CATEGORY_ID, 1,10);
				}
			});
			
			threads[i] = thread;
			thread.start();
			//启动后，倒计时计数器减一，代表有一个线程准备就绪了。
			countDownLatch.countDown();
		}
		
	}

}

