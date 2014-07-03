package main.java.comm;

import main.java.McDonaldsInterface;

public class CommunicationController {

	static McDonaldsInterface instance = null;

	public static McDonaldsInterface getReference() throws Exception {
		if (instance == null) {
			synchronized (CommunicationController.class) {
				if (instance == null) {
					instance = new CommunicationServiceImpl();
				}
			}
		}

		return instance;
	}
}
