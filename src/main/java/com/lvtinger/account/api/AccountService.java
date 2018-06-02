package com.lvtinger.account.api;

import com.lvtinger.account.value.*;

public interface AccountService {
    RegisterResult register(String username, String password);
    LoginResult login(String username, String password);
    ValidateResult validate(Long principalId, String password);
    ChangeResult change(Long principalId, String original, String replace);
    FoundResult found(String username);
    ResetResult reset(String password, String validateCode, String signKey);
}