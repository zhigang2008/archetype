#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
	static final Logger log = LogManager.getLogger(MainController.class.getName());
	public MainController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = "/index")
	public String homePage(){
		log.debug("home page show");
		return "index";
	}
	@RequestMapping(value = "/error")
	public String errorPage(Exception ex){
		log.debug("有错误发生");
		log.error(ex.getMessage(),ex);
		ex.printStackTrace();
		return "error";
	}

	@RequestMapping(value = "/test/page1.htm")
	public String test1(){
		log.debug("into test page1");
		return "test/page1";
	}
	
	@RequestMapping(value = "/test/page2.htm")
	public String test2(){
		log.debug("into test page2");
		return "test/page2";
	}
}
