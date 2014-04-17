package main.java;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class McDonalds implements McDonaldsInterface {

	private static McDonaldsQueue<Character> mcChickenQueue;
	private static McDonaldsQueue<Character> mcFishQueue;
	private static McDonaldsQueue<Character> bigMacQueue;
	ThreadPoolExecutor pool;

	public McDonalds() {
		mcChickenQueue = new McDonaldsQueue<Character>();
		mcFishQueue = new McDonaldsQueue<Character>();
		bigMacQueue = new McDonaldsQueue<Character>();
		pool = new ThreadPoolExecutor(300, 300, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
	}

	public void produceMcChicken() {
		pool.execute(new ThreadExec(mcChickenQueue, new Character('c')));
	}

	public void consumeMcChicken() {
		pool.execute(new ThreadExec(mcChickenQueue, null));
	}

	public int getQtdMcChicken() {
		return mcChickenQueue.size();
	}
	
	public int getQtdMcChickenProducers() {
		return mcChickenQueue.getCountProducer();
	}
	
	public int getQtdMcChickenConsumers() {
		return mcChickenQueue.getCountConsumer();
	}

	public void produceMcFish() {
		pool.execute(new ThreadExec(mcFishQueue, new Character('f')));
	}

	public void consumeMcFish() {
		pool.execute(new ThreadExec(mcFishQueue, null));
	}

	public int getQtdMcFish() {
		return mcFishQueue.size();
	}
	
	
	public int getQtdMcFishProducers() {
		return mcFishQueue.getCountProducer();
	}
	
	
	public int getQtdMcFishConsumers() {
		return mcFishQueue.getCountConsumer();
	}

	public void produceBigMac() {
		pool.execute(new ThreadExec(bigMacQueue, new Character('b')));
	}

	public void consumeBigMac() {
		pool.execute(new ThreadExec(bigMacQueue, null));
	}

	public int getQtdBigMac() {
		return bigMacQueue.size();
	}
	
	
	public int getQtdBigMacProducers() {
		return bigMacQueue.getCountProducer();
	}
	
	
	public int getQtdBigMacConsumers() {
		return bigMacQueue.getCountConsumer();
	}
	
	private class ThreadExec implements Runnable{
		McDonaldsQueue<Character> queue;
		Character c;
		
		public ThreadExec(McDonaldsQueue<Character> queue, Character c) {
			super();
			this.queue = queue;
			this.c = c;
		}


		public void run() {
			if(c!= null)
				queue.insert(c);
			else
				queue.remove();
		}
		
	}

}
