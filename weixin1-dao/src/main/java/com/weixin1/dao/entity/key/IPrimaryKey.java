/**
 * 文件名: IPrimaryKey.java
 * 版    权: Copyright © 2013 - 2015 ThinkJF, Inc. All Rights Reserved
 * 描    述: <描述>
 * 修改人: WeiQiang.Fan
 * 修改时间: 2015年11月10日
 * 跟踪单号: <跟踪单号>
 * 修改单号: <修改单号>
 * 修改内容: <修改内容>
 */
package com.weixin1.dao.entity.key;

import java.io.Serializable;

/**
 * <p>功能描述：</p>
 * <p>Company: 上海丞风智能科技有限公司</p>
 * @author WeiQiang.Fan
 * @version 1.0 2015年11月10日
 */
public interface IPrimaryKey extends Serializable
{
    /**
     * 设置主键
     */
    public void setPrimaryKey(Serializable id);
}