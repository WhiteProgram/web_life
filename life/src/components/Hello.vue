<template>
  <div>
    <div class="block">
      <span class="demonstration">开始时间</span>
      <el-date-picker
        v-model="starTime"
        type="datetime"
        placeholder="选择日期时间"
        align="right"
        :picker-options="pickerOptions"
      >
      </el-date-picker>
    </div>
    <div class="block">
      <span class="demonstration">截至时间</span>
      <el-date-picker
        v-model="endTime"
        type="datetime"
        placeholder="选择日期时间"
        align="right"
        :picker-options="pickerOptions"
      >
      </el-date-picker>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        t: false,

      };
    },
    methods:{
    }
  };
</script>
