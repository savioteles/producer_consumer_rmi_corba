package main.java.comm;

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
		try {
			Registry registry = LocateRegistry.getRegistry();
			rmi = (McDonaldsRmiInterface) registry.lookup(name);
		} catch (Exception e) {
			rmi = null;
		}
		
		try {
			CorbaNameServices nameServices = new CorbaNameServices(name);
			corba = nameServices.consultaObjeto();
		} catch (Exception e) {
			corba = null;
			if(rmi == null && corba == null)
				System.err.println("Inicie o servidor");
		}
	}

	@Override
	public void produceMcChicken() {
		try {
			rmi.produceMcChicken();
		} catch (Exception e) {
			corba.produceMcChicken();
		}
	}

	@Override
	public void consumeMcChicken() {
		try {
			rmi.consumeMcChicken();
		} catch (Exception e) {
			corba.consumeMcChicken();
		}
	}

	@Override
	public int getQtdMcChicken() {
		try {
			return rmi.getQtdMcChicken();
		} catch (Exception e) {
			return corba.getQtdMcChicken();
		}
	}

	@Override
	public int getQtdMcChickenConsumers() {
		try {
			return rmi.getQtdMcChickenConsumers();
		} catch (Exception e) {
			return corba.getQtdMcChickenConsumers();
		}
	}

	@Override
	public int getQtdMcChickenProducers() {
		try {
			return rmi.getQtdMcChickenProducers();
		} catch (Exception e) {
			return corba.getQtdMcChickenProducers();
		}
	}

	@Override
	public void produceMcFish() {
		try {
			rmi.produceMcFish();
		} catch (Exception e) {
			corba.produceMcFish();
		}
	}

	@Override
	public void consumeMcFish() {
		try {
			rmi.consumeMcFish();
		} catch (Exception e) {
			corba.consumeMcFish();
		}
	}

	@Override
	public int getQtdMcFish() {
		try {
			return rmi.getQtdMcFish();
		} catch (Exception e) {
			return corba.getQtdMcFish();
		}
	}

	@Override
	public int getQtdMcFishConsumers() {
		try {
			return rmi.getQtdMcFishConsumers();
		} catch (Exception e) {
			return corba.getQtdMcFishConsumers();
		}
	}

	@Override
	public int getQtdMcFishProducers() {
		try {
			return rmi.getQtdMcFishProducers();
		} catch (Exception e) {
			return corba.getQtdMcFishProducers();
		}
	}

	@Override
	public void produceBigMac() {
		try {
			rmi.produceBigMac();
		} catch (Exception e) {
			corba.produceBigMac();
		}
		
	}

	@Override
	public void consumeBigMac() {
		try {
			rmi.consumeBigMac();
		} catch (Exception e) {
			corba.consumeBigMac();
		}
		
	}

	@Override
	public int getQtdBigMac() {
		try {
			return rmi.getQtdBigMac();
		} catch (Exception e) {
			return corba.getQtdBigMac();
		}
	}

	@Override
	public int getQtdBigMacConsumers() {
		try {
			return rmi.getQtdBigMacConsumers();
		} catch (Exception e) {
			return corba.getQtdBigMacConsumers();
		}
	}

	@Override
	public int getQtdBigMacProducers() {
		try {
			return rmi.getQtdBigMacProducers();
		} catch (Exception e) {
			return corba.getQtdBigMacProducers();
		}
	}
}