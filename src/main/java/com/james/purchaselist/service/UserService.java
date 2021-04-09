package com.james.purchaselist.service;

import com.james.purchaselist.domain.model.entity.Users;
import com.james.purchaselist.domain.model.network.CrudInterface;
import com.james.purchaselist.domain.model.network.Header;
import com.james.purchaselist.domain.model.network.request.UserRequest;
import com.james.purchaselist.domain.model.network.response.UserResponse;
import com.james.purchaselist.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements CrudInterface<UserRequest, UserResponse> {

    private final UsersRepository usersRepository;

    @Override
    public Header<UserResponse> create(Header<UserRequest> userRequest) {

        UserRequest reqBody = userRequest.getData();

        Users user = Users.builder()
                .account(reqBody.getAccount())
                .password(reqBody.getPassword())
                .status("REGISTERED")
                .phoneNumber(reqBody.getPhoneNumber())
                .email(reqBody.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();

        Users newUser = usersRepository.save(user);

        return toResponse(newUser);
    }

    @Override
    public Header<UserResponse> read(Long id) {

        Optional<Users> optionalUsers = usersRepository.findById(id);

        return optionalUsers.map(user -> toResponse(user))
                .orElseGet(() -> Header.error("데이터 없음"));

    }

    @Override
    @Transactional
    public Header<UserResponse> update(Header<UserRequest> request) {

        // request 에서 유저 정보 인스턴스화
        UserRequest userRequest = request.getData();

        // 인스턴스화된 유저정보에서 id로 검색
        Optional<Users> optional = usersRepository.findById(userRequest.getId());

        return optional.map(user -> {
            user.setAccount(userRequest.getAccount())
                    .setEmail(userRequest.getEmail())
                    .setPassword(userRequest.getPassword())
                    .setStatus(userRequest.getStatus())
                    .setPhoneNumber(userRequest.getPhoneNumber())
                    .setUnregisteredAt(userRequest.getUnregisteredAt())
                    .setRegisteredAt(userRequest.getRegisteredAt());
            return user;
        })
                .map(user -> usersRepository.save(user))
                .map(user -> toResponse(user))
                .orElseGet(() -> Header.error("해당 유저 없음"));


    }//update()

    @Override
    public Header delete(Long id) {
        return usersRepository.findById(id)
                .map(user -> {
                    usersRepository.deleteById(id);
                    return Header.ok();
                })
                .orElseGet(() -> Header.error("해당 유저 없음"));
    }

    //response 작성용 메서드
    private Header<UserResponse> toResponse(Users users) {
        UserResponse userResponse = UserResponse.builder()
                .id(users.getId())
                .account(users.getAccount())
                .email(users.getEmail())
                .status(users.getStatus())
                .password(users.getPassword()) //todo 암호화(Bcrypt)
                .phoneNumber(users.getPhoneNumber())
                .registeredAt(users.getRegisteredAt())
                .unregisteredAt(users.getUnregisteredAt()).build();

        return Header.ok(userResponse);
    }
}
