package main.java.comm;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import main.java.McDonaldsInterface;
import main.java.corba.CorbaNameServices;
import main.java.rmi.McDonaldsRmiInterface;
import _McDonaldsCorbaPackage.McDonaldsCorba;

public class CommunicationServiceImpl implements McDonaldsInterface {

	McDonaldsRmiInterface rmi;
	McDonaldsCorba corba;
	
	public CommunicationServiceImpl() throws Exception {
		String name = McDonaldsRmiInterface.MC_DONALDS;
		Registry registry = LocateRegistry.getRegistry();
		rmi = (McDonaldsRmiInterface) registry.lookup(name);
		
		CorbaNameServices nameServices = new CorbaNameServices("Corba");
		corba = nameServices.consultaObjeto();
	}

	@Override
	public void produceMcChicken() {
		try {
			rmi.produceMcChicken();
		} catch (RemoteException e) {
			corba.produceMcChicken();
		}
	}

	@Override
	public void consumeMcChicken() {
		try {
			rmi.consumeMcChicken();
		} catch (RemoteException e) {
			corba.consumeMcChicken();
		}
	}

	@Override
	public int getQtdMcChicken() {
		try {
			return rmi.getQtdMcChicken();
		} catch (RemoteException e) {
			return corba.getQtdMcChicken();
		}
	}

	@Override
	public int getQtdMcChickenConsumers() {
		try {
			return rmi.getQtdMcChickenConsumers();
		} catch (RemoteException e) {
			return corba.getQtdMcChickenConsumers();
		}
	}

	@Override
	public int getQtdMcChickenProducers() {
		try {
			return rmi.getQtdMcChickenProducers();
		} catch (RemoteException e) {
			return corba.getQtdMcChickenProducers();
		}
	}

	@Override
	public void produceMcFish() {
		try {
			rmi.produceMcFish();
		} catch (RemoteException e) {
			corba.produceMcFish();
		}
	}

	@Override
	public void consumeMcFish() {
		try {
			rmi.consumeMcFish();
		} catch (RemoteException e) {
			corba.consumeMcFish();
		}
	}

	@Override
	public int getQtdMcFish() {
		try {
			return rmi.getQtdMcFish();
		} catch (RemoteException e) {
			return corba.getQtdMcFish();
		}
	}

	@Override
	public int getQtdMcFishConsumers() {
		try {
			return rmi.getQtdMcFishConsumers();
		} catch (RemoteException e) {
			return corba.getQtdMcFishConsumers();
		}
	}

	@Override
	public int getQtdMcFishProducers() {
		try {
			return rmi.getQtdMcFishProducers();
		} catch (RemoteException e) {
			return corba.getQtdMcFishProducers();
		}
	}

	@Override
	public void produceBigMac() {
		try {
			rmi.produceBigMac();
		} catch (RemoteException e) {
			corba.produceBigMac();
		}
		
	}

	@Override
	public void consumeBigMac() {
		try {
			rmi.consumeBigMac();
		} catch (RemoteException e) {
			corba.consumeBigMac();
		}
		
	}

	@Override
	public int getQtdBigMac() {
		try {
			return rmi.getQtdBigMac();
		} catch (RemoteException e) {
			return corba.getQtdBigMac();
		}
	}

	@Override
	public int getQtdBigMacConsumers() {
		try {
			return rmi.getQtdBigMacConsumers();
		} catch (RemoteException e) {
			return corba.getQtdBigMacConsumers();
		}
	}

	@Override
	public int getQtdBigMacProducers() {
		try {
			return rmi.getQtdBigMacProducers();
		} catch (RemoteException e) {
			return corba.getQtdBigMacProducers();
		}
	}
}