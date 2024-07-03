<template>
  <table class="table">
    <thead>
      <th>Abfahrt</th>
      <th>von</th>
      <th>nach</th>
      <th>Entfernung</th>
      <th>Plätze</th>
      <th>frei</th>
      <th>Preis</th>
    </thead>

    <tbody>
        <tr v-for="tour in filteredTouren" v-bind:key="tour.id">
            <TourListeZeile :tour="tour"/>
        </tr>
    </tbody>
  </table>
</template>

<script setup lang="ts">
import type { ITourDTD } from '@/stores/ITourDTD'; 
import TourListeZeile from './TourListeZeile.vue';
import { ref, computed } from 'vue';

const touren = defineProps<{ tourliste: ITourDTD[], word: String }>();
const filteredTouren = computed(() => touren.tourliste.filter(tour => 
 tour.startOrtName.toLowerCase().includes(touren.word.toLowerCase()) || tour.zielOrtName.toLowerCase().includes(touren.word.toLowerCase())
))
</script>

