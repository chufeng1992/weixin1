/**
 * 文件名: SortCond.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 创建人: Jeff
 * 创建时间: 2015年12月11日
 */
package com.weixin1.common.base.entity;

/**
 * <p>功能描述：排序类</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author Jeff
 * @version 1.0 2015年12月11日
 */
public class SortCond {
    /**
     * 排序类型枚举
     */
    public enum Order {
        ASC, DESC
    }

    /**
     * 排序类型
     */
    private String column;

    /**
     * 排序类型
     */
    private Order order;

    public SortCond(String column) {
        this(column, Order.DESC);
    }

    public SortCond(String column, Order order) {
        this.column = column;
        this.order = order;
    }

    public String getColumn() {
        return column;
    }

    public Order getOrder() {
        return order;
    }
}
