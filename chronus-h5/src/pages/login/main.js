import Vue from 'vue'
import App from './app.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import http from '../../Http.js'
import i18n from '../../lang'
import '../../icons' // icon
import store from '../../store'
Vue.prototype.$http = http
Vue.use(ElementUI, {
  i18n: (key, value) => i18n.t(key, value)
})
Vue.use(ElementUI)

new Vue({
  i18n,
  store,
  render: h => h(App)
}).$mount('#app')
