package com.soufang.soufang.base;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.util.Assert;

public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {
    private final SecurityUser principal;

    public SmsCodeAuthenticationToken(SecurityUser principal) {
        super(principal.getAuthorities());
        this.principal = principal;
        super.setAuthenticated(true); // must use super, as we override
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        Assert.isTrue(!isAuthenticated,
                "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        super.setAuthenticated(false);
    }
}
