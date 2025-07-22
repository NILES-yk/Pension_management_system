import http from '@/request/request.js'

//为单个客户添加客户喜好
function addCustomerPreference(data){
    return http.post('/customerPreference/addCustomerPreference',data)
}

//更新客户喜好
function updateCustomerPreference(data){
    return http.post('/customerPreference/updateCustomerPreference',data)
}

//删除客户喜好
function removeCustomerPreference(data){
    return http.get('/customerPreference/removeCustomerPreference',{params:data})
}

//客户喜好动态分页查询
function queryCustomerPreference(data){
    return http.get('/customerPreference/listPreferencePage',{params:data})
}

export{
    addCustomerPreference,
    updateCustomerPreference,
    removeCustomerPreference,
    queryCustomerPreference
}