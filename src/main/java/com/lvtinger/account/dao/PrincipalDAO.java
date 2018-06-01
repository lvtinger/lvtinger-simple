package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Principal;

public interface PrincipalDAO {
    boolean insert(Principal principal);
    boolean update(Principal principal);
    Principal getById(Long principalId);
    boolean updateStatus(Principal principal);
}