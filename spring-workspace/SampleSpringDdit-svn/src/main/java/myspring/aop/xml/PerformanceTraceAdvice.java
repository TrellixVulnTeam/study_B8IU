package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		//타겟 메서드의 signature 정보
		//.getSignature() : 메소드 정보 가져옴
		//.toShortString() : 가져온 메소드 정보를 문자열로 출력
		String signatureString = joinPoint.getSignature().toShortString();
		//타겟의 메서드가 호출되기 전의 시간
		System.out.println(signatureString + " 시작");
		//타겟의 메서드가 호출되기 전의 시간
		long start = System.currentTimeMillis();
		
		try {
			//타겟의 메서드 호출(순위에서 밀려난 본 메서드를 실행)*******
			Object result = joinPoint.proceed();
			return result;
		}finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
				 (finish - start) + " ms");
		}
	}
}
