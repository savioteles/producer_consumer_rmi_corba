package main.java.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.security.SecureRandom;
import java.util.Random;

public interface McDonaldsRmiInterface extends Remote {

	static final String MC_DONALDS = "McDonalds";
	Random r = new SecureRandom();
	
	enum Option{
		MC_CHICKEN, MC_FISH, BIG_MAC;
		
		 public static Option getRandom() {
	        return values()[(int) (r.nextInt(values().length))];
	    }
	}
	
	public void produceMcChicken() throws RemoteException;
	public void consumeMcChicken() throws RemoteException;
	public int getQtdMcChicken() throws RemoteException;
	int getQtdMcChickenConsumers() throws RemoteException;
	int getQtdMcChickenProducers() throws RemoteException;
	
	public void produceMcFish() throws RemoteException;
	public void consumeMcFish() throws RemoteException;
	public int getQtdMcFish() throws RemoteException;
	int getQtdMcFishConsumers() throws RemoteException;
	int getQtdMcFishProducers() throws RemoteException;
	
	public void produceBigMac() throws RemoteException;
	public void consumeBigMac() throws RemoteException;
	public int getQtdBigMac() throws RemoteException;
	int getQtdBigMacConsumers() throws RemoteException;
	int getQtdBigMacProducers() throws RemoteException;
}
