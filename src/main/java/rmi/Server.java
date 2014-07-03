package main.java.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import main.java.Consumer;
import main.java.Producer;

public class Server {
	public static McDonaldsRmiInterface runServer() throws RemoteException, InterruptedException {
		
		LocateRegistry.createRegistry(1099);
		String name = McDonaldsRmiInterface.MC_DONALDS;
		 
		McDonaldsRmiInterface engine = new McDonaldsImplRmi();
		McDonaldsRmiInterface stub = (McDonaldsRmiInterface) UnicastRemoteObject
				.exportObject(engine, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind(name, stub);
		
		System.out.println("Iniciando a simulação de um atendimento no McDonalds");
		
		return engine;
	}
	
	public static void main(String[] args) throws RemoteException, InterruptedException {
		McDonaldsRmiInterface engine = Server.runServer();
		
		while(true){
			System.out.println(engine.getQtdBigMac() +":" +engine.getQtdBigMacProducers() +":" +engine.getQtdBigMacConsumers() 
					+"\t" +engine.getQtdMcChicken() +":" +engine.getQtdMcChickenProducers() +":" +engine.getQtdMcChickenConsumers() 
					+"\t" +engine.getQtdMcFish() +":" +engine.getQtdMcFishProducers() +":" +engine.getQtdMcFishConsumers());
			System.out.println();
			Thread.sleep(1000);
		}
	}
}
