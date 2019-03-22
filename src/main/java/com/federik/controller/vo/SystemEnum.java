package com.federik.controller.vo;

import java.util.List;

public class SystemEnum {

    public static enum  ResultEnum{
        reulstPID("首序列号",90L),loginFail("登录失败",91L),usernameOrPasswordError("用户名或者密码错误",92L),
        loginSuccessful("登录成功",93L),userInvalid("用户未登录",94L);

        ResultEnum(String describe,Long code){
            this.strDescribe = describe;
            this.resultCode = code;
        }

        ResultEnum(){};

        private String strDescribe;

        private Long resultCode;

        private List<ResultEnum> statusList;

        public String getStrDescribe() {
            return strDescribe;
        }

        public void setStrDescribe(String strDescribe) {
            this.strDescribe = strDescribe;
        }

        public Long getResultCode() {
            return resultCode;
        }

        public void setResultCode(Long resultCode) {
            this.resultCode = resultCode;
        }
    }

}
