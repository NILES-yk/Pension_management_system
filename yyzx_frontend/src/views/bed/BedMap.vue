<template>
  <div class="main">
    <!-- 查询区域 -->
    <div class="query">
      <table class="query-table">
        <tbody>
          <tr>
            <td>
              <div class="query-form">
                <el-form :inline="true">
                  <el-form-item label="楼层：">
                    <el-select v-model="form.floor" @change="findBedUseVo" style="width: 140px;">
                      <el-option label="一楼" value="一楼" />
                      <el-option label="二楼" value="二楼" />
                    </el-select>
                  </el-form-item>
                </el-form>
              </div>
            </td>
            <td style="width: 160px;">
              <div class="counter-item">
                <img src="@/assets/bed/all.png" />
                <span class="counter-label">总床数:</span>
                <span class="counter-value">{{ count.zcw }}</span>
              </div>
            </td>
            <td style="width: 160px;">
              <div class="counter-item">
                <img src="@/assets/bed/kx.png" />
                <span class="counter-label">空闲:</span>
                <span class="counter-value">{{ count.kx }}</span>
              </div>
            </td>
            <td style="width: 160px;">
              <div class="counter-item">
                <img src="@/assets/bed/yr.png" />
                <span class="counter-label">有人:</span>
                <span class="counter-value">{{ count.yr }}</span>
              </div>
            </td>
            <td style="width: 160px;">
              <div class="counter-item">
                <img src="@/assets/bed/wc.png" />
                <span class="counter-label">外出:</span>
                <span class="counter-value">{{ count.wc }}</span>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- 平面图区域 -->
    <div class="map-section">
      <table class="bed-map-table">
        <thead>
          <tr class="room-header">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index < 1">
              {{ item.roomNo }}
            </td>
            <td class="facility" rowspan="2" style="background-color: #aaeeee; padding: 15px;">
              电梯厅
            </td>
            <td class="facility" rowspan="2" colspan="2" style="background-color: #9ac0cd; padding: 15px;">
              洗衣房
            </td>
            <td class="facility" rowspan="2" colspan="2" style="background-color: #4eee94; padding: 15px;">
              活动中心
            </td>
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index > 0 && index < 4">
              {{ item.roomNo }}
            </td>
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 4 && index < 6">
              {{ item.roomNo }}
            </td>
          </tr>
          <tr class="bed-row">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index < 6">
              <div class="bed-container">
                <div v-for="bedItem in item.bedList" :key="bedItem.bedNo" class="bed-item">
                  <img v-if="bedItem.bedStatus === 1" src="@/assets/bed/kx.png" class="bed-icon" />
                  <img v-if="bedItem.bedStatus === 2" src="@/assets/bed/yr.png" class="bed-icon" />
                  <img v-if="bedItem.bedStatus === 3" src="@/assets/bed/wc.png" class="bed-icon" />
                  <div class="bed-number">{{ bedItem.bedNo }}</div>
                </div>
              </div>
            </td>
          </tr>
        </thead>
        
        <!-- 走道区域 -->
        <tr class="corridor-row">
          <td colspan="11" style="background-color: #cdaa70; text-align: center; height: 40px; font-weight: bold; border: 1px solid #ddd;">
            走道
          </td>
        </tr>
        
        <tbody>
          <tr class="room-header">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 6">
              {{ item.roomNo }}
            </td>
          </tr>
          <tr class="bed-row">
            <td v-for="(item, index) in listRoom" :key="item.roomNo" v-show="index >= 6">
              <div class="bed-container">
                <div v-for="bedItem in item.bedList" :key="bedItem.bedNo" class="bed-item">
                  <img v-if="bedItem.bedStatus === 1" src="@/assets/bed/kx.png" class="bed-icon" />
                  <img v-if="bedItem.bedStatus === 2" src="@/assets/bed/yr.png" class="bed-icon" />
                  <img v-if="bedItem.bedStatus === 3" src="@/assets/bed/wc.png" class="bed-icon" />
                  <div class="bed-number">{{ bedItem.bedNo }}</div>
                </div>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import { findBedUseVo } from '@/api/bedApi.js';

  export default {
    name: 'BedMap',
    data() {
      return {
        form: {
          floor: '一楼'
        },
        count: {
          zcw: "",
          kx: "",
          yr: "",
          wc: ""
        },
        listRoom: []
      };
    },
    mounted() {
      this.findBedUseVo();
    },
    methods: {
      findBedUseVo() {
        findBedUseVo(this.form).then(res => {
          this.count.zcw = res.data.bedTotal;
          this.count.kx = res.data.bedAvailable;
          this.count.yr = res.data.bedOccupied;
          this.count.wc = res.data.bedOutward;
          this.listRoom = res.data.roomList;
        });
      }
    }
  };
</script>

<style scoped>
  .main {
    padding: 20px;
    background-color: #f9f9f9;
  }

  .query {
    margin-bottom: 20px;
    background-color: #fff;
    padding: 15px;
    border-radius: 6px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }

  .query-table {
    width: 100%;
    max-width: 1200px;
    margin: 0 auto;
  }

  .query-form {
    margin-top: 5px;
  }

  .counter-item {
    display: flex;
    align-items: center;
  }

  .counter-label {
    margin: 0 8px;
    font-weight: 500;
  }

  .counter-value {
    font-weight: bold;
    font-size: 16px;
  }

  .map-section {
    background-color: #fff;
    padding: 15px;
    border-radius: 6px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    overflow-x: auto;
  }

  .bed-map-table {
    width: 100%;
    min-width: 1400px;
    border-collapse: collapse;
  }

  .bed-map-table th, 
  .bed-map-table td {
    border: 1px solid #ddd;
    padding: 12px;
    vertical-align: top;
  }

  .room-header {
    background-color: #0168b7;
    color: white;
    text-align: center;
  }

  .bed-row {
    background-color: #f5f7fa;
  }

  .bed-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }

  .bed-item {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 8px;
    padding: 8px;
    border-radius: 4px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  }

  .bed-icon {
    width: 50px;
    height: 50px;
    object-fit: contain;
    margin-bottom: 6px;
  }

  .bed-number {
    font-size: 12px;
    font-weight: 500;
  }

  .facility {
    color: #333;
    font-weight: bold;
    text-align: center;
  }

  .corridor-row {
    font-weight: bold;
    color: #333;
    text-align: center;
  }
</style>