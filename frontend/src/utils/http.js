/**
 * 登陆
 */
export function login(form) {
    let data = new FormData()
    data.set('username', form.username)
    data.set('password', form.password)
    data.set('remember-me', form.rememberMe)
    return req('/api/sessions', {
        body:data,
        method: 'POST',
    })
}

/**
 * 获取当前登陆的用户信息
 */
export async function getUserInfo() {
    return req('/api/users/info')
}

async function req(url, options) {
    let resp = await fetch(url, options)
    if (resp.status < 200 || resp.status >= 300) {
        throw '服务器内部错误'
    }
    let body = await resp.json()
    if (body.code === 1) {
        throw '服务器内部错误'
    }
    body.success = function () {
        return this.code === 0
    }
    return body
}

/**
 * 错误码
 */
export const Code = {
    SUCCESS: 0,

    ERROR_INTERNAL: 1,
    ERROR_USERNAME_PASSWORD_INVALID: 2,
}