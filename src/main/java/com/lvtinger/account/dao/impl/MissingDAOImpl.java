package com.lvtinger.account.dao.impl;

import com.lvtinger.account.dao.MissingDAO;
import com.lvtinger.account.domain.Missing;

public class MissingDAOImpl implements MissingDAO {
    @Override
    public boolean insert(Missing missing) {
        return false;
    }

    @Override
    public Missing getById(Long principalId) {
        return null;
    }
}