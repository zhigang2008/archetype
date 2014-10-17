/**
 * wangzhigang
 * 2014年10月13日
 */
package com.htffund.etrade.sdk.base.vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigInteger;

/**
 * @author wangzhigang
 * @time 2014年10月13日
 */
public class BaseVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1212527708840332272L;

    /**获取查询参数的拼接字符串
     * @return 拼接的查询参数
     */
    public String getQueryParams(){
    	Field[] fields = getClass().getDeclaredFields(); 
    	String fieldName=null;
    	
    	String mName=null;
    	String fieldType=null;
    	Method m=null;
    	StringBuffer params=new StringBuffer();
    	
    	for(Field field:fields){
    		fieldName = field.getName();    //获取属性的名字
    		mName = fieldName.substring(0,1).toUpperCase()+fieldName.substring(1); //将属性的首字符大写，方便构造get，set方法
            fieldType = field.getGenericType().toString();    //获取属性的类型
            try {
				m = this.getClass().getMethod("get"+mName);
                if(fieldType.equals("class java.lang.String")){
					String value=(String)m.invoke(this);
					if(value!=null){
						params.append(fieldName).append("=").append(value).append("&");
					}
				}else if(fieldType.equals("class java.lang.Integer")||fieldType.equals("int")){
					Integer value=(Integer)m.invoke(this);
					if(value!=null&&value!=0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.lang.Long")||fieldType.equals("long")){
					Long value=(Long)m.invoke(this);
					if(value!=null&&value!=0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.lang.Short")||fieldType.equals("short")){
					Short value=(Short)m.invoke(this);
					if(value!=null&&value!=0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.lang.Byte")||fieldType.equals("byte")){
					Byte value=(Byte)m.invoke(this);
					if(value!=null&&value!=0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.lang.Double")||fieldType.equals("double")){
					Double value=(Double)m.invoke(this);
					if(value!=null&&value!=0.0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.lang.Float")||fieldType.equals("float")){
					Float value=(Float)m.invoke(this);
					if(value!=null&&value!=0.0){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}else if(fieldType.equals("class java.util.BigInteger")){
					BigInteger value=(BigInteger)m.invoke(this);
					if(value!=null){
						params.append(fieldName).append("=").append(value.toString()).append("&");
					}
					
				}//其它类型忽略

			} catch (Exception e) {
				//ignore this method
			} 
            
            
    	}
    	String paramStr=params.toString();
    	if(paramStr!=null &&paramStr.endsWith("&")){
    		paramStr=paramStr.substring(0,paramStr.length()-1);
    	}
    	return paramStr;
    }
}
