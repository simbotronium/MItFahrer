<template>
    <h1 class="title" v-if="tour">Tour {{ tour.id }}</h1>
    <h1 class="text-danger title" v-else>Tour mit id {{ id.id }} konnte nicht gefunden werden</h1>
  
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
  import { useInfo } from '@/composables/useInfo';

  const { state, loescheInfo, setzeInfo } = useInfo()
  const { tourdata, updateTourListe } = useTourenStore();
  const id = defineProps<{ id: Number }>();
  updateTourListe();

  const tour = tourdata.tourdata.tourliste.find(item => item.id === id.id);

  if (tour && tour.distanz) {
    if (tour.distanz > 300) {
        console.log("hier1")
        setzeInfo(`Die Tour von ${tour.startOrtName} bis ${tour.zielOrtName} ist länger als 300km. Bitte Kekse einpacken!`);
    } else {
        console.log("hier2")
        loescheInfo();
    }
  }
    

  </script>
  
  <style scoped></style>
  