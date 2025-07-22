import http from '@/request/request.js'

//为顾客单个或批量添加护理项目
function addCustomerNurseItem(data){
    return http.post('/customerNurseItem/addItemToCustomer',data)
}

//移除客户护理项目
function removeCustomerNurseLevelAndItem(data){
    return http.get("/customerNurseItem/removeCustomerItem",{params:data})
}

//查询某个顾客的护理项目
function queryCustomerNurseItem(data){
    return http.get('/customerNurseItem/listCustomerItem',{params:data})
}

//客户续费
function customerRenewal(data){
    return http.post('/customerNurseItem/enewNurseItem',data)
}

//判断用户是否配置某个项目
function isIncludesCustomerNurseItem(data){
    return http.get('/customerNurseItem/isIncludesItemCustomer',{params:data})
}

export {
    addCustomerNurseItem,
    removeCustomerNurseLevelAndItem,
    queryCustomerNurseItem,
    customerRenewal,
    isIncludesCustomerNurseItem}