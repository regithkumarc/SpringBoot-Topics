package org.springframework.vaultconfiguration.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("credentials")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Credentials {

    private String userName;
    private String password;
}
