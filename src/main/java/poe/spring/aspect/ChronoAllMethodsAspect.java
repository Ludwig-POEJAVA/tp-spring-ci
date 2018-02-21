package poe.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ChronoAllMethodsAspect
{
	@Around("@annotation(poe.spring.annotation.ChronoAllMethods)")
	@Pointcut("[method designator]execution(* poe.spring.service.*.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();
		long executionTime = System.currentTimeMillis() - start;
		System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
		return proceed;
	}
}
