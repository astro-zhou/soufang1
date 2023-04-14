<script setup>

import TheWelcome from '../components/TheWelcome.vue'
import {ref} from "vue";

const helloMessage = ref('')

function getHelloWorldMessage() {
    fetch('/api/examples/v2/hello-world', {
        method: "GET",
    }).then(resp => resp.json()).then(resp => {
        if (resp.code === 0) {
            helloMessage.value = resp.data
        } else {
            console.error(resp.message)
        }
    })
}

// 1 后端 -> 2 前端 -> 3 调试

// 1 后端
//       => 2 联调
// 1 前端
function getErrorMessage() {
    fetch('/api/examples/v3/errors', {
        method: "GET",
    }).then(resp => resp.json()).then(resp => {
        if (resp.code === 0) {
            helloMessage.value = resp.data
        } else {
            alert(`抱歉，服务器出现错误(${resp.code})： ${resp.message}`)
            helloMessage.value = ''
        }
    })
}
</script>

<template>
    <main>
        <button type="button" @click="getHelloWorldMessage">点我显示 hello world</button>
        <h1 v-if="helloMessage.length !== 0">{{ helloMessage }}</h1>
        <button type="button" @click="getErrorMessage">点我显示报错</button>
        <TheWelcome/>
    </main>
</template>
