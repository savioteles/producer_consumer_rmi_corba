package main.java;

public class McDonalds implements McDonaldsInterface {

	private static McDonaldsQueue<Character> mcChickenQueue;
	private static McDonaldsQueue<Character> mcFishQueue;
	private static McDonaldsQueue<Character> bigMacQueue;

	public McDonalds() {
		mcChickenQueue = new McDonaldsQueue<Character>();
		mcFishQueue = new McDonaldsQueue<Character>();
		bigMacQueue = new McDonaldsQueue<Character>();
	}

	public void produceMcChicken() {
		mcChickenQueue.insert(new Character('c'));
	}

	public void consumeMcChicken() {
		mcChickenQueue.remove();
	}

	public int getQtdMcChicken() {
		return mcChickenQueue.size();
	}

	public void produceMcFish() {
		mcFishQueue.insert(new Character('f'));
	}

	public void consumeMcFish() {
		mcFishQueue.remove();
	}

	public int getQtdMcFish() {
		return mcFishQueue.size();
	}

	public void produceBigMac() {
		bigMacQueue.insert(new Character('b'));
	}

	public void consumeBigMac() {
		bigMacQueue.remove();
	}

	public int getQtdMcBigMac() {
		return bigMacQueue.size();
	}
}
