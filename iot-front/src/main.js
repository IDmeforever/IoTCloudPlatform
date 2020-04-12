// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import './plugins/element.js'
// import './index.less'
import './element-variables.scss'
import router from './router'

Vue.config.productionTip = false

// import ElementUI
// Vue.use(ElementUI)

// Import Axios
var axios = require('axios')
axios.default.baseURL = 'http://192.168.2.103:8446/userCheck/'
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
