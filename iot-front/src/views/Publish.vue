<template>
    <div>
        <el-card class="box-card-form">
            <div slot="header" class="clearfix">
                <span>新建任务</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">打开仪表盘</el-button> -->
            </div>
            <el-row>
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item label="任务名称">
                        <el-input v-model="form.name"></el-input>
                    </el-form-item>
                    <el-form-item label="任务类型">
                        <el-select v-model="form.region" placeholder="请选择任务类型">
                            <el-option label="定时任务" value="taskType1"></el-option>
                            <el-option label="间隔时间任务" value="taskType2"></el-option>
                            <el-option label="触发任务" value="taskType3"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="任务描述">
                        <el-input type="textarea" v-model="form.desc"></el-input>
                    </el-form-item>
                    
                    <!-- 若为定时任务 -->
                    <div v-if="form.region=='taskType1'">
                        <el-form-item label="触发时间">
                            <el-col :span="10">
                                <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                            </el-col>
                            <el-col class="line" :span="2">-</el-col>
                            <el-col :span="10">
                                <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                            </el-col>
                        </el-form-item>
                    </div>

                    <!-- 若为间隔时间任务 -->
                    <div v-else-if="form.region=='taskType2'">
                        <el-form-item label="间隔时间">
                            <el-col :span="8">
                                小时
                                <el-input-number v-model="form.interval.hour" @change="handleChange" :min="0" :max="24" label="小时"></el-input-number>
                            </el-col>
                            <el-col :span="8">
                                分钟
                                <el-input-number v-model="form.interval.minute" @change="handleChange" :min="0" :max="60" label="分钟"></el-input-number>
                            </el-col>
                            <el-col :span="8">
                                秒
                                <el-input-number v-model="form.interval.second" @change="handleChange" :min="0" :max="60" label="秒"></el-input-number>
                            </el-col>
                        </el-form-item>
                    </div>

                    <!-- 若为触发型任务 -->
                    <div v-else-if="form.region=='taskType3'">
                        <el-form-item label="触发条件">
                            <el-col :span='4'>
                            <el-select v-model="form.trigger.firstType" placeholder="设备">
                                <el-option label="温度传感器" value="1"></el-option>
                                <el-option label="湿度传感器" value="2"></el-option>
                                <el-option label="机器人" value="3"></el-option>
                            </el-select>
                            </el-col>
                            
                            <el-col :span='4'>
                            <el-select v-model="form.trigger.secondType" placeholder="值">
                                <el-option label="高于" value="1"></el-option>
                                <el-option label="低于" value="2"></el-option>
                                <el-option label="等于" value="3"></el-option>
                            </el-select>
                            </el-col>
                            <el-col :span='6'>
                            <el-input v-model="form.trigger.value"></el-input>
                            </el-col>
                            被触发
                        </el-form-item>
                    </div>

                    <!-- 任务 -->
                    <el-form-item label="任务详情">
                        <el-input v-model="form.task"></el-input>
                    </el-form-item>

                    <!-- <el-form-item label="即时配送">
                        <el-switch v-model="form.delivery"></el-switch>
                    </el-form-item>
                    <el-form-item label="活动性质">
                        <el-checkbox-group v-model="form.type">
                        <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
                        <el-checkbox label="地推活动" name="type"></el-checkbox>
                        <el-checkbox label="线下主题活动" name="type"></el-checkbox>
                        <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="特殊资源">
                        <el-radio-group v-model="form.resource">
                        <el-radio label="线上品牌商赞助"></el-radio>
                        <el-radio label="线下场地免费"></el-radio>
                        </el-radio-group>
                    </el-form-item> -->
                    
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">立即创建</el-button>
                        <el-button>取消</el-button>
                    </el-form-item>
                    </el-form>
            </el-row>
        </el-card>
    </div>
</template>

<script>
export default {
    name: 'Publish',
    data() {
        return {
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: '',
                interval: {
                    hour: 0,
                    minute: 0,
                    second: 0
                },
                trigger: {
                    firstType: '',
                    secondType: '',
                    value: '',
                },
                task: '',
            }
        }
    },
    // mounted: {

    // },
    methods: {
        onSubmit() {
            console.log('点击提交');
        },
        handleChange() {
            console.log(this.form.interval.hour,", ",this.form.interval.minute, ", ", this.form.interval.second);
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