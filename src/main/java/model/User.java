package model;

import jakarta.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String id;

  private String username;

  @NotBlank
  private String name;

  private String picture;

  private String phoneNumber;

  private Group group;

  private Set<Role> role;

  private Boolean enabled;

  private String commonIp;

  private String lastLoginIp;

  private Long lastLoginTime;

  private Long createdAt;

  private Calendar resetAt;
}
