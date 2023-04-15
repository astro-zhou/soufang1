import {reactive} from "vue";

export default reactive({
    login: false, // 用户是否登陆
    infoLoading: false,
    info: {       // 用户信息
        name: '', // 用户名
        // ...
    }
})