package org.marouane.IDao;

import java.util.List;

public interface IDao<E> {
    boolean create(E e);

    boolean update(E e);

    boolean delete(E e);

    E findById(Long id);

    List<E> findAll();
}
