package com.soufang.soufang.service;

public interface UserService {
    void requestVerification(String phone);

    boolean validateVerification(String phone, String code);
}
