package day210202;

public class Human extends Animal {
	public int power_lang = 1;

	public void learn_lang() {
		power_lang++;
	}

	public void gawe(int power) {
		power_lang += power;
	}
}
