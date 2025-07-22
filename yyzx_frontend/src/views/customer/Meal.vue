<template>
  <div class="common-layout">
    <el-container>
      <el-header>
        <div>
          <el-row :gutter="30">
            <el-col :span="17">
              <el-button type="primary" @click="addItem" color="#337ab7" style="margin-top:4px">
                <el-icon>
                  <Plus />
                </el-icon>
                <span>添加</span>
              </el-button>
            </el-col>
          </el-row>
        </div>
      </el-header>
      <el-divider style="margin:0"></el-divider>
      <el-main>
          <el-tabs type="border-card" @tab-click="handleTabClick" v-model="queryParams.weekDay">
            <el-tab-pane v-for="(week,index) in weekdayList" :label="week" :name="week" :key="index" >
				<div v-if="queryParams.weekDay == week">
					<el-row :gutter="20"  class="row"  v-if="queryParams.weekDay == week">
						<el-col :span="2" class="mealType">
							<span>{{changeType(1)}}早<br/>餐</span>
						</el-col>
					    <el-col
					      v-for="(meal, index) in breakfastList"
					      :key="meal.id"
					      :span="4"
						  class="food"
					    >
					      <el-card :body-style="{ padding: '15px' }" class="card"  shadow="hover" >
							  <el-tag class="ml-2 taste" v-if="meal.taste=='正常'" type="">{{meal.taste}}</el-tag>
							  <el-tag class="ml-2 taste" v-if="meal.taste=='多糖'" type="warning">{{meal.taste}}</el-tag>
							  <el-tag class="ml-2 taste" v-if="meal.taste=='少糖'" type="success">{{meal.taste}}</el-tag>
							  <el-tag class="ml-2 taste" v-if="meal.taste=='多盐'" type="warning">{{meal.taste}}</el-tag>
							  <el-tag class="ml-2 taste" v-if="meal.taste=='少盐'" type="success">{{meal.taste}}</el-tag>
							  <el-icon class="edit" @click="edit(meal,1)"><EditPen /></el-icon>
							  <el-icon class="close" @click="del(meal.id,1)"><Close /></el-icon>
							<img
					          :src="foodFullImg(meal.foodImg)"
					          class="image"
					        />
					        <div style="padding: 14px;">
					          <el-row><el-col>类别：{{meal.foodType}}</el-col></el-row>
					          <el-row><el-col>名称：{{meal.foodName}}</el-col></el-row>
					          <el-row><el-col>价格：{{meal.price}}元</el-col></el-row>
					          <el-row><el-col>是否清真：
								<span v-if="meal.isHalal">是</span>
								<span v-else>否</span>
							  </el-col></el-row>
					        </div>
							</el-card>
					    </el-col>
					  </el-row>
					  <el-row :gutter="20"  class="row"  v-if="queryParams.weekDay == week">
					  	<el-col :span="2" class="mealType">
					  		<span>{{changeType(2)}}午<br/>餐</span>
					  	</el-col>
					      <el-col
					        v-for="(meal, index) in lunchList"
					        :key="meal.id"
					        :span="4"
					  	  class="food"
					      >
					        <el-card :body-style="{ padding: '15px' }" class="card"  shadow="hover" >
					  		  <el-tag class="ml-2 taste" v-if="meal.taste=='正常'" type="">{{meal.taste}}</el-tag>
					  		  <el-tag class="ml-2 taste" v-if="meal.taste=='多糖'" type="warning">{{meal.taste}}</el-tag>
					  		  <el-tag class="ml-2 taste" v-if="meal.taste=='少糖'" type="success">{{meal.taste}}</el-tag>
					  		  <el-tag class="ml-2 taste" v-if="meal.taste=='多盐'" type="warning">{{meal.taste}}</el-tag>
					  		  <el-tag class="ml-2 taste" v-if="meal.taste=='少盐'" type="success">{{meal.taste}}</el-tag>
					  		  <el-icon class="edit" @click="edit(meal,2)"><EditPen /></el-icon>
					  		  <el-icon class="close" @click="del(meal.id,2)"><Close /></el-icon>
					  		<img
					            :src="foodFullImg(meal.foodImg)"
					            class="image"
					          />
					          <div style="padding: 14px;">
					            <el-row><el-col>类别：{{meal.foodType}}</el-col></el-row>
					            <el-row><el-col>名称：{{meal.foodName}}</el-col></el-row>
					            <el-row><el-col>价格：{{meal.price}}元</el-col></el-row>
					            <el-row><el-col>是否清真：
					  			<span v-if="meal.isHalal">是</span>
					  			<span v-else>否</span>
					  		  </el-col></el-row>
					          </div>
					  		</el-card>
					      </el-col>
					    </el-row>
						<el-row :gutter="20"  class="row"  v-if="queryParams.weekDay == week">
							<el-col :span="2" class="mealType">
								<span>{{changeType(3)}}晚<br/>餐</span>
							</el-col>
						    <el-col
						      v-for="(meal, index) in dinnerList"
						      :key="meal.id"
						      :span="4"
							  class="food"
						    >
						      <el-card :body-style="{ padding: '15px' }" class="card"  shadow="hover" >
								  <el-tag class="ml-2 taste" v-if="meal.taste=='正常'" type="">{{meal.taste}}</el-tag>
								  <el-tag class="ml-2 taste" v-if="meal.taste=='多糖'" type="warning">{{meal.taste}}</el-tag>
								  <el-tag class="ml-2 taste" v-if="meal.taste=='少糖'" type="success">{{meal.taste}}</el-tag>
								  <el-tag class="ml-2 taste" v-if="meal.taste=='多盐'" type="warning">{{meal.taste}}</el-tag>
								  <el-tag class="ml-2 taste" v-if="meal.taste=='少盐'" type="success">{{meal.taste}}</el-tag>
								  <el-icon class="edit" @click="edit(meal,3)"><EditPen /></el-icon>
								 <el-icon class="close" @click="del(meal.id,3)"><Close /></el-icon>
								<img
						          :src="foodFullImg(meal.foodImg)"
						          class="image"
						        />
						        <div style="padding: 14px;">
						          <el-row><el-col>类别：{{meal.foodType}}</el-col></el-row>
						          <el-row><el-col>名称：{{meal.foodName}}</el-col></el-row>
						          <el-row><el-col>价格：{{meal.price}}元</el-col></el-row>
						          <el-row><el-col>是否清真：
									<span v-if="meal.isHalal">是</span>
									<span v-else>否</span>
								  </el-col></el-row>
						        </div>
								</el-card>
						    </el-col>
						  </el-row>
				</div>
			</el-tab-pane>
          </el-tabs>
      </el-main>
    </el-container>
    <!-- 修改/添加对话框 -->
    <el-dialog
      v-model="dialog.dialogVisible"
      :title="dialog.tops"
      width="40%"
      align-center
      draggable
      :before-close="handleClose"
    >
      <el-divider border-style="double" style="margin:0;" />
      <el-form
        label-position="right"
        label-width="auto"
        style="max-width:380px;margin:20px auto"
        class="demo-form-inline"
        ref="itemForm"
        :model="dialog.item"
        :rules="rules"
      >
        <el-form-item label="膳食类型：" prop="mealType">
        	<el-select v-model="dialog.item.mealType" style="width:320px" placeholder="餐饮类型：">
        	  <el-option v-for="item in mealTypeList" :label="item.mealTypeName" :value="item.typeId" />
        	</el-select>
        </el-form-item>
		<el-form-item label="食品名称：" prop="foodId">
			<el-select v-model="dialog.item.foodId" style="width:320px" placeholder="食品名称：">
			  <!-- 修复：使用安全访问符 ?. 防止 foodName 为 null -->
			  <el-option v-for="item in foodList" :label="item?.foodName || ''" :value="item.id" />
			</el-select>
		</el-form-item>
        <el-form-item label="星期：" prop="weekDay">
		  <el-select v-model="dialog.item.weekDay" style="width:320px" placeholder="星期：">
		    <el-option value="周一" />
			<el-option value="周二" />
			<el-option value="周三" />
			<el-option value="周四" />
			<el-option value="周五" />
			<el-option value="周六" />
			<el-option value="周日" />
		  </el-select>
        </el-form-item>
        <el-form-item label="口味：" prop="taste">
		  <el-select v-model="dialog.item.taste" style="width:320px" placeholder="口味：">
		    <el-option value="正常" />
			<el-option value="多糖" />
			<el-option value="少糖" />
			<el-option value="多盐" />
			<el-option value="少盐" />
		  </el-select>
        </el-form-item>
      </el-form>
      <el-divider border-style="double" style="margin:0;" />
      <template #footer>
        <span class="dialog-footer" style="padding-top: 0px">
          <el-button type="primary" @click="save('itemForm')">保存</el-button>
          <el-button @click="cancel">取消</el-button>
        </span>
      </template>
    </el-dialog>
  </div>
