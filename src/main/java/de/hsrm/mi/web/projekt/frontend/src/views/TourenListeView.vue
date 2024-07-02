<template>
  <h1 class="title">Das aktuelle Mitfahrangebot</h1>

  <div class="d-flex w-100">
    <input type="text" v-model="search" placeholder="suchen" class="form-control flex-grow-1">
    <button class="btn btn-outline-secondary ml-2" @click="clearSearch">reset</button>
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
import { useInfo } from '@/composables/useInfo';

const { loescheInfo } = useInfo();
const { tourdata, updateTourListe, startTourLiveUpdate } = useTourenStore();
const search = ref("");

loescheInfo();
await updateTourListe();

if (tourdata.tourdata.ok) {
  startTourLiveUpdate();
}

function clearSearch() {
  search.value = "";
}

</script>

<style scoped></style>
