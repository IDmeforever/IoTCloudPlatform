<template>
    <div>
        <h1>欢迎{{username}}</h1>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>场景详情</span>
                <el-button style="float: right; padding: 3px 0" type="text">打开仪表盘</el-button>
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
                <el-button style="float: right; padding: 3px 0" type="text">添加新设备组</el-button>
            </div>
            <el-row>
                <el-col :span="4" v-for="(item) in deviceGroup" :key="item" :offset="index > 0 ? 1 : 0" style="margin: 12px">
                    <el-card :body-style="{ padding: '0px' }">
                        <img src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3854073171,266127648&fm=26&gp=0.jpg" class="image">
                        <div style="padding: 14px;">
                            <span><b>{{item.name}}</b></span>
                            <el-divider></el-divider>
                            <div v-for="device in item.devices" :key="device" class="device-text">
                                <p>{{device.name}}</p>
                            </div>
                            <el-divider></el-divider>
                            <div class="bottom clearfix">
                                <time class="time">{{ currentDate }}</time>
                                <br><br>
                                <el-button type="text" class="button:left">详情</el-button>
                                <el-button type="text" class="button">编辑</el-button>
                                <el-button type="text" class="button:right">删除</el-button>
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
            currentDate: new Date(),
            deviceGroup: [
                {
                    id:1, 
                    name:'设备组1',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
                {
                    id:2, 
                    name:'设备组2',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
                {
                    id:3, 
                    name:'设备组3',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
                {
                    id:4, 
                    name:'设备组4',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
                {
                    id:5, 
                    name:'设备组5',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
                {
                    id:6, 
                    name:'设备组6',
                    devices: [
                        {name: '温度检测器1', uuid:'123123123'},
                        {name: '温度检测器2', uuid:'123123123'}
                    ]
                },
            ]
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

    .device-text {
        text-align: left;
        font-size: 14px;
        padding-left: 10%;
    }

  .tables-wrapper {
        text-align: left;
    }

    .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: center;
  }

  .button:left {
    padding: 0;
    text-align: left;
    float: left;
  }

  .button:right {
    padding: 0;
    text-align: right;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
</style>