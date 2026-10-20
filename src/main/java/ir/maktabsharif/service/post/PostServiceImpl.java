package ir.maktabsharif.service.post;

import ir.maktabsharif.command.PostCommand;
import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.exception.BuisenesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationExceptio;
import ir.maktabsharif.repository.post.PostRepository;
import ir.maktabsharif.repository.post.PostRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.base.BaseServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

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
        if (postRequestDto.getUserId() == null) throw new ValidationExceptio("your user id is empty");
        if (postRequestDto.getTitle().isBlank()) throw new ValidationExceptio("your title is empty");
    }

    private UserRepositoryImpl userService = new UserRepositoryImpl();
    private PostCommand postCommand = new PostCommand();


    @Override
    public List<PostResponseDto> userPosts(Integer id) {
        try {
            List<PostDao> userDaos = new PostRepositoryImpl().userPosts(id);
            List<PostResponseDto> postResponseDtoList = new ArrayList<>();
            for (PostDao u : userDaos) {
                postResponseDtoList.add(new PostCommand().DaoToDtoResponse(u));
            }
            return postResponseDtoList;
        } catch (RepositoryException e) {
            throw new BuisenesException("your post user find is failed => " + e.getMessage());
        }
    }
}
