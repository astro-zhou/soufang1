<template>
    <div class="form-container">
        <el-form label-width="120px" :model="form">
            <el-form-item lable="用户名：">
                <el-input v-model="form.username" placeholder="用户名/邮箱/手机号" type="text"/>
            </el-form-item>
            <el-form-item lable="密码：">
                <el-input type="password" v-model="form.password"/>
            </el-form-item>
            <el-form-item>
                <el-checkbox v-model="form.rememberMe">七天内自动登陆</el-checkbox>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登陆</el-button>
            </el-form-item>
        </el-form>
    </div>

</template>
<script setup>

import {reactive} from "vue";
import userstore from '@/store/user.js'
import router from "@/router";
import {Code, getUserInfo, login} from "@/utils/http";


const form = reactive({
    username: '',
    password: '',
    rememberMe: false,
})

async function onSubmit() {
    let resp = await login(form)
    if (!resp.success()) {
        switch (resp.code) {
            case Code.ERROR_USERNAME_PASSWORD_INVALID:
                alert('用户名密码错误')
                return
            default:
                alert('服务器错误')
                return
        }
    }
    userstore.infoLoading = true
    resp = null
    try{
        resp = await getUserInfo()
        if (!resp.success()) {
            alert('服务器错误')
            return
        }
    }finally {
        userstore.infoLoading = false
    }
    userstore.login = true
    userstore.info = resp.data
    await router.push('/')
}
</script>

<style>
.form-container {
    width: 450px;
    margin: 20px auto;
}
</style>