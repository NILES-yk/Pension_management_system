import axios from 'axios'
import qs from 'qs'
import router from '../router'

const instance =axios.create({
    //设置请求的根路径
    baseURL: 'http://localhost:9999/yyzx'
});

//拦截代码 携带token进行访问的代码
instance.interceptors.request.use(function(config){
    //如果token存在
    //让每个请求携带自定义token
    let token=sessionStorage.getItem('token');
    if(token){
        config.headers['token']=token;
    }
    //定义需要post请求方式为application/json的api集
    let jsonQueryParamPath=['/customerNurseItem/addItemToCustomer']
    //设置post请求参数
    if(config.method=='post' && jsonQueryParamPath.indexOf(config.url)<0){
        config.data=qs.stringify(config.data)
    }
    return config;
},function(error){
    //请求错误处理
    return Promise.reject(error);
});

//添加请求interceptor
instance.interceptors.response.use(function(response){
    //如果是token异常，返回登录页面
    if(!response.data.flag&&response.data.data=='token_error'){
        router.push('/login');
    }
    return response.data;
},function(error){
    return Promise.reject(error);
});


export default instance;