package main.java;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import main.java.comm.CommunicationController;
import main.java.rmi.McDonaldsRmiInterface.Option;

public class Consumer extends Thread{
	private static int maxCore = 7;
	private static int core = 7;
	private static LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

	public static void main(String[] args) {
		try {
			System.out.println("Iniciando o consumidor do McDonalds com 7 clientes chegando em tempos de 1 a 100ms...");
			McDonaldsInterface mc = CommunicationController.getReference();
			ThreadPoolExecutor pool = new ThreadPoolExecutor(core, maxCore,
					10, TimeUnit.SECONDS,
					workQueue);
			
			while (true) {
				Option op = Option.getRandom();
				pool.execute(new ConsumerThread(mc, op));
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
	
	public int getConsSize(){
		return workQueue.size();
	}
}