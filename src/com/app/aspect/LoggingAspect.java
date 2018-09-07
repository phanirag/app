package com.app.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {

	private  Logger log=Logger.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(public * com.app..*.*(..))")
	public void p1(){}
	
	@Around("p1()")
	public Object countTime(ProceedingJoinPoint jp){
		Object ob=null;
		StopWatch watch=new StopWatch(jp.getTarget().getClass().getName());
		try {
			watch.start(jp.getSignature().getName());
			ob=jp.proceed();
			watch.stop();
			
			log.debug(watch.prettyPrint());
			
		} catch (Throwable e) {
			e.printStackTrace();
			log.error(e);
		}
		
		log.info("Execution of method:"+jp.getSignature().getName()+" is done..");
		
		return ob;
	}
	
	@AfterThrowing(pointcut="p1()",throwing="th")
	public void getProblems(Throwable th){
		log.fatal(th);
	}
	
}
