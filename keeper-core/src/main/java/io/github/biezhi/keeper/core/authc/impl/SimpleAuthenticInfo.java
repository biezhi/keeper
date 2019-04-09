package io.github.biezhi.keeper.core.authc.impl;

import io.github.biezhi.keeper.core.authc.AuthenticInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author biezhi
 * @date 2019-04-09
 */
@Data
@NoArgsConstructor
public class SimpleAuthenticInfo implements AuthenticInfo {

    private String              username;
    private String              password;
    private Object              payload;
    private Map<String, Object> claims;

    public SimpleAuthenticInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SimpleAuthenticInfo(String username, String password, Object payload) {
        this.username = username;
        this.password = password;
        this.payload = payload;
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public Object payload() {
        return payload;
    }

    @Override
    public Map<String, Object> claims() {
        return claims;
    }

}
