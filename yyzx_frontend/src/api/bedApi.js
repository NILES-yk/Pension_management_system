//引入封装好的axios
import http from '@/request/request.js'

//获取床位示意图数据
function findBedUseVo(data){
    return http.get('/room/findBedUseDetails',{params:data})
}

//根据房间查询床位信息
function findBedByRoom(data){
    return http.get('/bed/findBed',{params:data})
}

//查询床位详情-分页
function findBedDetailsList(data){
    return http.get("/bedDetails/listBedDetailsVoPage",{params:data})
}

//更新床位详情信息-床位开始使用时间
function updateDetailsStartDate(data){
    return http.post('/bedDetails/updateBedDetails',data)
}

//床位调换
function exchangeBed(data){
    return http.post('/bed/exchangeBed',data)
}

//删除床位详情
function deleteBedDetails(data){
    return http.get('/bedDetails/deleteBedDetails',{params:data})
}

export { 
    findBedUseVo,
    findBedByRoom,
    findBedDetailsList,
    updateDetailsStartDate,
    exchangeBed,
    deleteBedDetails }