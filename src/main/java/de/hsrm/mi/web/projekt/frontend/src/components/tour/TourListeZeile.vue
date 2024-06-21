<template>
  <td>{{ tourListenZeile.tour.abfahrDateTime }}</td>
  <td>{{ tourListenZeile.tour.startOrtName }}</td>
  <td>{{ tourListenZeile.tour.zielOrtName }}</td>
  <td>{{ tourListenZeile.tour.distanz }}</td>
  <td>{{ tourListenZeile.tour.plaetze }}</td>
  <td>{{ tourListenZeile.tour.plaetze - tourListenZeile.tour.buchungen }}</td>
  <td>{{ rz.rpreis }}</td>
  <!--Exeperimenteller Button zum verändern vom Preis-->
  <td><button class="btn btn-primary" @click="changePrice()">+ Preis</button></td>
</template>

<script setup lang="ts">
import type { ITourDTD } from '@/views/TourenListeView.vue'
import { ref, reactive } from 'vue'

const tourListenZeile = defineProps<{ tour: ITourDTD }>()

const rtourListenZeile = { rpreis: tourListenZeile.tour.preis}
// const refz = ref(rtourListenZeile)
const rz = reactive(rtourListenZeile);

function changePrice() {
    rz.rpreis += 3;
    console.log(tourListenZeile.tour.preis)
    }
</script>
