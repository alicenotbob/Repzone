package by.powerline.repzone.security.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 21:37
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenPayload {
    private Long userId;
    private Long expiration;
}
