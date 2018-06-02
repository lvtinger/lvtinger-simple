package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Cipher;

/**
 * 密码数据操作接口
 *
 * @author qiuxu
 */
public interface CipherDAO {
    /**
     * 创建密码
     *
     * @param cipher
     * @return
     */
    boolean insert(Cipher cipher);

    /**
     * 根据用户id获取密码
     *
     * @param principalId
     * @return
     */
    Cipher getById(Long principalId);

    /**
     * 更新密码
     *
     * @param cipher
     * @return
     */
    boolean updatePassword(Cipher cipher);
}
