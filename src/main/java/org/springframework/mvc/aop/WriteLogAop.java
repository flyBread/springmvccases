package org.springframework.mvc.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author zhailz
 *
 * 时间：2016年6月30日 ### 下午1:58:42
 */
public class WriteLogAop implements MethodInterceptor {
	  public static final Logger logger = LoggerFactory.getLogger(WriteLogAop.class);

	  public Object invoke(MethodInvocation arg0) throws Throwable {
	    String method = arg0.getMethod().toString();
	    Object[] arguments = arg0.getArguments();
	    StringBuffer paramValue = new StringBuffer("");
	    if (arguments != null && arguments.length > 0) for (int i = 0; i < arguments.length; i++) {
	      paramValue.append(arguments[i] + "##");
	    }
	    long s = System.currentTimeMillis();
	    Object result = arg0.proceed();
	    long e = System.currentTimeMillis();
	    logger.info(method +" paramValue = " + paramValue.toString() + " use time = " + (e - s) + "ms");
	    return result;
	  }

	}