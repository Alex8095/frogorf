package com.frogorf.web.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ControllerAspect {
	@Pointcut("within(@org.springframework.stereotype.Controller *)")
	public void controller() {
	}

	@Pointcut("execution(* *(..))")
	public void method() {
	}

	@Before("controller() && method()")
	public void doAccessCheck(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget());
		System.out.println(joinPoint.getArgs());
		System.out.println(joinPoint.getKind());
		System.out.println(joinPoint.getSourceLocation());
		System.out.println(joinPoint.getSourceLocation());
		System.out.println(joinPoint.getSignature());
	}

	private String niceName(JoinPoint joinPoint) {
		return joinPoint.getTarget().getClass() + "#" + joinPoint.getSignature().getName() + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
	}
}