</template>

<script>
import {
 addMeal,
 updateMeal,
 removeMeal,
 queryMealPage
} from "@/api/mealApi.js";
import { queryFoodList } from "@/api/foodApi.js";

export default {
  data() {
    return {
      // 表单验证规则
      rules: {
        mealType: [
          { required: true, message: '请选择膳食类型', trigger: 'change' }
        ],
        foodId: [
          { required: true, message: '请选择食品', trigger: 'change' }
        ],
        weekDay: [
          { required: true, message: '请选择星期', trigger: 'change' }
        ],
        taste: [
          { required: true, message: '请选择口味', trigger: 'change' }
        ]
      },
      
      mealTypeList: [
        {typeId:1, mealTypeName:'早餐'},
        {typeId:2, mealTypeName:'午餐'},
        {typeId:3, mealTypeName:'晚餐'}
      ],
      weekdayList: ['周一','周二','周三','周四','周五','周六','周日'],
      foodList: [],
      
      // 模态框数据
      dialog: {
        dialogVisible: false,
        tops: "",
        item: {
          id: "",
          foodId: "",
          foodName: "",
          foodType: "",
          price: "",
          isHalal: "",
          weekDay: "周一",  // 设置默认值
          mealType: 1,     // 设置默认值
          taste: "正常",   // 设置默认值
          isDeleted: 0
        }
      },
      
      queryParams: {
        mealType: 1,
        weekDay: "周一",
        pageSize: "1"
      },
      
      breakfastList: [],
      lunchList: [],
      dinnerList: []
    };
  },
  
  mounted() {
    this.getFoodList();
    this.getMealList(1);
    this.getMealList(2);
    this.getMealList(3);
  },
  
  watch: {
    'queryParams.weekDay'(newVal) {
      this.getMealList(1);
      this.getMealList(2);
      this.getMealList(3);
    }
  },
  
  methods: {
		foodFullImg(foodImg) {
		if (!foodImg) {
		return require('@/assets/food/default-food.png'); // 默认图片
		}
		
		try {
		// 尝试动态加载图片
		return require(`@/assets/food/${foodImg}`);
		} catch (e) {
		console.error('图片加载失败:', e);
		return require('@/assets/food/default-food.png'); // 加载失败时返回默认图片
		}
	},
    
    // 点击添加按钮 - 完全重写
    async addItem() {
      this.dialog.tops = "添加膳食管理";
      this.dialog.dialogVisible = true;
      
      // 重置表单数据
      this.dialog.item = {
        id: "",
        foodId: "",
        foodName: "",
        foodType: "",
        price: "",
        isHalal: "",
        weekDay: "周一",  // 设置默认值
        mealType: 1,     // 设置默认值
        taste: "正常",   // 设置默认值
        isDeleted: 0
      };
      
      // 确保食品列表已加载
      if (this.foodList.length === 0) {
        await this.getFoodList();
      }
      
      // 确保表单已渲染
      this.$nextTick(() => {
        if (this.$refs.itemForm) {
          // 重置表单验证状态
          this.$refs.itemForm.resetFields();
        }
      });
    },
    
    // 重置表单 - 安全版本
    resetForm(formName) {
      if (this.$refs[formName]) {
        this.$refs[formName].resetFields();
      }
    },
    
    // 点击修改
    edit(meal, mealType) {
      if (!meal) return;
      
      this.dialog.tops = "修改膳食日历";
      this.dialog.dialogVisible = true;
      
      // 使用安全赋值
      this.dialog.item = {
        ...meal,
        mealType: mealType
      };
    },
    
    handleClose() {
      this.dialog.dialogVisible = false;
      this.resetForm("itemForm");
    },
    
    cancel() {
      this.handleClose();
    },
    
    // 保存操作
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          const operation = this.dialog.item.id 
            ? updateMeal(this.dialog.item)
            : addMeal(this.dialog.item);
            
          operation.then(res => {
            if (res.flag) {
              this.$message.success(res.message);
              this.getMealList(this.dialog.item.mealType);
              this.handleClose();
            } else {
              this.$message.error(res.message);
            }
          });
        }
      });
    },
    
    // 删除操作
    del(id, mealType) {
      this.$confirm("此操作将删除记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        removeMeal({ id }).then(res => {
          if (res.flag) {
            this.$message.success(res.message);
            this.getMealList(mealType);
          } else {
            this.$message.error(res.message);
          }
        });
      }).catch(() => {});
    },
    
    // 查询膳食日历 - 添加空值处理
    async getMealList(typeId) {
      this.queryParams.mealType = typeId;
      
      try {
        const res = await queryMealPage(this.queryParams);
        const records = res.data?.records || [];
        
        // 过滤空值
        const filteredRecords = records.filter(item => 
          item && item.foodName !== null && item.foodName !== undefined
        );
        
        if (typeId === 1) {
          this.breakfastList = filteredRecords;
        } else if (typeId === 2) {
          this.lunchList = filteredRecords;
        } else {
          this.dinnerList = filteredRecords;
        }
      } catch (error) {
        console.error("获取膳食数据失败:", error);
        this.$message.error("获取数据失败");
      }
    },
    
    // 查询食品列表 - 添加空值处理
    // 查询食品列表 - 正确处理API响应
	getFoodList() {
	queryFoodList().then(res => {
		// 假设API返回结构为 { data: [...] }
		const data = res.data || [];
		
		// 过滤掉无效项
		this.foodList = data.filter(
		item => item && item.foodName !== null && item.foodName !== undefined
		);
	}).catch(error => {
		console.error("获取食品列表失败:", error);
		this.$message.error("获取食品列表失败");
	});
	},
    
    handleTabClick(tab) {
      const index = tab.index;
      if (index >= 0 && index < this.weekdayList.length) {
        this.queryParams.weekDay = this.weekdayList[index];
      }
    },
    
    changeType(typeId) {
      this.queryParams.mealType = typeId;
    }
  }
};
</script>

<style scoped>
/* 原有样式保持不变 */
.activeBtn {
  color: #1890ff;
  background: rgb(232, 244, 255);
}

.time {
  font-size: 12px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.button {
  padding: 0;
  min-height: auto;
}
.card{
	height: 80%;
	position: relative;
	cursor: pointer;
	font-size: 14px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.image {
  width: 100%;
  display: block;
  width:160px;
  height: 160px;
  margin-top: 20px;
}

.edit{
	position: absolute;
	right: 20px;
	top:5px;
	font-size: 20px;
}
.close{
	position: absolute;
	right: 5px;
	top: 5px;
	font-size: 20px;
}

.taste{
	position: absolute;
	left: 5px;
	top: 5px;
}
.row{
	border: 1px solid #eee; 
	margin-top: 20px;
	box-shadow: 5px 5px #eee;
	height: 300px;
}
.mealType{
	color: #fff;
	background-color: #337ab7;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 300px;
}
.food{
	display: flex;
	justify-content: center; 
	align-items: center;
	margin-left: 15px;
}
.nofood{
	width: 400px;
	height: 300px;
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>