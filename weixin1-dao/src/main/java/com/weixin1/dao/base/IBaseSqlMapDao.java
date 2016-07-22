package com.weixin1.dao.base;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IBaseSqlMapDao {
	/**
	 * Bean ID
	 */
	public static final String BEAN_ID = "contextBaseSqlMapDao";

	/**
	 * 查询实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param param
	 *            查询参数对象
	 * @param <T>
	 *            实体对象类型
	 * @return 实体对象
	 */
	public <T> T queryForObject(String stmt, Object param);

	/**
	 * 查询实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param param
	 *            查询参数对象
	 * @param <T>
	 *            实体对象类型
	 * @return 实体对象集合
	 */
	public <T> List<T> queryForList(String stmt, Object param);

	/**
	 * 查询实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param param
	 *            查询参数对象
	 * @param key
	 *            MapKey
	 * @param <K>
	 *            Key类型
	 * @param <V>
	 *            Value类型
	 * @return 实体对象集合
	 */
	public <K, V> Map<K, V> queryForMap(String stmt, Object param, String key);

	/**
	 * 保存实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param entity
	 *            实体对象
	 * @param <T>
	 *            实体对象类型
	 * @return 记录更新数
	 */
	public <T> int saveEntity(String stmt, T entity);

	/**
	 * 批量保存实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param entities
	 *            实体对象集合
	 * @param <T>
	 *            实体对象类型
	 * @return 记录更新数
	 */
	public <T> int saveEntityBatch(String stmt, Collection<T> entities);

	/**
	 * 更新实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param entity
	 *            实体对象
	 * @param <T>
	 *            实体对象类型
	 * @return 记录更新数
	 */
	public <T> int updateEntity(String stmt, T entity);

	/**
	 * 批量更新实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param entities
	 *            实体对象集合
	 * @param <T>
	 *            实体对象类型
	 * @return 记录更新数
	 */
	public <T> void updateEntityBatch(String stmt, Collection<T> entities);

	/**
	 * 删除实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param param
	 *            参数对象
	 * @return 记录更新数
	 */
	public int deleteEntity(String stmt, Object param);

	/**
	 * 批量删除实体对象
	 * 
	 * @param stmt
	 *            SqlMap句柄
	 * @param params
	 *            参数对象集合
	 * @return 记录更新数
	 */
	public int deleteEntityBatch(String stmt, Collection<Object> params);
}