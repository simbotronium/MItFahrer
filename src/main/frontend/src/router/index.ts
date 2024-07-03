import { createRouter, createWebHistory } from 'vue-router'
import TourenListeView from '@/views/TourenListeView.vue'
import TourView from '@/views/TourView.vue'
// import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/touren'
    },
    {
      path: '/touren',
      name: "Tourliste",
      component: TourenListeView
    },
    {
    path: "/touren/:tourid",
    name: "Tour Detailansicht",
    component: TourView,
    props: route => ({ id: Number(route.params.tourid) })
    },

    // {
    //   path: '/',
    //   name: 'home',
    //   component: HomeView
    // },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
