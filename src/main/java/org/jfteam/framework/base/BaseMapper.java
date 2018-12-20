package org.jfteam.framework.base;

import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/11 12:13
 */
public interface BaseMapper<T, ID extends Serializable> {
    /**
     * 插入实体
     *
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> int insert(S entity);

    <S extends T> int insert(Iterable<S> entities);

    T findOne(ID id);

    <S extends T> S findOne(S entity);

    boolean exists(ID id);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);

    long count();

    void delete(ID id);

    void delete(T entity);

    void delete(Iterable<? extends T> entities);

    void deleteAll();

    Iterable<T> findAll(Sort sort);
}
