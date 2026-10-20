package ir.maktabsharif.repository.user;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

public class UserRepositoryImpl extends BaseRepositoryImpl<UserDao, Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserDao.class);
    }

    @Override
    public UserDao findByUsername(String username) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("from UserDao u where u.username = ?1", UserDao.class)
                        .setParameter(1, username)
                        .getSingleResult();
            });
        } catch (HibernateException e) {
            throw new RepositoryException("your operation is failed");
        }
    }

    @Override
    protected void updateEntity(UserDao dbEntity, UserDao newEntity) {
        dbEntity.setId(newEntity.getId());
        dbEntity.setPassword(newEntity.getPassword());
        dbEntity.setFullName(newEntity.getFullName());
        dbEntity.setPostDaoList(newEntity.getPostDaoList());
        dbEntity.setPhoneNumber(newEntity.getPhoneNumber());
    }
}
