package com.code.UserResgistration.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService  {
    private final IConfirmationTokenRepository iconfirmationTokenRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        iconfirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return iconfirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return iconfirmationTokenRepository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
