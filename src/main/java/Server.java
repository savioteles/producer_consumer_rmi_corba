package main.java;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import main.java.corba.CorbaNameServices;
import main.java.corba.McDonaldsImplCorba;
import main.java.rmi.McDonaldsImplRmi;
import main.java.rmi.McDonaldsRmiInterface;

public class Server {
	public static McDonaldsRmiInterface runServer(int choice) throws Exception {
		String name = McDonaldsRmiInterface.MC_DONALDS;
		
		McDonaldsExecutor executor = new McDonaldsExecutor();
		
		switch (choice) {
		case 0:
			initCorba(name, executor);
			break;

		default:
			initRmi(name, executor);
			break;
		}
		
		System.out.println("Iniciando a simulação de um atendimento no McDonalds");
		
		return executor;
	}
	
	private static void initRmi(String name, McDonaldsExecutor executor) throws Exception{
		LocateRegistry.createRegistry(1099);
		McDonaldsRmiInterface engine = new McDonaldsImplRmi(executor);
		McDonaldsRmiInterface stub = (McDonaldsRmiInterface) UnicastRemoteObject
				.exportObject(engine, 0);
		Registry registry = LocateRegistry.getRegistry();
		registry.rebind(name, stub);
	}
	
	private static void initCorba(String name, McDonaldsExecutor executor) throws Exception{
		McDonaldsImplCorba corba = new McDonaldsImplCorba(executor);
		CorbaNameServices nameServices = new CorbaNameServices(name);
		nameServices.insereObjeto(corba);
	}
	
	public static void main(String[] args) throws Exception {
		McDonaldsRmiInterface engine = Server.runServer(1);
		
		while(true){
			System.out.println(engine.getQtdBigMac() +":" +engine.getQtdBigMacProducers() +":" +engine.getQtdBigMacConsumers() 
					+"\t" +engine.getQtdMcChicken() +":" +engine.getQtdMcChickenProducers() +":" +engine.getQtdMcChickenConsumers() 
					+"\t" +engine.getQtdMcFish() +":" +engine.getQtdMcFishProducers() +":" +engine.getQtdMcFishConsumers());
			System.out.println();
			Thread.sleep(1000);
		}
	}
}
