<template>
    <div class="header-container">
        <div class="home" @click="$router.push('/')">
            <img alt="logo" src="@/assets/logo.svg" class="logo"/>
            <h1 class="logo-title">搜房网</h1>
        </div>
        <div class="panel-right" v-if="!userstore.infoLoading">
            <span v-if="userstore.login">{{ userstore.info.name }}</span>
            <el-button type="primary" @click="$router.push('/login')" v-else>登陆/注册</el-button>
        </div>
        <div class="clear"></div>
    </div>
</template>
<script setup>
import userstore from '@/store/user.js'
import {getUserInfo} from "@/utils/http";

;(async function() {
    userstore.infoLoading = true
    try {
        let resp = await getUserInfo()
        if (!resp.success()) {
            return
        }
        userstore.login = true
        userstore.info = resp.data
    }finally {
        userstore.infoLoading = false
    }
}())

</script>
<style>
.header-container {
    line-height: 60px;
}

.clear {
    content: "";
    display: block;
    height: 0;
    clear: both;
    visibility: hidden;
}

.home {
    cursor: pointer;
    display: inline-block;
    float: left;
}

.logo {
    width: 40px;
    display: inline-block;
    vertical-align: middle;
}

.logo-title {
    display: inline-block;
    margin: 0 0 0 5px;
    vertical-align: middle;
}

.panel-right {
    float: right;
}

</style>