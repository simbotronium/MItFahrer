<template>
  <h1 class="title">Das aktuelle Mitfahrangebot</h1>

  <input type="text" v-model="search" placeholder="suchen">

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

</script>

<style scoped></style>
