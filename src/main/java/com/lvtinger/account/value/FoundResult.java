package com.lvtinger.account.value;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoundResult  extends AccountResult  {
    private Boolean success;
    private String message;
    private String validate;
    private String signKey;
}
