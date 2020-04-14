<template>
    <div>
        <h1>欢迎{{username}}</h1>
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>场景详情</span>
                <!-- <el-button style="float: right; padding: 3px 0" type="text">打开仪表盘</el-button> -->
                <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
            </div>
            <el-row>
                <el-col :span="4">
                    <img src="../assets/robot.jpg" style="width:100%;height:100%"/>
                </el-col>
                <el-col :span="10" class="card-text">
                    <h3>描述</h3>
                    <p>包裹机器人物联网云平台管理系统</p>
                    <p>在这个平台中，可以对包裹机器人设备列表进行查看，并可以添加设备，删除设备，并可以对设备的传感器情况进行查看，观察物联网系统的整体运行情况</p>
                </el-col>
                <el-col :span="10" class="card-text">
                    <p><b>名称：</b>包裹机器人物联网云平台管理系统</p>
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
                <el-button style="float: right; padding: 3px 0" type="text" @click="addDeviceGroup()">添加新设备组</el-button>
            </div>
            <el-row>
                <!-- <el-col :span="4" v-for="(item) in deviceGroup" :key="item.id" :offset="index > 0 ? 1 : 0" style="margin: 12px"> -->
                <el-col :span="4" v-for="(item) in deviceGroup" :key="item.id" style="margin: 12px">
                    <el-card :body-style="{ padding: '0px' }">
                        <img src="https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3854073171,266127648&fm=26&gp=0.jpg" class="image">
                        <div style="padding: 14px;">
                            <span><b>{{item.name}}</b></span>
                            <el-divider></el-divider>
                            <div v-for="device in item.devices" :key="device.uuid" class="device-text">
                                <p>{{device.name}}</p>
                            </div>
                            <el-divider></el-divider>
                            <div class="bottom clearfix">
                                <time class="time">{{ currentDate }}</time>
                                <br><br>
                                <el-button type="text" class="button:left" @click="showDeviceGroupDetails(item.id)">详情</el-button>
                                <el-button type="text" class="button" @click="showEditDGDialog(item.id)">编辑</el-button>
                                <el-button type="text" class="button:right" @click="delDevice(item.id)">删除</el-button>
                            </div>
                        </div>
                    </el-card>
                </el-col>
            </el-row>
        </el-card>

        <!-- 修改设备组详情表单 -->
        <!-- Form -->
        <el-dialog title="设备组详情" :visible.sync="dialogFormVisible">
        <el-form :model="form">
            <el-form-item label="设备组名称" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off"></el-input>
            </el-form-item>
            <!-- <el-form-item label="活动区域" :label-width="formLabelWidth">
            <el-select v-model="form.region" placeholder="请选择活动区域">
                <el-option label="区域一" value="shanghai"></el-option>
                <el-option label="区域二" value="beijing"></el-option>
            </el-select>
            </el-form-item> -->
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisible = false">取 消</el-button>
            <el-button type="primary" @click="editDeviceGroup()">确 定</el-button>
        </div>
        </el-dialog>

        <!-- 添加设备组详情表单 -->
        <el-dialog title="添加一个新的设备组" :visible.sync="addDialogVisible">
            <el-form :model="newDeviceGroup">
                <el-form-item label="设备组名称" :label-width="formLabelWidth">
                    <el-input v-model="newDeviceGroup.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="设备组id" :label-width="formLabelWidth">
                    <el-input v-model="newDeviceGroup.id" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="设备列表" :label-width="formLabelWidth">
                    <el-input v-model="newDeviceGroup.stringDevices" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addDialogVisible = false">取 消</el-button>
                <el-button type="primary" @click="confirmAddDeviceGroup()">确 定</el-button>
            </div>
        </el-dialog>
        
    </div>
</template>

