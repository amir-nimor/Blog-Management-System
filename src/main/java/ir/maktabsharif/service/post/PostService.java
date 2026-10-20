package ir.maktabsharif.service.post;

import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.service.base.BaseService;

import java.util.List;

public interface PostService extends BaseService<PostRequestDto, PostResponseDto,Long> {

    List<PostResponseDto>userPosts(Integer id);

}
