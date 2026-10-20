package ir.maktabsharif.service.user;

import ir.maktabsharif.command.UserCommand;
import ir.maktabsharif.dao.PostDao;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.exception.BuisenesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationExceptio;
import ir.maktabsharif.repository.post.PostRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.base.BaseServiceImpl;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl<UserDao,
        UserRequestDto,
        UserResponseDto,
        Integer,
        UserRepository,
        UserCommand> implements UserService {

    private PostRepositoryImpl postRepository = new PostRepositoryImpl();
    private UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private UserCommand userCommand = new UserCommand();

    public UserServiceImpl() {
        super(new UserRepositoryImpl(), new UserCommand());
    }


    @Override
    protected void validation(UserRequestDto userRequestDto) {
        if (userRequestDto.getFullName().isBlank()) throw new ValidationExceptio("your fullname is empty");
        if (userRequestDto.getUsername().isBlank()) throw new ValidationExceptio("your username is empty");
    }

    @Override
    public UserResponseDto findByUsername(String username) {
        try {
            UserDao userDao = new UserRepositoryImpl().findByUsername(username);
            return new UserCommand().DaoToDtoResponse(userDao);
        } catch (RepositoryException e) {
            throw new BuisenesException("your find is failed");
        }
    }
}
