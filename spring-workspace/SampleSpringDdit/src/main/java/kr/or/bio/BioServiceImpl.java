package kr.or.bio;

public class BioServiceImpl implements BioService {
	private StringBuffer stringBuffer = new StringBuffer();

	@Override
	public void print(String message) {
		stringBuffer.append(message);
	}

	@Override
	public String toString() {
		return stringBuffer.toString();
	}
}
