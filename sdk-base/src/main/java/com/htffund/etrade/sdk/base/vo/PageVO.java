package com.htffund.etrade.sdk.base.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.htffund.etrade.sdk.base.paginator.domain.Order;
import com.htffund.etrade.sdk.base.paginator.domain.PageBounds;

/**分页查询辅助对象
 * @author wangzhigang
 * @time 2014年10月13日
 */
public class PageVO {

    public static final String CHINESE_PINYIN = "nlssort(? ,'NLS_SORT=SCHINESE_PINYIN_M')";

    /**
     * 页码
     */
    private int page = 1;
    /**
     * 每页记录数
     */
    private int limit = 10;
    /**
     * 排序语句
     */
    private String sort;

    /**
     * 排序字段及方向
     */
    private Map<String,String> orderExprs = new HashMap<String, String>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void addOrderExpr(String property, String expr){
        this.orderExprs.put(property,expr);
    }

    /**转换数据限定条件
     * @return pageBounds
     */
    public PageBounds toPageBounds(){
        List<Order> orders = Order.formString(sort);
        for (int i = 0; i < orders.size(); i++) {
            Order order =  orders.get(i);
            if(orderExprs.get(order.getProperty()) != null){
                orders.set(i, new Order(
                        order.getProperty(),
                        order.getDirection(),
                        orderExprs.get(order.getProperty()))
                );
            }
        }
        return new PageBounds(page, limit, orders);
    }
   
}
