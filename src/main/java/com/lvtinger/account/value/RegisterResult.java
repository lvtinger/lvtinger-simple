package com.lvtinger.account.value;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResult extends AccountResult  {
    private static final long serialVersionUID = -3733321688333680008L;

    private boolean success;
    private String message;
}
