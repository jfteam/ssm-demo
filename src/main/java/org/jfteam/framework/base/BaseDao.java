package org.jfteam.framework.base;

import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2018/12/11 12:13
 */
public interface BaseDao<T, ID extends Serializable> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> save(Iterable<S> entities);

    T findOne(ID id);

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
