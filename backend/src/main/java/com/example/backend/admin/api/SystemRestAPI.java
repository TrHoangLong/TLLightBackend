package com.example.backend.admin.api;

import com.example.backend.admin.auth.jwt.JWTAuthenticalServiceImpl;
import com.example.backend.admin.service.ISysService;
import com.example.common.base.BaseResponse;
import com.example.common.base.Cred;
import com.example.common.base.GTException;
import com.example.common.domain.sys.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(exposedHeaders = "errors, content-type", origins = "*")
@RequestMapping("/api/system")
public class SystemRestAPI {
    @Autowired
    private JWTAuthenticalServiceImpl jwtAuthenticalService;

    @Autowired
    private ISysService sysService;

    @RequestMapping(value = "/sysuser/insert", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse sysUserInsert(@RequestBody SysUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            sysService.sysUserInser(cred, body);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/sysuser/get", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse sysUserGetList(@RequestBody SysUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            List<SysUser> sysUsers = sysService.sysUserGetList(cred, body);
            response.setData(sysUsers);
            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/sysuser/delete", method = RequestMethod.POST, produces = "application/json")
    public BaseResponse sysUserDelete(@RequestBody SysUser body, @RequestHeader("Authorization") String token) throws Exception {
        BaseResponse response = new BaseResponse();
        try {
            Cred cred = jwtAuthenticalService.checkSession(token);
            sysService.sysUserDelete(cred, body);

            response.setResultCode(0);
        } catch (GTException ex) {
            response.setErrorCode(ex.getGTErrorCode());
            response.setErrorMsg(ex.getErrorMsg());
        } catch (Exception ex) {
            response.setErrorMsg(ex.getMessage());
        }
        return response;
    }
}
