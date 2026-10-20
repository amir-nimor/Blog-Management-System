package ir.maktabsharif.repository.post;

import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class PostRepositoryImpl extends BaseRepositoryImpl<PostDao, Long> implements PostRepository {

    public PostRepositoryImpl() {
        super(PostDao.class);
    }

    @Override
    public List<PostDao> userPosts(Integer id) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("from PostDao p where p.userDao.id = ?1", PostDao.class)
                        .setParameter(1, id)
                        .getResultList();
            });
        } catch (HibernateException e) {
            throw new RepositoryException("your user post not founded");
        }
    }

    @Override
    protected void updateEntity(PostDao dbEntity, PostDao newEntity) {
        dbEntity.setId(newEntity.getId());
        dbEntity.setDescription(newEntity.getDescription());
        dbEntity.setUserDao(newEntity.getUserDao());
        dbEntity.setTitle(newEntity.getTitle());
    }
}
