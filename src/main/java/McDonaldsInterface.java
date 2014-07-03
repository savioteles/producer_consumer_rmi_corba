package main.java;

import java.security.SecureRandom;
import java.util.Random;

public interface McDonaldsInterface {

	static final String MC_DONALDS = "McDonalds";
	Random r = new SecureRandom();
	
	public enum Option{
		MC_CHICKEN, MC_FISH, BIG_MAC;
		
		 public static Option getRandom() {
	        return values()[(int) (r.nextInt(values().length))];
	    }
	}
	
	public void produceMcChicken();
	public void consumeMcChicken();
	public int getQtdMcChicken();
	int getQtdMcChickenConsumers();
	int getQtdMcChickenProducers();
	
	public void produceMcFish();
	public void consumeMcFish();
	public int getQtdMcFish();
	int getQtdMcFishConsumers();
	int getQtdMcFishProducers();
	
	public void produceBigMac();
	public void consumeBigMac();
	public int getQtdBigMac();
	int getQtdBigMacConsumers();
	int getQtdBigMacProducers();
}
