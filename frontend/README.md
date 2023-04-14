# frontend

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur) + [TypeScript Vue Plugin (Volar)](https://marketplace.visualstudio.com/items?itemName=Vue.vscode-typescript-vue-plugin).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup

```sh
npm install
```

### Compile and Hot-Reload for Development

```sh
npm run dev
```

### Compile and Minify for Production

```sh
npm run build
```

## 附录

### 前端技术栈

原始技术栈： HTML + CSS + Javascript

* HTML: 文本标记语言，网页上显示的元素必须是 HTML，纯 HTML 很丑，但是有很多标签定义。
* CSS: 层叠样式表，一般用来美化显示效果。
* Javascript: 网页脚本语言，主要用于为网页增加交互能力（包括发送动态请求）。

### vue 开发

目录结构说明：
* package.json: 项目依赖管理，类似与 maven 的 pom.xml
* vite.config.js: 在 package.json 里， 配置了 script:  "dev": "vite"，代表运行 `npm run dev` 的时候，
      执行 `vite` 这个命令，package.json 多做的事情是自动查找 `node_modules` 这个依赖目录里的 vite 可执行文件([./node_modules/.bin/vite])
      并运行。 vite 就会自动去查找当前目录的 vite.config.js ，也就是说此文件是 vite 运行的配置文件。vite: 开发伺服器
* index.html: 首页 html 文件，两个作用：
  * 包含 图形根组件（<div id="app"></div>）
  * 使用 `<script type="module" src="/src/main.js"></script>` 标签引用 `src/main.js` javascript 脚本，意味着 `src/main.js` 是编码的开始
* src: 源代码目录
* public: 静态资源目录， 此文件夹下面的所有资源可以直接通过 `/xxx` 来访问，比如自带的 `/favicon.ico`。