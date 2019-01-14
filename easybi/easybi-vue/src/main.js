// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import './lib/jquery-vender.js'
import 'bootstrap'
import 'adminlte'
import 'bootstrap/dist/css/bootstrap.css'
import 'adminlte/dist/css/AdminLTE.min.css'
import 'adminlte/dist/css/skins/_all-skins.min.css'
import 'font-awesome/css/font-awesome.css'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
