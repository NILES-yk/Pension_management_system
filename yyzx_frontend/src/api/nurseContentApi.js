import http from '@/request/request.js'

function addNurseItem(data){
    return http.post('/nurseContent/addNurseItem',data)
}

function findNurseItemPage(data){
    return http.get('/nurseContent/findNurseItemPage',{params:data})
}

function updateNurseItem(data){
    return http.post('/nurseContent/updateNurseItem',data)
}

function delNurseItem(data){
    return http.get('/nurseContent/delNurseItem',{params:data})
}

export {addNurseItem,findNurseItemPage,updateNurseItem,delNurseItem}