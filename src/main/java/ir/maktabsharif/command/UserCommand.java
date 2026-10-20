package ir.maktabsharif.command;

import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.repository.post.PostRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class UserCommand implements Commandable<UserDao, UserRequestDto, UserResponseDto>{

    private PostRepositoryImpl postRepository = new PostRepositoryImpl();

    @Override
    public UserDao DtoRequestToDao(UserRequestDto userRequestDto) {

        List<Long> postId = userRequestDto.getPostId();
        List<PostDao> postDaos = new ArrayList<>();

        if (postId!= null){
            for (Long i:postId){
                postDaos.add(postRepository.read(i));
            }
        }


        UserDao userDao = UserDao.builder()
                .phoneNumber(userRequestDto.getPhonNumber())
                .username(userRequestDto.getUsername())
                .password(userRequestDto.getPassword())
                .fullName(userRequestDto.getFullName())
                .postDaoList(postDaos)
                .build();
        return userDao;


    }

    @Override
    public UserResponseDto DaoToDtoResponse(UserDao userDao) {
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .username(userDao.getUsername())
                .password(userDao.getPassword())
                .id(userDao.getId())
                .phonNumber(userDao.getPhoneNumber())
                .fullName(userDao.getFullName())
                .postId(userDao.getPostDaoList().stream().map(p -> p.getId()).toList())
                .build();
        return userResponseDto;
    }
}
