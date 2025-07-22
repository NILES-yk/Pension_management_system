import http from '@/request/request.js'

//入住登记-入住
function addCustomer(data){
    return http.post('/customer/register',data)
}

//入住登记-客户信息列表
function listCustomerInfoPage(data){
    return http.get("/customer/listCustomerInfoPage",{params:data})
}

//删除客户
function delCustomer(data){
    return http.get('/customer/remove',{params:data})
}

//编辑客户
function updateCustomer(data){
    return http.post('/customer/editCustomerInfo',data)
}

export {
    addCustomer,
    listCustomerInfoPage,
    delCustomer,
    updateCustomer}