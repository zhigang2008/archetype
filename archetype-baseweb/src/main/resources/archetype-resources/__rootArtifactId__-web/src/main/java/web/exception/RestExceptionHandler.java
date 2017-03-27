#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * wangzhigang
 * 2014年10月14日
 */
package ${package}.web.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ${package}.model.BackResult;

/**统一的Restful异常处理实现类
 * @author wangzhigang
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	
	/**
	 * 覆写原来的方法，实现自定义异常信息
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
			Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		 
		    if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
		        request.setAttribute("javax.servlet.error.exception", ex, 0);
		    }
		    BackResult result =new BackResult();
		    //TODO 根据系统调整返回代码
		    result.setErrCode(String.ValueOf(status.value()));
            result.setErrMsg(ex.getMessage());
            
		   return new ResponseEntity<Object>(result, headers, status);
	}

	

}
