package com.htffund.etrade.sdk.base.paginator.dialect;

import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;
import org.apache.ibatis.mapping.MappedStatement;

public class SybaseDialect extends Dialect{

    public SybaseDialect(MappedStatement mappedStatement, Object parameterObject, PageBounds pageBounds) {
        super(mappedStatement, parameterObject, pageBounds);
    }


    protected String getLimitString(String sql, String offsetName,int offset, String limitName, int limit) {
		throw new UnsupportedOperationException( "paged queries not supported" );
	}

}
