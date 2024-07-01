<template>
    <h1 class="title" v-if="tour">Tour {{ tour.id }}</h1>
    <h1 class="text-danger title" v-else><r>Tour mit id {{ id.id }} konnte nicht gefunden werden</r></h1>
  
    <div v-if="tour">
        <br>
        <p>Abfahrt am <b>{{ tour.abfahrDateTime.split("T")[0] }} um {{ tour.abfahrDateTime.split("T")[1] }}</b></p>
        <p>Preis <b>{{ tour.preis }} EUR</b> für {{ Math.round(tour.distanz) }} km.</p>
        <p>Anbieter ist <b>{{ tour.anbieterName }}</b>.</p>
        <p>es gibt {{ tour.plaetze }} Plätze</p>
    </div>

  </template>
  
  <script setup lang="ts">
  import { useTourenStore } from '@/stores/tourenstore';

  const { tourdata, updateTourListe } = useTourenStore();
  const id = defineProps<{ id: string }>();
  updateTourListe();

  const tour = tourdata.tourdata.tourliste.find(item => item.id === parseInt(id.id));

  </script>
  
  <style scoped></style>
  