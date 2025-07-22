import http from "@/request/request.js"

//膳食查询(分页) 可以根据星期和膳食类型(早餐、中餐、晚餐)进行查询
function queryMealPage(data){
    return http.get('/meal/listMealPage',{params:data})
}

//添加膳食信息
function addMeal(data){
    return http.post('/meal/addMeal',data)
}

//更新膳食信息
function updateMeal(data){
    return http.post('/meal/updateMeal',data)
}

//删除膳食信息
function removeMeal(data){
    return http.get('/meal/removeMeal',{params:data})
}

export {
    queryMealPage,
    addMeal,
    updateMeal,
    removeMeal}
