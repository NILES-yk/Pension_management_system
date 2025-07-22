import { createStore } from 'vuex'
import {getSessionStorage,setSessionStorage} from '@/utils/common.js'

export default createStore({
  state: {
      tabs:[
      
      ],

      //获取的菜单列表
      menus:getSessionStorage('menuList') || []
  },

  getters:{
      //获取所有的按钮
      tabs(state){
        return state.tabs;
      },

      //获取所有的路由子项目的菜单
      menus(state){
        return state.menus;
      }
  },

  //用于修改state状态
  mutations:{
      addMenus(state,param){
        state.menus=param;
        setSessionStorage('menuList',param);
      },

      //删除指定索引位置的一个标签页
      deleteTabByIndex(state,index){
        state.tabs.splice(index,1);
      },

      //清空按钮，重置标签页
      clearTab(state,param){
        state.tabs=param;
      },

      //向vuex中添加按钮内容
      addTab(state,payload){
          //取出path 路由路径
          let path=payload.path;

          //检查path是否为空
          if(path){
              //检查当前标签页中是否存在相同的path标签页
              let result=state.tabs.filter((item)=>{
                return item.path==path;
              });
              //判断是否存在,如果不存在则需要加入到state的标签页中
              if(result.length==0){
                  if(state.tabs.length==10){
                      //删除第2个标签页
                      state.tabs.splice(1,1);
                  }
                  state.tabs.push(payload);
              }
          }
      }
  },

  //处理异步操作
  actions:{

  },

  modules:{
    
  }

})
