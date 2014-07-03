package main.java.rmi;

import main.java.McDonaldsInterface;

public class McDonaldsImplRmi implements McDonaldsRmiInterface {

	McDonaldsInterface instance;

	public McDonaldsImplRmi(McDonaldsInterface instance) {
		this.instance = instance;
	}

	public void produceMcChicken() {
		instance.produceMcChicken();
	}

	public void consumeMcChicken() {
		instance.consumeMcChicken();
	}

	public int getQtdMcChicken() {
		return instance.getQtdMcChicken();
	}

	public int getQtdMcChickenProducers() {
		return instance.getQtdMcChickenProducers();
	}

	public int getQtdMcChickenConsumers() {
		return instance.getQtdMcChickenConsumers();
	}

	public void produceMcFish() {
		instance.produceMcFish();
	}

	public void consumeMcFish() {
		instance.consumeMcFish();
	}

	public int getQtdMcFish() {
		return instance.getQtdMcFish();
	}

	public int getQtdMcFishProducers() {
		return instance.getQtdMcFishProducers();
	}

	public int getQtdMcFishConsumers() {
		return instance.getQtdMcFishConsumers();
	}

	public void produceBigMac() {
		instance.produceBigMac();
	}

	public void consumeBigMac() {
		instance.consumeBigMac();
	}

	public int getQtdBigMac() {
		return instance.getQtdBigMac();
	}

	public int getQtdBigMacProducers() {
		return instance.getQtdBigMacProducers();
	}

	public int getQtdBigMacConsumers() {
		return instance.getQtdBigMacConsumers();
	}
}
