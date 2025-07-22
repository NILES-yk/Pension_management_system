//引入封装好的axios
//@等价于/src
import http from '@/request/request.js'
//用户登录
function login(data){
    return http.get('/user/login',{params:data})
}

//查询系统用户信息
function findUserPage(data){
    return http.get('/user/findUserPage',{params:data})
}

//添加用户
function addUser(data){
    return http.post('/user/addUser',data)
}

//更新护理项目
function updateUser(data){
    return http.post('/user/updateUser',data)
}

//删除护理项目
function deleteUser(data){
    return http.get('/user/deleteUser',{params:data})
}

//查询系统用户信息
function findAllUserPage(data){
    return http.get('/user/findAllUserPage',{params:data})
}

//暴露所有函数
export {
    addUser,
    updateUser,
    deleteUser,
    findAllUserPage,
    findUserPage,
    login}