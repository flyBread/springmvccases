package org.springframework.mvc.aop;

import org.springframework.stereotype.Repository;

/**
 * @author zhailz
 *
 *         时间：2016年6月30日 ### 下午2:03:26
 */
@Repository("methodExcutor")
public class MethodExcutor {

	public String getValue(String hello) {

		try {
			System.out.println(hello);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hello + "增加内容";
	}
}
