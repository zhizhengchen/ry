<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="序号" prop="number">
        <el-input
          v-model="queryParams.number"
          placeholder="请输入序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="样品编号" prop="sampleNumber">
        <el-input
          v-model="queryParams.sampleNumber"
          placeholder="请输入样品编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="调查船" prop="investigationShip">
        <el-input
          v-model="queryParams.investigationShip"
          placeholder="请输入调查船"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="航次" prop="voyage">
        <el-input
          v-model="queryParams.voyage"
          placeholder="请输入航次"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="海域" prop="seaArea">
        <el-input
          v-model="queryParams.seaArea"
          placeholder="请输入海域"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="站位" prop="standingPosition">
        <el-input
          v-model="queryParams.standingPosition"
          placeholder="请输入站位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="X坐标" prop="xCoordinate">
        <el-input
          v-model="queryParams.xCoordinate"
          placeholder="请输入X坐标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Y坐标" prop="yCoordinate">
        <el-input
          v-model="queryParams.yCoordinate"
          placeholder="请输入Y坐标"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="结束深度" prop="endDepth">
        <el-input
          v-model="queryParams.endDepth"
          placeholder="请输入结束深度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="心长" prop="heartLength">
        <el-input
          v-model="queryParams.heartLength"
          placeholder="请输入心长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="存放位置" prop="storageLocation">
        <el-input
          v-model="queryParams.storageLocation"
          placeholder="请输入存放位置"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:sample:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:sample:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:sample:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:sample:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sampleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="ioId" />
      <el-table-column label="序号" align="center" prop="number" />
      <el-table-column label="样品编号" align="center" prop="sampleNumber" />
      <el-table-column label="调查船" align="center" prop="investigationShip" />
      <el-table-column label="航次" align="center" prop="voyage" />
      <el-table-column label="海域" align="center" prop="seaArea" />
      <el-table-column label="站位" align="center" prop="standingPosition" />
      <el-table-column label="X坐标" align="center" prop="xCoordinate" />
      <el-table-column label="Y坐标" align="center" prop="yCoordinate" />
      <el-table-column label="详细地址" align="center" prop="detailedAddress" />
      <el-table-column label="结束深度" align="center" prop="endDepth" />
      <el-table-column label="心长" align="center" prop="heartLength" />
      <el-table-column label="存放位置" align="center" prop="storageLocation" />
      <el-table-column label="保存状况" align="center" prop="preservationStatus" />
      <el-table-column label="备注" align="center" prop="remarks" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:sample:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:sample:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改样品信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="序号" prop="number">
          <el-input v-model="form.number" placeholder="请输入序号" />
        </el-form-item>
        <el-form-item label="样品编号" prop="sampleNumber">
          <el-input v-model="form.sampleNumber" placeholder="请输入样品编号" />
        </el-form-item>
        <el-form-item label="调查船" prop="investigationShip">
          <el-input v-model="form.investigationShip" placeholder="请输入调查船" />
        </el-form-item>
        <el-form-item label="航次" prop="voyage">
          <el-input v-model="form.voyage" placeholder="请输入航次" />
        </el-form-item>
        <el-form-item label="海域" prop="seaArea">
          <el-input v-model="form.seaArea" placeholder="请输入海域" />
        </el-form-item>
        <el-form-item label="站位" prop="standingPosition">
          <el-input v-model="form.standingPosition" placeholder="请输入站位" />
        </el-form-item>
        <el-form-item label="X坐标" prop="xCoordinate">
          <el-input v-model="form.xCoordinate" placeholder="请输入X坐标" />
        </el-form-item>
        <el-form-item label="Y坐标" prop="yCoordinate">
          <el-input v-model="form.yCoordinate" placeholder="请输入Y坐标" />
        </el-form-item>
        <el-form-item label="详细地址" prop="detailedAddress">
          <el-input v-model="form.detailedAddress" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="结束深度" prop="endDepth">
          <el-input v-model="form.endDepth" placeholder="请输入结束深度" />
        </el-form-item>
        <el-form-item label="心长" prop="heartLength">
          <el-input v-model="form.heartLength" placeholder="请输入心长" />
        </el-form-item>
        <el-form-item label="存放位置" prop="storageLocation">
          <el-input v-model="form.storageLocation" placeholder="请输入存放位置" />
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSample, getSample, delSample, addSample, updateSample } from "@/api/system/sample";

export default {
  name: "Sample",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 样品信息管理表格数据
      sampleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        number: null,
        sampleNumber: null,
        investigationShip: null,
        voyage: null,
        seaArea: null,
        standingPosition: null,
        xCoordinate: null,
        yCoordinate: null,
        detailedAddress: null,
        endDepth: null,
        heartLength: null,
        storageLocation: null,
        preservationStatus: null,
        remarks: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询样品信息管理列表 */
    getList() {
      this.loading = true;
      listSample(this.queryParams).then(response => {
        this.sampleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        ioId: null,
        number: null,
        sampleNumber: null,
        investigationShip: null,
        voyage: null,
        seaArea: null,
        standingPosition: null,
        xCoordinate: null,
        yCoordinate: null,
        detailedAddress: null,
        endDepth: null,
        heartLength: null,
        storageLocation: null,
        preservationStatus: null,
        remarks: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.ioId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加样品信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ioId = row.ioId || this.ids
      getSample(ioId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改样品信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ioId != null) {
            updateSample(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSample(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ioIds = row.ioId || this.ids;
      this.$modal.confirm('是否确认删除样品信息管理编号为"' + ioIds + '"的数据项？').then(function() {
        return delSample(ioIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/sample/export', {
        ...this.queryParams
      }, `sample_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
