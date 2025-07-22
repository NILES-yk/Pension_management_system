import http from '@/request/request.js'

//查询床位的示意图
function queryBedUseDetailsVo(data){
    return http.get('/room/findBedUseDetails',{params:data})
}

//查询床位列表
function queryRoomList(){
    return http.get('/room/listRoom')
}

export {queryBedUseDetailsVo,queryRoomList}