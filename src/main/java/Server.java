package main.java;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main(String[] args) throws RemoteException, InterruptedException {
		
		LocateRegistry.createRegistry(1099);
		String name = McDonaldsInterface.MC_DONALDS;
		McDonaldsInterface engine = new McDonalds();
		McDonaldsInterface stub = (McDonaldsInterface) UnicastRemoteObject
				.exportObject(engine, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind(name, stub);
		
		Producer p = new Producer();
		p.start();
		Consumer c = new Consumer();
		c.start();
		
		System.out.println("Servidor ativo");
		
		while(true){
			System.out.println(engine.getQtdMcBigMac() +"\t" +engine.getQtdMcChicken() +"\t" +engine.getQtdMcFish());
			Thread.sleep(1000);
		}
	}
}
