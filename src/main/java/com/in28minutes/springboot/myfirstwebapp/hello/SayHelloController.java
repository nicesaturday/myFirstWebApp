package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
//이게 있어야 밑에 메소드들이 Bean이라고 인식함. (url 컨트롤러)
public class SayHelloController {
	
	
	@RequestMapping("say-hello")
	//url로 진입했을때 이 메소드를 발동.
	@ResponseBody
	//문자열 그대로 보여주기
	public String sayHello() {
		return "Hello! What are you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML Page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>");
		sb.append("My first html page with body html");
		sb.append("</h1>");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	
	
	@RequestMapping("say-hello-jsp")
	//ResponseBody를 쓰지 않으면 자동으로 jsp를 찾는것 같다.
	public String sayHelloJsp() {
		return "sayHello";
	}
}
