package ir.maktabsharif.repository;

import ir.maktabsharif.dao.BaseModel;
import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Number> implements BaseRepository<T, ID> {

    private Class<T> entity;

    public BaseRepositoryImpl(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public T create(T t) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.persist(t);
                return t;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("your operation create is faield => " + e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.merge(t);
                return t;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("your operation update is faield => " + e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return HibernateUtil.InTxReturn(em -> {

            });
        } catch (HibernateException e) {
            throw new RepositoryException("your operation create is faield => " + e.getMessage());
        }
    }

    @Override
    public T read(ID id) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return List.of();
    }
}
