package kr.or.bio;

public class ConsolePrinter implements BioService {
	@Override
	public void print(String message) {
		System.out.println(message);
	}
}
