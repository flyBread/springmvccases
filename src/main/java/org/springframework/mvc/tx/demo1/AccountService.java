package org.springframework.mvc.tx.demo1;

public interface AccountService {

	public void transfer(String out,String in,Double money);
}
