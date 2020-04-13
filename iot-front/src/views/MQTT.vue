<template>
    <div>
        <el-card class="box-card-form">
            <div slot="header" class="clearfix">
                <span>MQTT消息发布测试</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">打开仪表盘</el-button> -->
            </div>
            <el-row>
                <el-form ref="form" :model="mqttForm" label-width="150px">
                    <el-form-item label="MQTT服务器ip">
                        <el-input v-model="mqttForm.mqttip"></el-input>
                    </el-form-item>

                    <el-form-item label="MQTT服务器端口">
                        <el-input v-model="mqttForm.mqttport"></el-input>
                    </el-form-item>

                    <el-form-item label="客户端标识">
                        <el-input v-model="mqttForm.mqttclientid"></el-input>
                    </el-form-item>

                    <el-form-item label="MQTT主题">
                        <el-input v-model="mqttForm.mqtttopic"></el-input>
                    </el-form-item>

                    <el-form-item label="MQTT消息">
                        <el-input v-model="mqttForm.mqttmessage"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">发送消息</el-button>
                    </el-form-item>
                    
                </el-form>
            </el-row>
        </el-card>

        
    </div>
</template>

<script>
import {api} from '../request/api'

export default {
    name: 'MQTT',
    data() {
        return {
            mqttForm: {
                mqttip: '116.62.131.37',
                mqttport: '1883',
                mqttclientid: 'client1',
                mqtttopic: 'topic',
                mqttmessage: 'message'
            }
        }
    },
    methods: {
        onSubmit() {
            api.sendMqttMsg(this.mqttForm.mqtttopic, this.mqttForm.mqttmessage).then(
                res => {
                    if(res) {
                        this.$message({
                            type: 'success',
                            message: '发送消息成功'
                        });
                    } else {
                        this.$message({
                            type: 'info',
                            message: '发送消息失败，请检查参数'
                        });
                    }
                }
            )
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

  .box-card-form {
    width: 60%;
    /* position:absolute; */
    text-align: left;
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