package com.example.backend.admin.service.impl;

import com.example.backend.admin.auth.hash.MD5HashServiceImpl;
import com.example.backend.admin.auth.jwt.JWTAuthenticalServiceImpl;
import com.example.backend.admin.dao.ISysCartDao;
import com.example.backend.admin.dao.ISysOrderDao;
import com.example.backend.admin.dao.ISysUserDao;
import com.example.backend.admin.dao.ISystemDao;
import com.example.backend.admin.service.ISysService;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.sys.SysCart;
import com.example.common.domain.sys.SysOrder;
import com.example.common.domain.sys.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysServiceImpl implements ISysService {

    @Autowired
    private ISysUserDao sysUserDao;

    @Autowired
    private MD5HashServiceImpl md5HashService;

    @Autowired
    private JWTAuthenticalServiceImpl jwtAuthenticalService;

    @Autowired
    private ISysCartDao sysCartDao;

    @Autowired
    private ISysOrderDao sysOrderDao;

    @Autowired
    private ISystemDao systemDao;

    @Override
    public List<SysUser> sysUserGetList(Cred cred, SysUser user) throws Exception {
        return sysUserDao.getlist(cred, user);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void sysUserInser(Cred cred, SysUser user) throws Exception {

        if (cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        sysUserDao.insert(cred, user);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public String sysUserLogin(Cred cred, SysUser user) throws Exception {
        SysUser sysUser = sysUserDao.getByUserID(cred, user.getSysUserId());

        if (sysUser.getSysUserId().isEmpty()) {
            throw new GTException("Tài khoản không đúng", null, null);
        }

        String md5Pass = md5HashService.hashMD5(user.getPassword());

        if (sysUser.getPassword().compareTo(md5Pass) != 0) {
            throw new GTException("Mật khẩu không đúng", null, null);
        }

        return jwtAuthenticalService.generateToken(cred);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void sysUserDelete(Cred cred, SysUser user) throws Exception {

        if (cred.getRole() != 1) {
            throw new GTException("Tài khoản không đủ quyền để thực hiện hành động này", null, null);
        }

        sysUserDao.delete(cred, user);
    }

    @Override
    public List<SysCart> getSysCart(Cred cred, SysCart obj) throws Exception {
        return sysCartDao.get(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void insertSysCart(Cred cred, SysCart obj) throws Exception {
        sysCartDao.insert(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void updateSysCart(Cred cred, SysCart obj) throws Exception {
        sysCartDao.update(cred, obj);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void deleteSysCart(Cred cred, List<SysCart> obj) throws Exception {
        for (SysCart cart: obj) {
            sysCartDao.delete(cred, cart);
        }
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void orderSysCart(Cred cred, List<SysOrder> obj) throws Exception {
        for (SysOrder order: obj) {
            sysCartDao.order(cred, order);
        }
    }

    @Override
    public List<SysOrder> getSysOrder(Cred cred, SysOrder sysOrder) throws Exception {
        return sysOrderDao.get(cred, sysOrder);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void orderSysOrder(Cred cred, SysOrder sysOrder) throws Exception {
        sysOrderDao.order(cred, sysOrder);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void updateStatusSysOrder(Cred cred, List<SysOrder> sysOrder) throws Exception {
        for (SysOrder order: sysOrder) {
            sysOrderDao.updateStatus(cred, order);
        }
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void cancelSysOrder(Cred cred, List<SysOrder> sysOrder) throws Exception {
        for (SysOrder order: sysOrder) {
            sysOrderDao.cancel(cred, order);
        }
    }

    @Override
    public List<SysOrder> getHistSysOrder(Cred cred, SysOrder sysOrder) throws Exception {
        return sysOrderDao.getHist(cred, sysOrder);
    }

    @Transactional(rollbackFor = { Exception.class })
    @Override
    public void systemCloseDate(Cred cred) throws Exception {
        systemDao.closeDate(cred);
    }
}
