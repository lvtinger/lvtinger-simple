package com.lvtinger.account.value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeResult  extends AccountResult  {
    private static final long serialVersionUID = -6596168916918211266L;

    private Boolean success;
    private String message;
}
