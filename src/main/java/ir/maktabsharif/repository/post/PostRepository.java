package ir.maktabsharif.repository.post;

import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.repository.base.BaseRepository;

import java.util.List;

public interface PostRepository extends BaseRepository<PostDao,Long> {

    List<PostDao> userPosts(Integer id);
}
