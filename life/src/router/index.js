import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/components/Index'
import Order from "../components/Order";
import Hello from "../components/Hello";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Index',
      component: Index,
      children: [
        {
          path: '/order',
          component: Order
        }
      ]
    },
    {
      path: '/hello',
      component: Hello
    }
  ]
})
