package com.example.WhatsAppCloneApi.User;

import com.example.WhatsAppCloneApi.Chat.Chat;
import com.example.WhatsAppCloneApi.common.BaseAuditingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@NamedQuery(name = UserConstants.FIND_USER_BY_EMAIL,
query = "SELECT u FROM user u where u.email= :email")
@NamedQuery(name = UserConstants.FIND_ALL_USERS_EXCEPT_SELF,
query = "SELECT u FROM user  u where u.id !=: publicId")
@NamedQuery(name = UserConstants.FIND_USER_BY_PUBLIC_ID ,
query = "SELECT u FROM user  u where u.id =: publicId")
public class user  extends BaseAuditingEntity {
    @Id

    private String id ;
    private String firstName ;
    private String lastName ;
    private String email;
    private LocalDateTime lastSeen;
   @OneToMany(mappedBy = "sender")
    private List<Chat> chatsAsSender;
   @OneToMany(mappedBy = "recipient")
    private List<Chat> chatsAsRecipient ;
    private static final int LAST_ACTIVATE_INTERVAL = 5;
   @Transient
   public Boolean isUserOnline(){
       return lastSeen !=null && lastSeen.isAfter(LocalDateTime.now().minusMinutes(LAST_ACTIVATE_INTERVAL));
   }
}
