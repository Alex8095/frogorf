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
		System.out.println(joinPointNiceName(joinPoint));
	}

	private String joinPointNiceName(JoinPoint joinPoint) {
		return joinPoint.getTarget().getClass() + "#" + joinPoint.getSignature().getName() + "\n\targs:" + Arrays.toString(joinPoint.getArgs());
	}
}
