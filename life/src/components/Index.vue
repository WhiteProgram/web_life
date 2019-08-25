<template>
  <div>
    <el-container id="container1">
      <el-header>
        <span>后台管理系统</span>
        <el-dropdown>
          <div>
            <i class="el-icon-user" style="background: #ffffff"></i>
            <span style="color: #ffffff">{{admin.name}}</span>
          </div>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
    </el-container>
    <el-container>
      <el-aside width="200px">
        <el-menu
          default-active="1"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
          :collapse="isCollapse"
        style="width: 100%">
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>个人中心</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/order">消费记录</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </div>
</template>

<script>

  export default {
    data () {
      return {
          isCollapse:false,
        admin:{
          name : 'Meigen'
        }
      }
    },
      methods: {
          handleOpen(key, keyPath) {
              console.log(key, keyPath);
          },
          handleClose(key, keyPath) {
              console.log(key, keyPath);
          }
      }
  }
</script>
<style scoped>
  #container1{
    width: 100%;
    height: 100%;
  }
  .el-header{
    background: #868e96;
    text-align: right;
    line-height: 60px;
    padding: 0 50px;
    color: #fff;
  }
  .el-aside{
    min-height: 800px;
  }
  .el-footer{
    background: azure;
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%
  }
  span:first-child{
    float: left;
  }
</style>
