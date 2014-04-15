package main.java;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import main.java.McDonaldsInterface.Option;

public class Consumer extends Thread{
	private int maxCore = 6;
	private int core = 4;

	public Consumer() {
	}

	public Consumer(int maxCore, int core) {
		this.maxCore = maxCore;
		this.core = core;
	}

	public void run() {
		try {
			String name = McDonaldsInterface.MC_DONALDS;
			Registry registry = LocateRegistry.getRegistry();
			McDonaldsInterface mc = (McDonaldsInterface) registry.lookup(name);

			while (true) {
				ThreadPoolExecutor pool = new ThreadPoolExecutor(core, maxCore,
						10, TimeUnit.SECONDS,
						new LinkedBlockingQueue<Runnable>());
				pool.execute(new ConsumerThread(mc, Option.getRandom()));
				Thread.sleep((long) (Math.random() * 100));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class ConsumerThread implements Runnable {
		McDonaldsInterface mc;
		Option op;

		public ConsumerThread(McDonaldsInterface mc, Option op) {
			this.mc = mc;
			this.op = op;
		}

		public void run() {
			try {
				switch (op) {
				case BIG_MAC:
					mc.consumeBigMac();
					break;
				case MC_CHICKEN:
					mc.consumeMcChicken();
					break;
				case MC_FISH:
					mc.consumeMcFish();
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
