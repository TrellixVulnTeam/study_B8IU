package kr.or.bio;

import java.util.List;

import lombok.Data;

@Data
public class BioVo {
	private String receiptNo;
	private String receiptName;
	private BioService bioService;
	private List<String> bioList;
	
	public String sayHello() {
		return "bio " + receiptName;
	}
	
	public void print() {
		bioService.print(sayHello());
	}
}
