<template>
    <div class="commom-layout">
        <el-container>
            <el-header>
                <div>
                    <el-row :gutter="30">
                        <el-col :span="7">
                            <el-input
                                placeholder="请输入查询的客户名称"
                                v-model="condition.customerName"
                                @clear="query"
                                clearable
                                size="large">
                                    <template #append>
                                        <el-button type="info" @click="query" style="color:black">查询</el-button>
                                    </template>
                            </el-input>

                        </el-col>
                    </el-row>
                </div>
            </el-header>

            <!-- 分隔线 -->
            <el-divider style="margin:20px;"></el-divider>

            <el-main>
                <el-row :gutter="20">
                    <!-- 分隔两个区域 -->
                    <el-col :span="9">
                        <div class="table-main">
                            <div class="table-main-header">客户信息</div>
                                <el-table
                                    :data="customerInfoList"
                                    highlight-current-row
                                    @current-change="handleChangeCustomer"
                                    size="small"
                                    style="width: 100%; color:black;"
                                    stripe>
                                       <el-table-column 
                                                align="center"
                                                fixed
                                                type="index"
                                                :index="indexMethod"
                                                label="序号"
                                                width="40"
                                        />
                                       <el-table-column align="center" prop="customerName" label="姓名"/>
                                       <el-table-column align="center" prop="customerAge" label="联系方式"/>
                                       <el-table-column align="center" prop="customerSex" label="性别">
                                            <template #default="scoped">{{scoped.row.customerSex==0?'男':'女'}}</template>
                                       </el-table-column>
                                       <el-table-column align="center" prop="bedNo" label="床号" width="90"/>
                                       <el-table-column align="center" prop="levelName" label="护理级别"/>
                                </el-table>
                                <!-- 分页插件 自定义分页属性 -->
                                 <div style="margin-top: 15px;">
                                    <el-pagination
                                        :page-size="page.pageSize"
                                        background
                                        :current-page="page.current"
                                        layout="prev,pager,next"
                                        :total="page.total"
                                        @current-change="handleCurrentChange"
                                    />
                                 </div>
                        </div>
                    </el-col>

                    <el-col :span="15">
                        <div class="table-main">
                        <div class="table-main-header">护理记录</div>
                            <el-table :data="nurseRecordList"  size="small">
                                <el-table-column
                                    align:="center"
                                    :index="indexethodRecord"
                                    type="index"
                                    label="序号" 
                                    width="40"
                                />
                                <el-table-column align="center" prop="serialNumber" label="护理项目编号" width="100"/>
                                <el-table-column align="center" prop="nursingName" label="护理项目名称" width="100"/>
                                <el-table-column align="center" prop="nursingCount" label="护理数量" width="70"/>
                                <el-table-column align="center" prop="nursingContent" label="护理内容" width="100"/>
                                <el-table-column align="center" prop="nickName" label="护理人员" width="80"/>
                                <el-table-column align="center" prop="phoneNumber" label="护理人员号码" width="100"/>
                                <el-table-column align="center" prop="nursingTime" label="护理时间" width="100"/>

                                <el-table-column align="center" label="操作" width="100"> 
                                    <template #default="scope"> 
                                        <el-button type="danger" size="small" round plain @click="del(scope.row.id)">删除</el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                            <div style="margin-top:15px" v-if="nurseRecordList.length>0">
                                <el-pagination
                                    :page-size="pageRecord.pageSize"
                                    background
                                    :current-page="pageRecord.current"
                                    layout="prev, pager, next"
                                    :total="pageRecord.total"
                                    @current-change="handleRecordChange"
                                    />
                            </div>
                        </div>
                    </el-col>
                </el-row>
            </el-main>
        </el-container>   
    </div>
  
</template>

<script>
    import {listCustomerInfoPage} from '@/api/customerApi'
    import {queryNurseRecordPage,removeNurseRecord} from '@/api/nurseRecordApi.js'
    export default{
        //挂载 只要加载这个页面就执行下面的方法
        mounted(){
            this.listCustomerInfoPage();
        },

        //定义计算属性
        computed:{
            //客户分页序号-不重复
            indexMethod(){
                return this.page.current*this.page.size-this.page.size+1;
            },

            //护理记录分页序号
            indexMethodRecord(){
                return this.page.current*this.page.size-this.page.size+1;
            }
        },
        data(){
            return{
                nurseRecordList:[],
                customerInfoList:[],
                //查询封装的护理记录
                conditionRecord:{
                    customerId:"",//客户编号
                    pageSize:"1" //页码 默认第一页
                },
                //查询客户封装信息
                condition:{
                    customerName:"",//客户姓名
                    pageSize:"1"
                },

                //分页属性封装对象 客户信息
                page:{
                    total:0,
                    pageSize:6,
                    current:1,
                    pageCount:0
                },
                //分页属性封装对象 护理记录
                pageRecord:{
                    total:0,
                    pageSize:6,
                    current:1,
                    pageCount:0
                },
            }
        },

        methods:{
            //点击查询用户信息
            query(){
                //清空护理记录数据表
                this.nurseRecordList=[]
                this.conditionRecord.customerId="";
                this.condition.pageSize="1";
                this.listCustomerInfoPage();
            },

            //选中某一行客户，获取用户的服务项目列表
            handleChangeCustomer(row){
                if(row!=null){
                    //点击页码，会清空row,构建查询的条件
                    this.conditionRecord.customerId=row.id;
                    this.queryNurseRecordPage();

                }
            },

            //选中页码-客户
            handleCurrentChange(current){
                this.page.current=current;
                this.condition.pageSize=current; //pageSize是服务端接收参数名
                //重新渲染表格
                this.listCustomerInfoPage();
                //清空记录数据列表
                this.nurseRecordList=[];
                this.conditionRecord.customerId="";
            },

            

            //api 获取护理项目内容
            queryNurseRecordPage(){
                queryNurseRecordPage(this.conditionRecord).then(res=>{
                    console.log(res);
                    this.nurseRecordList=res.data.records;
                })
            },

            //api 分页查询客户信息列表
             listCustomerInfoPage(){
                listCustomerInfoPage(this.condition).then(res=>{
                    console.log("============>",res);
                    this.customerInfoList=res.data.records; //客户信息列表
                    this.page.total=res.data.total; //总记录数
                    this.page.size=res.data.size; //每页记录数
                    this.page.current=res.data.current; //当前页码
                    this.page.pageCount=res.data.pages; //总页数
                })
            },

            del(id){
                this.$confirm("此操作将永久删除，是否继续？","提示",{
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(()=>{
                    removeNurseRecord({id:id}).then((res)=>{
                        if(res.flag){
                            this.$message({
                                type: "success",
                                message: res.message
                            });
                            //重载表格
                            this.queryNurseRecordPage();
                        }
                       
                    })
                }).catch(()=>{})
            },
        }

    }
</script>

<style scoped>
    .table-main {
        height: 500px;
        border: 1px solid #d4c5c5;
    }
    .table-main .table-main-header {
        height: 50px;
        background-color: #3ca2e0;
        color: #fff;
        font-size: 20px;
        font-family: "Microsoft YaHei";
        line-height: 50px;
        text-align: center;
    }
</style>