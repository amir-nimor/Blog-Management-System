package ir.maktabsharif.command;

import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dto.post.PostRequestDto;
import ir.maktabsharif.dto.post.PostResponseDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.repository.user.UserRepositoryImpl;

public class PostCommand implements Commandable<PostDao, PostRequestDto, PostResponseDto> {

    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    @Override
    public PostDao DtoRequestToDao(PostRequestDto postRequestDto) {
        PostDao postDao = PostDao.builder()
                .userDao(userRepository.read(postRequestDto.getUserId()))
                .description(postRequestDto.getDescription())
                .title(postRequestDto.getTitle())
                .build();
        postDao.setId(postRequestDto.getId());
        return postDao;
    }

    @Override
    public PostResponseDto DaoToDtoResponse(PostDao postDao) {
        PostResponseDto postResponseDto = PostResponseDto.builder()
                .id(postDao.getId())
                .userId(postDao.getUserDao().getId())
                .description(postDao.getDescription())
                .title(postDao.getTitle())
                .build();
        return postResponseDto;
    }
}
