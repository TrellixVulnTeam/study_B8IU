package myspring.aop.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result;
		
		String signatureString= proceedingJoinPoint.getSignature().toShortString();
		System.out.println(signatureString + " 시작");
		
		long start = System.currentTimeMillis();
		
		try {
			result = proceedingJoinPoint.proceed();
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + (finish - start) + " ms");
		}
		return result;
	}
}
