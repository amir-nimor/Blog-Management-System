package ir.maktabsharif.service.user;

import ir.maktabsharif.command.PostCommand;
import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.exception.ValidationExceptio;
import ir.maktabsharif.repository.post.PostRepository;
import ir.maktabsharif.repository.post.PostRepositoryImpl;
import ir.maktabsharif.service.post.PostService;
import ir.maktabsharif.service.base.BaseServiceImpl;

public class PostServiceImpl extends BaseServiceImpl<PostDao,
        PostRequestDto,
        PostResponseDto,
        Long,
        PostRepository,
        PostCommand> implements PostService {

    public PostServiceImpl() {
        super(new PostRepositoryImpl(), new PostCommand());
    }

    @Override
    protected void validation(PostRequestDto postRequestDto) {
        if (postRequestDto.id() == null) throw new ValidationExceptio("your user id is empty");
        if (postRequestDto.title().isBlank()) throw new ValidationExceptio("your title is empty");
    }
}
