<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> -->
    <h1>物联网云平台演示Demo</h1>
    <h4>张子昂 MF1932251, 吴鑫 MF1932251, 王雪 MF1932251, 曹畅 MF1932251</h4>
    <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1"><router-link to="/login">首页</router-link></el-menu-item>
      <el-menu-item index="2"><router-link to="/manage">管理</router-link></el-menu-item>
      <el-menu-item index="3"><router-link to="/dashboard">Dashboard</router-link></el-menu-item>
      <el-menu-item index="4"><router-link to="/publish">发布任务</router-link></el-menu-item>
      <el-menu-item index="5"><router-link to="/mqtt">MQTT消息发布测试</router-link></el-menu-item>
      <!-- <el-menu-item index="4"><a href="https://www.ele.me" target="_blank">订单管理</a></el-menu-item> -->
    </el-menu>
    <br>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      //activeIndex,
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
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
