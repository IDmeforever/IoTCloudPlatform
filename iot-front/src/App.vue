<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <h1>物联网云平台演示Demo</h1>
    <h4>张子昂 MF1932251, 吴鑫 MF1932251, 王雪 MF1932251, 曹畅 MF1932251</h4>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
