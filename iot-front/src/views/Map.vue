<template>
    <baidu-map class="bm-view" :center="center" :zoom="zoom" @ready="handler">
        <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
        <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
        <bm-overview-map anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :isOpen="true"></bm-overview-map>
        <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>
        <!-- 所有的标记点 -->
        <div v-for="(item,index) in robotPosition" :key="item.name">
            <bm-marker :position="{lng: item.lng, lat: item.lat}" @click="open1(index)">
                <bm-label :content="item.name" :labelStyle="{color: 'red', fontSize : '12px'}" :offset="{width: -30, height: 30}"></bm-label>

                <!-- <bm-info-window :show="show" @close="infoWindowClose" @open="infoWindowOpen">
                    <p>状态：{{item.status}}</p>
                    <p>信息：{{item.info}}</p>
                </bm-info-window> -->
            </bm-marker>
        </div>
        <!-- <bm-marker :position="{lng: 118.786, lat: 32.061}">
            <bm-label content="机器人1" :labelStyle="{color: 'red', fontSize : '12px'}" :offset="{width: -35, height: 30}"/>
        </bm-marker> -->
    </baidu-map>
</template>

<script>

import {api} from '../request/api'

export default {
    name: 'Map',
    data() {
        return {
            center: {lng: 0, lat: 0},
            zoom: 3,
            show: false,
            robotPosition: [
                // {
                //     name: '包裹机器人1',
                //     lng: '118.78821',
                //     lat: '32.058123',
                //     status: '运输中',
                //     info: '南京大学包裹机器人1'
                // },
                // {
                //     name: '包裹机器人2',
                //     lng: '118.786297',
                //     lat: '32.058934',
                //     status: '已抵达',
                //     info: '南京大学包裹机器人2'
                // },
                // {
                //     name: '包裹机器人3',
                //     lng: '118.786809',
                //     lat: '32.061765',
                //     status: '运输中',
                //     info: '南京大学包裹机器人3'
                // }
            ]
        }
    },
    created() {
        this.checkToken();
        this.initRobots();
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
        initRobots() {
            api.getAllRobots().then(
                res => {
                    console.log(res);
                    let robots = [];
                    for(let r of res) {
                        robots.push({
                            name: r.name,
                            lng: r.lng,
                            lat: r.lat,
                            status: r.status,
                            info: r.info,
                        })
                    }
                    this.robotPosition = robots;
                    this.$message({
                        type: 'success',
                        message: '加载机器人位置成功'
                    });
                }
            )
        },
        open1(index) {
            const h = this.$createElement;
            let element = this.robotPosition[index]
            this.$notify({
                title: element.name,
                message: h('i', { style: 'color: teal'}, '状态：'+element.status+'\r\n'+'信息：'+element.info)
            });
        },
        infoWindowClose () {
            this.show = false
        },
        infoWindowOpen () {
            this.show = true
        },
        handler ({BMap, map}) {
            console.log(BMap, map)
            this.center.lng = 118.786
            this.center.lat = 32.061
            this.zoom = 17
        }
    }
}
</script>


<style>
.bm-view {
  width: 100%;
  height: 600px;
}
</style>