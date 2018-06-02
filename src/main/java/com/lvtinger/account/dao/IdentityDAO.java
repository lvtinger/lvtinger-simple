package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Identity;

/**
 * 证件数据操作类
 */
public interface IdentityDAO {
    /**
     * 插入
     *
     * @param identity
     * @return
     */
    boolean insert(Identity identity);

    /**
     * 更新
     *
     * @param identity
     * @return
     */
    boolean update(Identity identity);

    /**
     * 状态更新
     *
     * @param identity
     * @return
     */
    boolean updateStatus(Identity identity);

    /**
     * 读取
     *
     * @param principalId
     * @return
     */
    Identity getById(Long principalId);
}
