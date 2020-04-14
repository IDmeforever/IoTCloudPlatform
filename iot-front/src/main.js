// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import './plugins/element.js'
// import './index.less'
import './element-variables.scss'
import router from './router'

Vue.config.productionTip = false

// BaiduMap
import BaiduMap from 'vue-baidu-map'

Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: '4o2IaQXLGEE3pL1vRpEV5FB21uGld4nP'
})

// import ElementUI
// Vue.use(ElementUI)

// Import Axios
var axios = require('axios')
axios.default.baseURL = 'http://192.168.2.103:8446/api/'
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
