<template>
    <el-aside id="asideNav" width="200px">
        <el-menu
            active-text-color="#ffd04b"
            background-color="#3CA2E0"
            :default-active="$route.path"
            :router="true"
            unique-opened
            text-color="#fff">
            
            <!-- 使用menu作为一级菜单的变量名 -->
            <template v-for="menu in $store.getters.menus" :key="menu.id">
                <el-sub-menu :index="menu.menusIndex">
                    <template #title>
                        <el-icon>
                            <component :is="menu.icon" />
                        </el-icon>
                        <span>{{ menu.title }}</span>
                    </template>
                    
                    <!-- 使用child作为子菜单的变量名，避免冲突 -->
                    <template v-for="child in menu.children" :key="child.id">
                        <el-menu-item :index="child.path">
                            <el-icon><component :is="child.icon" /></el-icon>
                            {{ child.title }}
                        </el-menu-item>
                    </template>
                </el-sub-menu>
            </template>
        </el-menu>
    </el-aside>
</template>

<script>
export default {
  name: 'Aside',
  methods: {
    getMenuNameByUrl(url) {
      // 获取基础路径
      const basePath = url.split('?')[0];

      if (url.includes('/health/serviceBuy')) {
        return '购买护理服务';
      }

      if (window.history.state?.title) {
        return window.history.state.title;
      }
      
      // 尝试从路由配置获取
      try {
        const route = this.$router.resolve(basePath).route;
        if (route.meta?.title) {
          return route.meta.title;
        }
      } catch (e) {
        console.warn('路由解析失败:', e);
      }
      
      // 从菜单配置获取
      for (const menu of this.$store.getters.menus) {
        for (const child of menu.children) {
          if (child.path === basePath) {
            return child.title;
          }
          // 处理动态路由
          if (child.path.includes(':') && 
              basePath.startsWith(child.path.split(':')[0])) {
            return child.title;
          }
        }
      }
      
      // 根据常见路径返回友好名称
      if (basePath.includes('userToCustomerService')) {
        return '客户服务分配';
      }
      
      return '未知菜单';
    }
  },
  watch: {
    "$route.path": {
      handler: function(newValue) {
        let index = this.$store.getters.tabs.findIndex(value => value.path === newValue);
        
        if (index !== -1 || newValue === "/login") {
          return;
        }
        
        const menuName = this.getMenuNameByUrl(newValue);
        
        this.$store.commit("addTab", {
          title: menuName,
          path: newValue
        });
      },
      immediate: true
    }
  }
}

</script>

<style scoped>
    #asideNav {
        display: flex;
        flex-direction: column;
    }

    #asideNav .logo-name {
        width: 100%;
        height: 150px;
        background-color:#3CA2E0;
    }

    #asideNav .logo-name .logo-png{
        width: 165px;
        height: 165px;
        margin: -30px 0 0 10px;
    }

    #asideNav .logo-name p {
        font-weight: 800;
        height: 50px;
        line-height: 50px;
        text-align: center;
        font-size: 25px;
        margin: 0px;
        color: #fff;
    }

    #asideNav .el-menu {
        /* font-weight: 550; */
        flex: 1;
        border-right: none;
    }
</style>