package com.example.WhatsAppCloneApi.User;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
@Service
public class UserMapper {
    public user fromTokenAttributes(Map<String, Object> attributes) {
        user u = new user();
        if (attributes.containsKey("sub")){
            u.setId(attributes.get("sub").toString());
        }
        if (attributes.containsKey("given_name")){
            u.setFirstName(attributes.get("given_name").toString());
        } else if (attributes.containsKey("nickname")) {
            u.setFirstName(attributes.get("nickname").toString());
        }

        if (attributes.containsKey("family_name")){
            u.setLastName(attributes.get("family_name").toString());
        }
        if (attributes.containsKey("email")){
            u.setLastName(attributes.get("email").toString());
        }
        u.setLastSeen(LocalDateTime.now());


        return u;
    }
    public UserResponse toUserRespone(user u) {
        return UserResponse.builder()
                .id(u.getId())
                .firstName(u.getFirstName())
                .lastName(u.getLastName())
                .email(u.getEmail())
                .lastSeen(u.getLastSeen())
                .isOnline(u.isUserOnline())
                .build();
    }
}
