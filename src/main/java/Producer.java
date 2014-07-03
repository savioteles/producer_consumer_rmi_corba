package main.java;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import main.java.comm.CommunicationController;

public class Producer extends Thread {
	private static int maxCore = 7;
	private static int core = 7;
	private static LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

	public static void main(String args) {
		try {
			McDonaldsInterface mc = CommunicationController.getReference();
			ThreadPoolExecutor pool = new ThreadPoolExecutor(core, maxCore, 10,
					TimeUnit.SECONDS, workQueue);

			while (true) {
				McDonaldsInterface.Option op = McDonaldsInterface.Option.getRandom();
				pool.execute(new ProducerThread(mc, op));
				Thread.sleep((long) (Math.random() * 100));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class ProducerThread implements Runnable {
		McDonaldsInterface mc;
		McDonaldsInterface.Option op;

		public ProducerThread(McDonaldsInterface mc, McDonaldsInterface.Option op) {
			this.mc = mc;
			this.op = op;
		}

		public void run() {
			try {
				switch (op) {
				case BIG_MAC:
					mc.produceBigMac();
					break;
				case MC_CHICKEN:
					mc.produceMcChicken();
					break;
				case MC_FISH:
					mc.produceMcFish();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public int getProdSize() {
		return workQueue.size();
	}
}
