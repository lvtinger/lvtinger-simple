package com.lvtinger.account.dao.impl;

import com.lvtinger.account.dao.CipherDAO;
import com.lvtinger.account.domain.Cipher;

public class CipherDAOImpl implements CipherDAO {
    @Override
    public boolean insert(Cipher cipher) {
        return false;
    }

    @Override
    public Cipher getById(Long principalId) {
        return null;
    }

    @Override
    public boolean updatePassword(Cipher cipher) {
        return false;
    }
}
