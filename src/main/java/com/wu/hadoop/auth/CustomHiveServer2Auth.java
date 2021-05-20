package com.wu.hadoop.auth;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hive.service.auth.PasswdAuthenticationProvider;

import javax.security.sasl.AuthenticationException;

public class CustomHiveServer2Auth implements PasswdAuthenticationProvider {
    @Override
    public void Authenticate(String username, String password)
            throws AuthenticationException {
        System.out.println("========username=" + username + ";password=" + password);
        boolean ok = false;
        HiveConf hiveConf = new HiveConf();
        Configuration conf = new Configuration(hiveConf);
        if ("root".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)) {
            System.out.println("登录成功");
        } else {
            throw new AuthenticationException("user [" + username + "] auth check fail .. ");
        }
    }
}