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

        return response(newUser);
    }

    @Override
    public Header<UserResponse> read(Long id) {

        Optional<Users> optionalUsers = usersRepository.findById(id);

        return optionalUsers.map(user -> response(user))
                .orElseGet(() -> Header.error("데이터 없음"));

    }

    @Override
    public Header<UserResponse> update(Header<UserRequest> request) {
        return null;
    }

    @Override
    public Header<UserResponse> delete(Long id) {
        return null;
    }

    //response 작성용 메서드
    private Header<UserResponse> response(Users users) {
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
