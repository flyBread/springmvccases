package org.springframework.mvc;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class BaseController {

	/**
	 * js返回
	 */
	public static final MediaType TEXT_JAVASCRIPT = new MediaType("text",
			"plain", Charset.forName("UTF-8"));

	/**
	 * 指定返回头内容类型
	 * 
	 * @return
	 */
	protected HttpHeaders getResponseHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(TEXT_JAVASCRIPT);
		return responseHeaders;
	}
}
