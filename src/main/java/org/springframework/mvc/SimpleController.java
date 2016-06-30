
package org.springframework.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.JavaBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleController extends BaseController {

	protected final static Logger logger = LoggerFactory.getLogger(BaseAuthInterceptor.class);

	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "hello,simple";
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
	
	@RequestMapping(value="html", method=RequestMethod.GET)
	public String prepare(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "views/html";
	}
	
	@RequestMapping(value="/viewName", method=RequestMethod.GET)
	public void usingRequestToViewNameTranslator(Model model) {
		//可以直接在JSP的使用
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
	}

	@RequestMapping(value="pathVariables/{foo}/{fruit}", method=RequestMethod.GET)
	public String pathVars(@PathVariable String foo/*, @PathVariable String fruit*/) {
		// No need to add @PathVariables "foo" and "fruit" to the model
		// They will be merged in the model before rendering
		logger.info("foo:{},fruit:{}",foo/*,fruit*/);
		return "views/html";
	}
	
	/***
	 * 对于同一个URL对应的只能是同一个方法
	 * Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'simpleController' method 
	 * public java.lang.String org.springframework.mvc.SimpleController.pathVars(java.lang.String,java.lang.String)
	 * to {[/pathVariables/{foo}/{fruit}],methods=[GET]}: There is already 'simpleController' bean method、
	 * public java.lang.String org.springframework.mvc.SimpleController.pathVars(java.lang.String) mapped.
	 * 
	 * */
	/*@RequestMapping(value="pathVariables/{foo}/{fruit}", method=RequestMethod.GET)
	public String pathVars(@PathVariable String foo, @PathVariable String fruit) {
		// No need to add @PathVariables "foo" and "fruit" to the model
		// They will be merged in the model before rendering
		logger.info("foo:{},fruit:{}",foo,fruit);
		return "views/html";
	}*/

	@RequestMapping(value="dataBinding/{foo}/{fruit}", method=RequestMethod.GET)
	public String dataBinding(@Valid JavaBean javaBean, Model model) {
		// JavaBean "foo" and "fruit" properties populated from URI variables 
		return "views/dataBinding";
	}

}
