#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月14日
 */
package ${package}.web.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ${package}.web.controller.MainController;

/**自定义的异常处理Handler
 * @author wangzhigang
 * @time 2014年10月14日
 */
public class ExceptionHandler implements HandlerExceptionResolver {
	
	/**
	 * 日志
	 */
	static final Logger log = LogManager.getLogger(ExceptionHandler.class.getName());


	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerExceptionResolver${symbol_pound}resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,HttpServletResponse response, Object arg2, Exception ex) {
		
		
		Map<String, Object> model = new HashMap<String, Object>();  
        model.put("exception", ex);
        
        //进行定制化异常处理
        //1.进行日志记录
        log.warn(ex.getMessage(),ex);
        //2.打印stack,便于开发定位
        ex.printStackTrace();
        
        //3.导向不同的异常页面进行展示
        /* 根据不同错误转向不同页面  
        if(ex instanceof BusinessException) {  
            return new ModelAndView("error-business", model);  
        }else if(ex instanceof ParameterException) {  
            return new ModelAndView("error-parameter", model);  
        } else {  
            return new ModelAndView("error", model);  
        }  
        */
        
        //暂时统一到一个错误页面显示
        return new ModelAndView("error", model);  
	}

}
