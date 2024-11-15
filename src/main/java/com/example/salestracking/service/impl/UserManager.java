package com.example.salestracking.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.salestracking.dto.request.user.CreateUserRequest;
import com.example.salestracking.dto.request.user.UpdateUserRequest;
import com.example.salestracking.dto.response.user.CreateUserResponse;
import com.example.salestracking.dto.response.user.GetAllUsersResponse;
import com.example.salestracking.dto.response.user.GetUserResponse;
import com.example.salestracking.dto.response.user.UpdateUserResponse;
import com.example.salestracking.model.User;
import com.example.salestracking.repository.UserRepository;
import com.example.salestracking.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager implements UserService
{
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllUsersResponse> getAll()
    {
        List<User> users = repository.findAll();
        return users.stream().map(user -> mapper.map(user, GetAllUsersResponse.class)).toList();
    }

    @Override
    public GetUserResponse getById(Long id)
    {
        User user = repository.findById(id).orElseThrow();
        return mapper.map(user, GetUserResponse.class);
    }

    @Override
    public CreateUserResponse add(CreateUserRequest request)
    {
        User user = mapper.map(request, User.class);
        user.setUserId(0L);
        // BCryptPasswordEncoder ile şifre hash'leme
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        user.setPassword(hashedPassword);
        repository.save(user);
        return mapper.map(user, CreateUserResponse.class);
    }

    @Override
    public UpdateUserResponse update(Long id, UpdateUserRequest request)
    {
        Optional<User> isUser = repository.findById(id);
        if (isUser.isPresent()) {
            User existingUser = isUser.get();

            // Request'den yeni kullanıcı bilgilerini alıp var olan kullanıcıya map'liyoruz
            User updatedUser = mapper.map(request, User.class);

            // Mevcut ID'yi set ediyoruz
            updatedUser.setUserId(existingUser.getUserId());

            // Şifre alanı boş değilse ve güncellenmişse yeni şifreyi hash'liyoruz
            if (request.getPassword() != null && !request.getPassword().isEmpty()) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(request.getPassword());
                updatedUser.setPassword(hashedPassword);
            } else {
                // Şifre güncellenmediyse mevcut şifreyi koruyoruz
                updatedUser.setPassword(existingUser.getPassword());
            }

            // Güncellenmiş kullanıcıyı kaydediyoruz
            repository.save(updatedUser);

            // Yanıt sınıfına map'liyoruz
            return mapper.map(updatedUser, UpdateUserResponse.class);
        }
        return null; // Kullanıcı bulunamadığında null döner
    }

    @Override
    public String delete(Long id)
    {
        Optional<User> isUser = repository.findById(id);
        if(isUser.isPresent())
        {
            repository.deleteById(id);
            return "User deleted successfully";
        }
        return "No such user in the database";
    }
}
