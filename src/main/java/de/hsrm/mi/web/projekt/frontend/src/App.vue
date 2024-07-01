<script setup lang="ts">
import { ref } from 'vue'
import { useInfo } from './composables/useInfo';
import { RouterView } from 'vue-router';
import TourView from './views/TourView.vue';

const { info, loescheInfo, setzeInfo } = useInfo()

</script>

<template>
  <header>
    <div class="p-5 jumbotron bg-primary text-center text-white rounded">
      <h1>Die MI fahrzentrale</h1>
      <h4></h4>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="#"></a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavDarkDropdown"
          aria-controls="navbarNavDarkDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDarkDropdown">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item">
              <a class="nav-item nav-link">Benutzer</a>
            </li>
            <li class="nav-item">
              <a class="nav-item nav-link">Orte</a>
            </li>
            <li class="nav-item">
              <a class="nav-item nav-link">Touren</a>
            </li>
          </ul>
          <div class="collapse navbar-collapse justify-content-end">
            <ul class="navbar-nav">
              <li class="nav-item dropdown">
                <button
                  class="btn btn-light dropdown-toggle"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  Sprache
                </button>
                <ul class="dropdown-menu dropdown-menu-dark">
                  <li><a class="dropdown-item">DE</a></li>
                  <li><a class="dropdown-item">EN</a></li>
                  <li><a class="dropdown-item">NL</a></li>
                  <li><a class="dropdown-item">VNM</a></li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
    <!--alertbox-->
    <div
      class="alert alert-danger alert-warning alert-dismissible fade show text-center"
      role="alert"
      v-if="info !== ''"
    >
      {{ info }}
      <button type="button" class="close" v-on:click="loescheInfo()" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </header>
  <div style="padding:4em">
    <TourView id="14567"></TourView>
  </div>

  <footer>
    <div class="row mt-5">
      <ul class="nav d-flex justify-content-center text-center p-4 bg-light fixed-bottom">
        <li class="nav-item">
          <a class="nav-link" href="#">Lizenzen</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Kontakt</a>
        </li>
      </ul>
    </div>
  </footer>
</template>

<style scoped></style>
