import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

import Login from '../views/Login.vue'
import Manage from '../views/Manage.vue'
import Dashboard from '../views/Dashboard.vue'
import Publish from '../views/Publish.vue'
import MQTT from '../views/MQTT.vue'
import Map from '../views/Map.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/manage',
      name: 'Manage',
      component: Manage
    },
    {
      path: '/dashboard',
      name: 'Dashboard',
      component: Dashboard
    },
    {
      path: '/publish',
      name: 'Publish',
      component: Publish
    },
    {
      path: '/mqtt',
      name: 'MQTT',
      component: MQTT
    },
    {
      path: '/map',
      name: 'Map',
      component: Map
    }
  ]
})
