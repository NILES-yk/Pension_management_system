//引入封装好的axios
import http from '@/request/request.js'
//查询退住记录
function queryBackdownVo(data){
    return http.get('/backdown/listBackdownPage',{params:data})
}

//添加退住登记
function addBackdown(data){
    return http.post('/backdown/addBackdown',data)
}

//审批外出申请
function examineBackdown(data){
    return http.post('/backdown/examineBackdown',data)
}

//撤回外出申请
function delBackdown(data){
    return http.post('/backdown/removeBackdown',data)
}

export {
    queryBackdownVo,
    addBackdown,
    examineBackdown,
    delBackdown}