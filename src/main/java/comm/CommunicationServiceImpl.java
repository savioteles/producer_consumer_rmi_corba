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
			System.out.println("Utilizando o RMI para comunicação com o servidor.");
		} catch (Exception e) {
			rmi = null;
		}

		try {
			if (rmi == null) {
				CorbaNameServices nameServices = new CorbaNameServices(name);
				corba = nameServices.consultaObjeto();
				System.out.println("Utilizando o CORBA para comunicação com o servidor.");
			}
		} catch (Exception e) {
			corba = null;
			if (rmi == null && corba == null) {
				System.err
						.println("\nOcorreu um erro ao iniciar a aplicação! Inicie o servidor...");
				System.exit(0);
			}
		}
	}

	@Override
	public void produceMcChicken() {
		try {
			rmi.produceMcChicken();
		} catch (Exception e) {
			try {
				corba.produceMcChicken();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}

		}
	}

	@Override
	public void consumeMcChicken() {
		try {
			rmi.consumeMcChicken();
		} catch (Exception e) {
			try {
				corba.consumeMcChicken();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}
		}
	}

	@Override
	public int getQtdMcChicken() {
		try {
			return rmi.getQtdMcChicken();
		} catch (Exception e) {
			try {
				return corba.getQtdMcChicken();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdMcChickenConsumers() {
		try {
			return rmi.getQtdMcChickenConsumers();
		} catch (Exception e) {
			try {
				return corba.getQtdMcChickenConsumers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdMcChickenProducers() {
		try {
			return rmi.getQtdMcChickenProducers();
		} catch (Exception e) {
			try {
				return corba.getQtdMcChickenProducers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public void produceMcFish() {
		try {
			rmi.produceMcFish();
		} catch (Exception e) {
			try {
				corba.produceMcFish();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}
		}
	}

	@Override
	public void consumeMcFish() {
		try {
			rmi.consumeMcFish();
		} catch (Exception e) {
			try {
				corba.consumeMcFish();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}
		}
	}

	@Override
	public int getQtdMcFish() {
		try {
			return rmi.getQtdMcFish();
		} catch (Exception e) {
			try {
				return corba.getQtdMcFish();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdMcFishConsumers() {
		try {
			return rmi.getQtdMcFishConsumers();
		} catch (Exception e) {
			try {
				return corba.getQtdMcFishConsumers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdMcFishProducers() {
		try {
			return rmi.getQtdMcFishProducers();
		} catch (Exception e) {
			try {
				return corba.getQtdMcFishProducers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public void produceBigMac() {
		try {
			rmi.produceBigMac();
		} catch (Exception e) {
			try {
				corba.produceBigMac();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}
		}

	}

	@Override
	public void consumeBigMac() {
		try {
			rmi.consumeBigMac();
		} catch (Exception e) {
			try {
				corba.consumeBigMac();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
			}
		}

	}

	@Override
	public int getQtdBigMac() {
		try {
			return rmi.getQtdBigMac();
		} catch (Exception e) {
			try {
				return corba.getQtdBigMac();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdBigMacConsumers() {
		try {
			return rmi.getQtdBigMacConsumers();
		} catch (Exception e) {
			try {
				return corba.getQtdBigMacConsumers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}

	@Override
	public int getQtdBigMacProducers() {
		try {
			return rmi.getQtdBigMacProducers();
		} catch (Exception e) {
			try {
				return corba.getQtdBigMacProducers();
			} catch (Exception e1) {
				System.err
						.println("O Servidor não está respondendo as requisições. A aplicação será encerrada!");
				System.exit(0);
				return 0;
			}
		}
	}
}