<script>
import {api} from '../request/api'
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
                        {name: '温度检测器1', uuid:'100001'},
                        {name: '温度检测器2', uuid:'100002'}
                    ]
                },
                {
                    id:2, 
                    name:'设备组2',
                    devices: [
                        {name: '温度检测器1', uuid:'101001'},
                        {name: '温度检测器2', uuid:'101002'}
                    ]
                },
                {
                    id:3, 
                    name:'设备组3',
                    devices: [
                        {name: '温度检测器1', uuid:'102001'},
                        {name: '温度检测器2', uuid:'102002'}
                    ]
                },
                {
                    id:4, 
                    name:'设备组4',
                    devices: [
                        {name: '温度检测器1', uuid:'103001'},
                        {name: '温度检测器2', uuid:'103002'}
                    ]
                },
                {
                    id:5, 
                    name:'设备组5',
                    devices: [
                        {name: '温度检测器1', uuid:'104001'},
                        {name: '温度检测器2', uuid:'104002'}
                    ]
                },
                {
                    id:6, 
                    name:'设备组6',
                    devices: [
                        {name: '温度检测器1', uuid:'105001'},
                        {name: '温度检测器2', uuid:'105002'}
                    ]
                },
            ],
            dialogFormVisible: false,
            form: {
                name: '',
                region: '',
                date1: '',
                date2: '',
                delivery: false,
                type: [],
                resource: '',
                desc: ''
            },
            formLabelWidth: '120px',
            curEditDGID: 0,
            addDialogVisible: false,
            newDeviceGroup: {
                id: -1,
                name: '',
                stringDevices: '',
                devices: [

                ]
            }

        }
    },
    created() {
        this.checkToken();
        this.getParams();
        this.initGroups();
    },
    watch: {
        '$route': 'getParams()',
    },
    methods: {
        checkToken(){
            let storage = window.localStorage;
            if(storage.getItem("token")!="true") {
                this.$alert('尚未登录，请登录后进行查看', '请登录', {
                    confirmButtonText: '确定',
                    callback: action => {
                        this.$router.push({
                            // name: "Manage",
                            path: "/login",
                        });
                    }
                });
            }
        },
        getParams() {
            console.log(this.$route.query.username);
            this.username = this.$route.query.username;
        },
        initGroups() {
            api.getAllDeviceGroup().then(
                res => {
                    console.log(res);
                    console.log(res.length);
                    let deviceGroupArr = [];
                    for(let singleGroup of res) {
                        deviceGroupArr.push({
                            id: singleGroup.id,
                            name: singleGroup.name,
                            devices: singleGroup.allDevices,
                            allmsg: singleGroup.allMessages,
                        })
                    }
                    this.deviceGroup = deviceGroupArr;
                }
            )
        },
        showDeviceGroupDetails(id) {
            let foundElement = this.deviceGroup.find(function(x){
                return x.id == id;
            })
            this.$alert(foundElement.allmsg, '设备组id: '+id+'信息：', {
                    confirmButtonText: '确定',
            });
        },
        showEditDGDialog(id) {
            this.dialogFormVisible = true;
            this.curEditDGID = id;
            console.log("cur ID: "+this.curEditDGID)
            // 表单默认内容
            let foundElement = this.getDeviceGroup();
            this.form.name = foundElement.name;
        },
        getDeviceGroup() {
            let tmp = this.curEditDGID;
            let foundElement = this.deviceGroup.find(function(x){
                return x.id == tmp;
            })
            return foundElement;
        },
        editDeviceGroup(){
            this.dialogFormVisible = false;
            let foundElement = this.getDeviceGroup();
            this.$axios
            .post('modifieddevicegroup', {
                id: this.curEditDGID,
                name: this.form.name,
                devices: foundElement.devices
            })
            .then(successResponse => {
                if(successResponse) {
                    // 更新列表
                    this.initGroups();
                    this.$message('修改成功');
                } else {
                    this.$message('修改失败');
                }
            })
            // eslint-disable-next-line no-unused-vars
            .catch(failResponse => {
            })
        },
        delDevice(id){
            // 对话框确认
            this.$confirm('确认要删除id为'+id+'的设备组？', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                // 发送删除请求
                api.removeDeviceGroup(id).then (
                    res => {
                        if(res) {
                            // 更新设备组
                            this.initGroups();
                            this.$message({
                                type: 'success',
                                message: '删除成功!'
                            });
                        } else {
                            this.$message({
                                type: 'info',
                                message: '查找不到此设备组，删除失败'
                            }); 
                        }
                    }
                )
                
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });          
            });
        },
        addDeviceGroup() {
            this.addDialogVisible = true;
        },
        confirmAddDeviceGroup() {
            this.addDialogVisible = false;
            let ds = this.newDeviceGroup.stringDevices.split(";");
            let devices1 = [];
            for(let d of ds) {
                let ran = Math.floor(Math.random()*1000000)
                devices1.push({
                    name: d,
                    uuid: ran,
                    messages: ['init device. ['+ran+']']
                })
            }
            // 发送添加
            this.$axios
            .post('adddevicegroup', {
                id: this.newDeviceGroup.id,
                name: this.newDeviceGroup.name,
                allDevices: devices1
            })
            .then(successResponse => {
                if(successResponse) {
                    // 更新列表
                    this.initGroups();
                    this.$message('添加成功');
                } else {
                    this.$message('添加失败');
                }
            })
            // eslint-disable-next-line no-unused-vars
            .catch(failResponse => {
            })

            this.$message('添加了一个设备组');
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