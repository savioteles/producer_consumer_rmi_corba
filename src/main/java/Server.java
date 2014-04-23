package main.java;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static McDonaldsInterface runServer() throws RemoteException, InterruptedException {
		
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
		
		System.out.println("Iniciando a simulação de um atendimento no McDonalds");
		
		return engine;
	}
	
	public static void main(String[] args) throws RemoteException, InterruptedException {
		McDonaldsInterface engine = Server.runServer();
		
		while(true){
			System.out.println(engine.getQtdBigMac() +":" +engine.getQtdBigMacProducers() +":" +engine.getQtdBigMacConsumers() 
					+"\t" +engine.getQtdMcChicken() +":" +engine.getQtdMcChickenProducers() +":" +engine.getQtdMcChickenConsumers() 
					+"\t" +engine.getQtdMcFish() +":" +engine.getQtdMcFishProducers() +":" +engine.getQtdMcFishConsumers());
			System.out.println();
			Thread.sleep(1000);
		}
	}
}
