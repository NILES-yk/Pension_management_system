import http from '@/request/request.js'

//出院记录动态分页查询
function queryOutwardPage(data){
    return http.get('/outward/listOutwardPage',{params:data})
}

//审批外出
function examineOutward(data){
    return http.post('/outward/examineOutward',data)
}

//撤销外出申请
function removeOutward(data){
    return http.post('/outward/removeOutward',data)
}

//登记回院时间
function updateBackTime(data){
    return http.post('/outward/updateBackTime',data)
}

//添加外出审批
function addOutward(data){
    return http.post('/outward/addOutward',data)
}

export {
    queryOutwardPage,
    examineOutward,
    removeOutward,
    updateBackTime,
    addOutward}