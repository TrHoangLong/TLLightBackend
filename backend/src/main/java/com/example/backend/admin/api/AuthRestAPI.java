package com.example.backend.admin.api;import com.example.backend.admin.auth.jwt.JWTAuthenticalServiceImpl;import com.example.backend.admin.service.ISysService;import com.example.common.base.BaseResponse;import com.example.common.base.Cred;import com.example.common.base.GTException;import com.example.common.domain.sys.SysUser;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;@RestController@CrossOrigin(exposedHeaders = "errors, content-type", origins = "*")@RequestMapping("/api/auth")public class AuthRestAPI {    @Autowired    private JWTAuthenticalServiceImpl jwtAuthenticalService;    @Autowired    private ISysService sysService;    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")    public BaseResponse login(@RequestBody SysUser body) throws Exception {        BaseResponse response = new BaseResponse();        try {            Cred cred = new Cred();            cred.setUserId(body.getSysUserId());            String token = sysService.sysUserLogin(cred, body);            response.setData(token);            response.setResultCode(0);        } catch (GTException ex) {            response.setErrorCode(ex.getGTErrorCode());            response.setErrorMsg(ex.getErrorMsg());        } catch (Exception ex) {            response.setErrorMsg(ex.getMessage());        }        return response;    }    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json")    public BaseResponse logout(@RequestHeader("Authorization") String token) throws Exception {        BaseResponse response = new BaseResponse();        try {            jwtAuthenticalService.logout(token);            response.setResultCode(0);        } catch (GTException ex) {            response.setErrorCode(ex.getGTErrorCode());            response.setErrorMsg(ex.getErrorMsg());        } catch (Exception ex) {            response.setErrorMsg(ex.getMessage());        }        return response;    }}