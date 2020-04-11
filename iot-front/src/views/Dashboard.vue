<template>
    <div>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>仪表盘</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">打开仪表盘</el-button> -->
            </div>
            <el-row>
                <el-col :span="6">
                    <br>
                    <el-row>
                        <img src="@/assets/icon/wenjianjia.png" style="width:15px;height:15px;padding-right:3px"/>
                        <el-button style="padding: 3px 0" type="text">添加数据</el-button>
                    </el-row>
                    <br>
                    <el-row>
                        <img src="@/assets/icon/baocun.png" style="width:15px;height:15px;padding-right:3px"/>
                        <el-button style="padding: 3px 0" type="text">保存数据</el-button>
                    </el-row>
                    <br>
                    <el-row>
                        <img src="@/assets/icon/tianjia.png" style="width:15px;height:15px;padding-right:3px"/>
                        <el-button style="padding: 3px 0" type="text">添加表盘</el-button>
                    </el-row>
                </el-col>

                <el-col :span="18" class="card-text">
                    <h3>最新数据</h3>
                    <div v-for="(item, index) in reverseMessage" :key="item.id">
                        <div v-if="index<3">
                            <p><b>{{item.source}}</b> [{{item.time}}], value={{item.value}}</p>
                        </div>
                    </div>
                </el-col>
                
            </el-row>
            <!-- <div v-for="o in 4" :key="o" class="text item">
                {{'列表内容 ' + o }}
            </div> -->
        </el-card>

        <!-- 仪表盘项 -->
        <br>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>仪表盘列表</span>
                <el-button style="float: right; padding: 3px 0" type="text">添加新仪表盘</el-button>
            </div>
            <el-row>
                <el-col :span="4" style="margin: 12px">
                    <el-card :body-style="{ padding: '0px' }">
                        <h4>温度</h4>
                        <el-progress type="circle" :percentage="25"></el-progress>
                        <br><br>
                    </el-card>
                </el-col>

            </el-row>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'Dashboard',
    data() {
        return {
            test: [
                1,2,3,4
            ],
            recordMsg: [
                {
                    id: 1,
                    time: new Date(),
                    source: '温度计',
                    value: '35'
                },
                {
                    id: 2,
                    time: new Date(),
                    source: '湿度计',
                    value: '20'
                },
                {
                    id: 3,
                    time: new Date(),
                    source: '加速度传感器',
                    value: '2'
                },
                {
                    id: 4,
                    time: new Date(),
                    source: '速度传感器',
                    value: '3'
                },
            ]
        }
    },
    methods: {
        
    },
    computed: {
        reverseMessage() {
            return this.recordMsg.reverse();
        }
    },
    watch: {

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