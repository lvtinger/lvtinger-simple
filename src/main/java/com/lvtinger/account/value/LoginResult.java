package com.lvtinger.account.value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResult extends AccountResult  {
    private static final long serialVersionUID = -7976190491226725384L;
    private Boolean success;
    private String message;
    private String loginKey;
}
