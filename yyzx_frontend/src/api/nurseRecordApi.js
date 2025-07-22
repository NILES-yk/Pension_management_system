import http from '@/request/request.js'

//护理记录动态分页查询
function queryNurseRecordPage(data){
    return http.get('/nurseRecord/listNurseRecord',{params:data})
}

//生成护理记录
function addNurseRecord(data){
    return http.post('/nurseRecord/addNurseRecord',data)
}

//移除护理记录
function removeNurseRecord(data){
    return http.get('/nurseRecord/removeNurseRecord',{params:data})
}

//查询外出记录
function queryOutRecord(data){
    return http.get('/nurseRecord/queryOutwardVo',{params:data})
}   

export {
    queryNurseRecordPage,
    addNurseRecord,
    removeNurseRecord,
    queryOutRecord}