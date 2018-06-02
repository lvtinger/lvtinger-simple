package com.lvtinger.account.value;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AccountResult implements Serializable {

    private static final long serialVersionUID = 5074151074944829871L;

    private Boolean success;
    private String message;
}
