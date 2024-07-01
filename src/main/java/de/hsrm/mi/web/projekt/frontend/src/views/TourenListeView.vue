<template>
  <h1 class="title">Das aktuelle Mitfahrangebot</h1>

  <div class="container-fluid">
    <input type="text" v-model="search" placeholder="suchen">
    <button class="btn btn-outline-secondary" @click="clearSearch">reset</button>
  </div>

  <TourenListe :tourliste="tourdata.tourdata.tourliste" :word="search"></TourenListe>
</template>

<script setup lang="ts">
/*
 * TourenListe-Komponente bitte in src/components/tour selbst implementieren
 */
import { useTourenStore } from '@/stores/tourenstore'
import TourenListe from '@/components/tour/TourenListe.vue'
import { ref, watch, onMounted } from 'vue'

const { tourdata, updateTourListe } = useTourenStore()
const search = ref("")


updateTourListe()

function clearSearch() {
  search.value = "";
}

</script>

<style scoped></style>
