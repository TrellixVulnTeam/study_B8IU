package chapter11;

import java.util.HashMap;
import java.util.Map;

public class Thermometer {
	//[위치, 온도] 정보를 보관할 Map 타입의 필드를 정의함
	private Map<String, Double> locationCelsiusMap = 
		new HashMap<String, Double>();
	
	//[위치, 온도] 정보를 추가함.
	public void setCelsius(String location, Double value) {
		locationCelsiusMap.put(location, value);
	}
	//location 파라미터 값에 해당하는 위치의 섭씨온도를 구함
	public Double getCelsius(String location) {
		return locationCelsiusMap.get(location);
	}
	//location 파라미터 값에 해당하는 위치의 화씨온도를 구함
	public Double getFahrenheit(String location) {
		Double celsius = getCelsius(location);
		
		if(celsius==null) {
			return null;
		}
		
		return celsius.doubleValue() * 1.8 + 32.0;
	}
	
	public String getInfo() {
		return "온도계 변환기 1.1";
	}
	
}
