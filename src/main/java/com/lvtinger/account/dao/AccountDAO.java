package com.lvtinger.account.dao;

import com.lvtinger.account.domain.Account;

import java.util.List;

/**
 * 账户数据操作接口
 * @author qiuxu
 */
public interface AccountDAO {
    /**
     * 创建账户
     * @param account
     * @return
     */
    boolean insert(Account account);

    /**
     * 获取账户
     * @param username
     * @return
     */
    Account getByUsername(String username);

    /**
     * 根据用户id获取账户
     * @param principalId
     * @return
     */
    List<Account> getByPrincipalId(Long principalId);

    /**
     * 更新账户状态
     * @param account
     * @return
     */
    boolean updateStatus(Account account);
}