package com.lvtinger.account.dao.impl;

import com.lvtinger.account.dao.IdentityDAO;
import com.lvtinger.account.domain.Identity;

public class IdentityDAOImpl implements IdentityDAO {
    @Override
    public boolean insert(Identity identity) {
        return false;
    }

    @Override
    public boolean update(Identity identity) {
        return false;
    }

    @Override
    public boolean updateStatus(Identity identity) {
        return false;
    }

    @Override
    public Identity getById(Long principalId) {
        return null;
    }
}
