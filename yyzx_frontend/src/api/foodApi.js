import http from '@/request/request.js'

//查询所有食品列表
function queryFoodList() {
    return http.get('/food/listFood')
}

export {queryFoodList}