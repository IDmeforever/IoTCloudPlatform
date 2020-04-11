<template>
    <div>
        <h1>欢迎{{username}}</h1>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>场景详情</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
            <el-row>
                <el-col :span="4">
                    <img src="../assets/robot.jpg" style="width:100%;height:100%"/>
                </el-col>
                <el-col :span="10" class="card-text">
                    <h3>描述</h3>
                    <p>物联网云平台管理系统</p>
                    <p>在这个平台中，可以对设备列表进行查看，并可以添加设备，删除设备，并可以对设备的情况进行查看，观察物联网系统的整体运行情况</p>
                </el-col>
                <el-col :span="10" class="card-text">
                    <p><b>名称：</b>物联网云平台管理系统</p>
                    <p><b>创建时间：</b>2020年04月11日</p>
                </el-col>
            </el-row>
            <!-- <div v-for="o in 4" :key="o" class="text item">
                {{'列表内容 ' + o }}
            </div> -->
        </el-card>

        <!-- 设备列表 -->
        <br>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>设备列表</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
            <el-row>
                <el-col :span="4" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
                    <el-card :body-style="{ padding: '0px' }">
                    <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
                    <div style="padding: 14px;">
                        <span>好吃的汉堡</span>
                        <div class="bottom clearfix">
                        <time class="time">{{ currentDate }}</time>
                        <el-button type="text" class="button">操作按钮</el-button>
                        </div>
                    </div>
                    </el-card>
                </el-col>
            </el-row>
        </el-card>
        
    </div>
</template>

<script>
export default {
    name: 'Manage',
    data() {
        return {
            username: '',
        }
    },
    created() {
        this.getParams();
    },
    watch: {
        '$route': 'getParams()',
    },
    methods: {
        getParams() {
            console.log(this.$route.query.username);
            this.username = this.$route.query.username;
        }
    }
}
</script>

<style scoped>
  .text {
    text-align: left;
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    /* width: 80%; */
    /* position:absolute; */
    margin: auto;
    left:0;right:0;top:0;bottom:0;
  }

    .card-text {
        text-align: left;
        /* font-size: 14px; */
        padding-left: 10%;
    }

  .tables-wrapper {
        text-align: left;
    }
</style>