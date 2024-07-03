<template>
  <td>{{ tourListenZeile.tour.abfahrDateTime.split("T")[0] }} {{ tourListenZeile.tour.abfahrDateTime.split("T")[1] }}</td>
  <td>{{ tourListenZeile.tour.startOrtName }}</td>
  <td>{{ tourListenZeile.tour.zielOrtName }}</td>
  <td>{{ Math.round(tourListenZeile.tour.distanz) }}</td>
  <td>{{ tourListenZeile.tour.plaetze }}</td>
  <td>{{ tourListenZeile.tour.plaetze - tourListenZeile.tour.buchungen }}</td>
  <td>{{ rz.rpreis }}</td>
  <!--Exeperimenteller Button zum verändern vom Preis-->
  <td><button class="btn btn-primary" @click="changePrice()">+ Preis</button></td>
  <td><button class="btn btn-secondary" @click="navigateToTour(tour.id)">Details</button></td>
</template>

<script setup lang="ts">
import type { ITourDTD } from '@/stores/ITourDTD'; 
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router';

const tourListenZeile = defineProps<{ tour: ITourDTD }>();
const router  = useRouter();

const rtourListenZeile = { rpreis: tourListenZeile.tour.preis}
// const refz = ref(rtourListenZeile)
const rz = reactive(rtourListenZeile);

function changePrice() {
    rz.rpreis += 3;
    console.log(tourListenZeile.tour.preis)
    }

function navigateToTour(id: Number) {
  router.push({ path: `/touren/${id}` })
}
</script>
