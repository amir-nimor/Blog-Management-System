package ir.maktabsharif.service.user;

import ir.maktabsharif.dto.user.UserRequestDto;
import ir.maktabsharif.dto.user.UserResponseDto;
import ir.maktabsharif.service.base.BaseService;

public interface UserService extends BaseService<UserRequestDto, UserResponseDto,Integer> {

    UserResponseDto findByUsername(String username);
}
