<template>
  <h1 class="title">Das aktuelle Mitfahrangebot</h1>

  <TourenListe :tourliste="tourliste"></TourenListe>
</template>

<script setup lang="ts">
/*
 * TourenListe-Komponente bitte in src/components/tour selbst implementieren
 */
import { useTourenStore } from '@/stores/tourenstore'
import TourenListe from '@/components/tour/TourenListe.vue'
import { ref, onMounted } from 'vue'

const { tourliste, ok, updateTourListe } = useTourenStore()

onMounted(() => updateTourListe());

</script>

<style scoped></style>
