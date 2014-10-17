/**
 * wangzhigang
 * 2014年10月9日
 */
package com.htffund.etrade.sdk.common.log4jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;

import net.sf.log4jdbc.log.SpyLogFactory;
import net.sf.log4jdbc.sql.jdbcapi.ConnectionSpy;
import net.sf.log4jdbc.sql.jdbcapi.DriverSpy;
import net.sf.log4jdbc.sql.rdbmsspecifics.RdbmsSpecifics;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**Log4jdbc 拦截器
 * @author wangzhigang
 * @time 2014年10月9日
 */
public class DataSourceSpyInterceptor implements MethodInterceptor {

	/**
	 * log4jdbc的db信息对象
	 */
	private RdbmsSpecifics rdbmsSpecifics = null;  

    /**
     * 反射方法
     */
    private static Method method = null;

    /**重新构造db链接对象
     * @param conn 连接池
     * @return
     */
    private RdbmsSpecifics getRdbmsSpecifics(Connection conn) {

        if(rdbmsSpecifics == null) {
            try {
                if (null ==  method) {
                    method = DriverSpy.class.getDeclaredMethod("getRdbmsSpecifics", Connection.class);
                }
                method.setAccessible(true);
                rdbmsSpecifics = (RdbmsSpecifics) method.invoke(null, conn);
                method.setAccessible(false);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return rdbmsSpecifics;
    }  

    /* (non-Javadoc)
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
         Object result = invocation.proceed();  
            if(SpyLogFactory.getSpyLogDelegator().isJdbcLoggingEnabled()) {  
                if(result instanceof Connection) {
                    Connection conn = (Connection)result;  
                    return new ConnectionSpy(conn,getRdbmsSpecifics(conn),SpyLogFactory.getSpyLogDelegator());  
                }
            }
            return result;
    }
}
