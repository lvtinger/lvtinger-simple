package com.lvtinger.test.Common;

import com.lvtinger.common.StringUtils;
import org.junit.Assert;
import org.junit.Test;

public class TestStringUtils {
    @Test
    public void firstToLower(){
        Assert.assertEquals(StringUtils.firstToLower("AA"), "aA");
        Assert.assertEquals(StringUtils.firstToLower("A"), "a");
        Assert.assertEquals(StringUtils.firstToLower(""), "");
        Assert.assertEquals(StringUtils.firstToLower(null), null);
    }
}
