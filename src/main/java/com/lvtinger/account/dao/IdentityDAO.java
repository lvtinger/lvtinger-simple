package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Identity;

public interface IdentityDAO {
    boolean insert(Identity identity);
    boolean update(Identity identity);
    boolean updateStatus(Identity identity);
    Identity getById(Long principalId);
}
