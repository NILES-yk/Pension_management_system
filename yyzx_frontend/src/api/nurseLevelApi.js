import http from '@/request/request.js'
import { pa } from 'element-plus/es/locales.mjs'

//添加护理级别
function addNurseLevel(data){
    return http.post('/nurseLevel/addNurseLevel',data)
}

//更新护理级别
function updateNurseLevel(data){
    return http.post('/nurseLevel/updateNurseLevel',data)
}

//删除护理级别
function removeNurseLevel(data){
    return http.get('/nurseLevel/removeNurseLevel',{params:data})
}

//查询护理级别
function queryNurseLevel(data){
    return http.get('/nurseLevel/listNurseLevel',{params:data})
}

//根据护理级别查询护理项目
function queryNurseItemByLevel(data){
    return http.get("/nurseLevel/listItemToLevel",{params:data})
}

//护理项目配置
function addItemToLevel(data){
    return http.post("/nurseLevel/addItemToLevel",data)
}

function removeNurseLevelItem(data){
    return http.get("/nurseLevel/removeNurseLevelItem",{params:data})
}

export{
    addNurseLevel,
    updateNurseLevel,
    removeNurseLevel,
    queryNurseLevel,
    queryNurseItemByLevel,
    addItemToLevel,
    removeNurseLevelItem
}