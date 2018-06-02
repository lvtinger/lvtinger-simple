package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Principal;

/**
 * 用户数据操作
 */
public interface PrincipalDAO {
    /**
     * 插入
     *
     * @param principal
     * @return
     */
    boolean insert(Principal principal);

    /**
     * 更新
     *
     * @param principal
     * @return
     */
    boolean update(Principal principal);

    /**
     * 获取
     *
     * @param principalId
     * @return
     */
    Principal getById(Long principalId);

    /**
     * 更新状态
     *
     * @param principal
     * @return
     */
    boolean updateStatus(Principal principal);
}