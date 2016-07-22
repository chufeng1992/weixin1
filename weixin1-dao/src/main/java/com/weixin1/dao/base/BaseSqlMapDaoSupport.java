package com.weixin1.dao.base;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.util.CollectionUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.weixin1.dao.entity.key.IPrimaryKey;

@Repository(IBaseSqlMapDao.BEAN_ID)
public class BaseSqlMapDaoSupport implements IBaseSqlMapDao
{
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查询实体对象
     *
     * @param stmt SqlMap句柄
     * @param param 查询参数对象
     * @return 实体对象
     */
    public <T> T queryForObject(String stmt, Object param)
    {
        return this.sqlSessionTemplate.selectOne(stmt, param);
    }

    /**
     * 查询实体对象
     *
     * @param stmt SqlMap句柄
     * @param param 查询参数对象
     * @return 实体对象集合
     */
    public <T> List<T> queryForList(String stmt, Object param)
    {
        return this.sqlSessionTemplate.selectList(stmt, param);
    }

    /**
     * 查询实体对象
     *
     * @param stmt SqlMap句柄
     * @param param 查询参数对象
     * @param key MapKey
     * @param <K> Key类型
     * @param <V> Value类型
     * @return 实体对象集合
     */
    public <K, V> Map<K, V> queryForMap(String stmt, Object param, String key)
    {
        return this.sqlSessionTemplate.selectMap(stmt, param, key);
    }

    /**
     * 保存实体对象
     *
     * @param stmt SqlMap句柄
     * @param entity 实体对象
     * @return 记录更新数
     */
    public <T> int saveEntity(String stmt, T entity)
    {
        if (entity instanceof IPrimaryKey)
        {
            IPrimaryKey instance = (IPrimaryKey)entity;
            return this.sqlSessionTemplate.insert(stmt, instance);
        }
        return this.sqlSessionTemplate.insert(stmt, entity);
    }

    /**
     * 批量保存实体对象
     *
     * @param stmt SqlMap句柄
     * @param entities 实体对象集合
     * @return 记录更新数
     */
    public <T> int saveEntityBatch(String stmt, Collection<T> entities)
    {
        return this.sqlSessionTemplate.insert(stmt, entities);
    }

    /**
     * 更新实体对象
     *
     * @param stmt SqlMap句柄
     * @param entity 实体对象
     * @return 记录更新数
     */
    public <T> int updateEntity(String stmt, T entity)
    {
        return this.sqlSessionTemplate.update(stmt, entity);
    }

    /**
     * 批量更新实体对象
     *
     * @param stmt SqlMap句柄
     * @param entities 实体对象集合
     * @return 记录更新数
     */
    public <T> void updateEntityBatch(String stmt, Collection<T> entities)
    {
        SqlSession sqlSession = null;
        try
        {
            if (!CollectionUtils.isEmpty(entities))
            {
                SqlSessionFactory factory = this.sqlSessionTemplate.getSqlSessionFactory();

                // 批量执行器
                sqlSession = (null == factory ? null : factory.openSession(ExecutorType.BATCH, false));
                for (Iterator<T> iterator = entities.iterator(); (iterator.hasNext() && null != sqlSession);)
                {
                    sqlSession.update(stmt, iterator.next());
                }
                sqlSession.flushStatements();
                sqlSession.commit();
                sqlSession.clearCache();
            }
        }
        finally
        {
            if (null != sqlSession)
            {
                sqlSession.close();
            }
        }
    }

    /**
     * 删除实体对象
     *
     * @param stmt SqlMap句柄
     * @param param 参数对象
     * @return 记录更新数
     */
    public int deleteEntity(String stmt, Object param)
    {
        return this.sqlSessionTemplate.delete(stmt, param);
    }

    /**
     * 批量删除实体对象
     *
     * @param stmt SqlMap句柄
     * @param params 参数对象集合
     * @return 记录更新数
     */
    public int deleteEntityBatch(String stmt, Collection<Object> params)
    {
        return this.sqlSessionTemplate.delete(stmt, params);
    }
}