<script setup>
import { RouterView } from 'vue-router'
import Header from '@/components/Header.vue'
</script>

<template>
  <el-container>
      <el-header class="header">
        <Header />
      </el-header>
      <el-main class="main">
          <RouterView />
      </el-main>
      <el-footer class="footer">
          <p>Copyright ©1999-2023 Soufang. All Right Reserved. 搜房网 版权所有 <a href="http://www.beian.gov.cn/">京网文〔2020〕xxxx-xxx号</a></p>
      </el-footer>
  </el-container>
</template>

<style>
.header {
    background: white;
    padding: 20px 40px;
}
.main {
    margin-top: 20px;
    background: white;
}
.footer{
    color:#111;
    margin-top:60px;
    text-align: center;
}

.footer a {
    color:#111;
    cursor: pointer;
    text-decoration: none;
}
</style>
