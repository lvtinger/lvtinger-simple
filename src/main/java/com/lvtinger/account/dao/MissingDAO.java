package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Missing;

public interface MissingDAO {
    public boolean insert(Missing missing);
    public Missing getById(Long principalId);
}
