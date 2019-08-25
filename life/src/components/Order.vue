<template>
  <div>
    <div v-show="!sh">
      <el-col :span="6">
        <div style="float: left;margin-left: 6px;">
          <el-button type="success" icon="el-icon-refresh-left" @click="list(currentPage,pageSize)">刷新</el-button>
          <el-button type="primary" plain @click="sh =true">添加</el-button>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="block">
          <span class="demonstration">开始时间</span>
          <el-date-picker
            v-model="starTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            :picker-options="pickerOptions"
            :default-value="defaultTime"
          >
          </el-date-picker>
        </div>
      </el-col>
      <el-col :span="5">
        <div class="block">
          <span class="demonstration">截至时间</span>
          <el-date-picker
            v-model="endTime"
            type="datetime"
            placeholder="选择日期时间"
            align="right"
            :picker-options="pickerOptions"
            :default-value="defaultTime"
          >
          </el-date-picker>
        </div>
      </el-col>
      <el-col :span="2">
        <el-button type="primary" @click="sPrice">
          <i class="el-icon-search"></i>
          统计支出
        </el-button>
      </el-col>
      <el-col :span="2">
        <span style="line-height: 40px;">支出：{{sumPrice}}</span>
      </el-col>
    </div>
    <el-form ref="form" label-width="80px" style="margin-top: 20px" v-show="sh">
      <el-form-item label="id">
        <el-col :span="6">
          <el-input v-model="order.id"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="消费金额">
        <el-col :span="6">
          <el-input v-model="order.fee" placeholder="请输入消费金额"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="消费备注">
        <el-col :span="6">
          <el-input v-model="order.marks" placeholder="请输入消费备注"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="消费者">
        <el-col :span="6">
          <el-input v-model="order.username" placeholder="消费者名称"></el-input>
        </el-col>
      </el-form-item>
      <el-form-item label="消费时间">
        <el-col :span="6">
          <div class="block">
            <el-date-picker
              v-model="order.createdTime"
              type="datetime"
              placeholder="选择日期时间"
              align="right"
              :picker-options="pickerOptions"
              :default-value="defaultTime"
            >
            </el-date-picker>
          </div>
        </el-col>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="save">保存</el-button>
        <el-button type="info" plain @click="closeSave">取消</el-button>
      </el-form-item>
    </el-form>
    <div v-show="!sh">
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="ID"
          width="100"
          >
        </el-table-column>
        <el-table-column
          prop="marks"
          label="消费备注">
        </el-table-column>
        <el-table-column
          prop="fee"
          label="消费金额">
        </el-table-column>
        <el-table-column
          prop="username"
          label="消费者">
        </el-table-column>
        <el-table-column
          prop="createdTime"
          :formatter="myDate"
          label="消费时间">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="200">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="primary" size="small" icon="el-icon-edit">编辑</el-button>
            <el-button type="danger" @click="del(scope.row.id)" size="small" icon="el-icon-delete">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size="pageSize"
        :total="pageSize * totalPages" @current-change="change">
      </el-pagination>
    </div>
  </div>
</template>

<script>


  import {myformatDate} from "../assets/js/Common";

  export default {
    data() {
      return {
        defaultTime: new Date(),
        sh:false,
        order:{
          id: '',
          name: '',
          fee: '',
          marks: '',
          status: 1,
          createdTime: '',
          username:'Mingjie'
        },
        currentPage:1,
        pageSize:10,
        totalPages:1,
        tableData: [
          {
            id: '2016-05-02',
            name: '王小虎',
            fee: '上海市普陀区金沙江路 1518 弄',
            username:'Mingjie',
            createdTime:0,
          }
        ],
        starTime: '',
        endTime: '',
        pickerOptions: {
          shortcuts: [{
            text: '今天',
            onClick(picker) {
              picker.$emit('pick', new Date());
            }
          }, {
            text: '昨天',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit('pick', date);
            }
          }, {
            text: '一周前',
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit('pick', date);
            }
          }]
        },
        sumPrice:0
      }
    },
    mounted() {
      this.list(1,this.pageSize)
    },
    methods:{
      initData(){
        this.sh = false
        this.order.id = ''
        this.order.name = ''
        this.order.fee = ''
        this.order.marks = '',
        this.order.status = '1',
        this.order.username = 'Mingjie'
      },
      save(){
        console.log(this.order)
        this.$axios.post("http://localhost:8080/admin/order/save",this.$qs.stringify({
          id: this.order.id,
          name: this.order.name,
          fee: this.order.fee,
          status: this.order.status,
          marks: this.order.marks,
          createdTime: Math.ceil(this.order.createdTime/1000),
          username: this.order.username
        })).then(res =>{
          this.initData()
          this.$notify({
            title: '成功',
            message: res.data.data,
            type: 'success'
          });
          this.list(this.currentPage,this.pageSize)
        })
      },
      list(page,size){
        this.$axios({
          method: 'get',
          url: "http://localhost:8080/admin/order",
          params:{
            page:page,
            size:size
          }
        }).then(res =>{
          this.tableData = res.data.data.content;
          this.totalPages = res.data.data.totalPages;
        })
      },
      change(event){
        this.currentPage = event;
        this.list(event,this.pageSize);
      },

      handleClick(row){
        this.sh = true
        this.order = row
          this.order.createdTime = row.createdTime * 1000;
      },

      del(id){
        this.$confirm('你正在进行删除操作, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$axios.post(this.$url + '/admin/order/delete',this.$qs.stringify({
            ids: id,
            status: 0
          })).then(res=>{
            this.list(1,this.pageSize)
            this.$message({
              type: 'success',
              message: res.data.data
            });
          })


        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      sPrice(){
        this.$axios({
          url: this.$url + '/admin/order/priceOut',
          params: {
            startTime: Math.ceil(this.starTime/1000),
            endTime: Math.ceil(this.endTime/1000)
          }
        }).then(res =>{
          this.sumPrice = res.data.data
        })
      },
      myDate(row,column){
        return myformatDate(row.createdTime)
      },
        closeSave(){
          this.sh = false
            this.order.createdTime = this.order.createdTime/1000;
        }

    }
  }
</script>
<style>
  .el-table{
    margin-top: 20px;
  }
</style>
