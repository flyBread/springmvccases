
package org.springframework.mvc;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController extends BaseController {

	protected final static Logger logger = LoggerFactory.getLogger(BaseAuthInterceptor.class);

	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}

	@RequestMapping(value = "/hello")
	@ResponseBody
	public ResponseEntity<String> getHelloTest(HttpServletRequest httpServletRequest) {
		logger.info("测试程序调入：{}", httpServletRequest.getRequestURI());
		ResponseEntity<String> result = new ResponseEntity<String>("helloworld,test restserver is alive!",
				getResponseHeaders(), HttpStatus.OK);
		return result;
	}

	@RequestMapping(value = "/simple/revisited", method = RequestMethod.GET, headers = "Accept=text/plain")
	public @ResponseBody String simpleRevisit() {
		return "Hello world revisited!";
	}

}
