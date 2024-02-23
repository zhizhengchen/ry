package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Sample;
import com.ruoyi.system.service.ISampleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 样品信息管理Controller
 *
 * @author ruoyi
 * @date 2024-02-23
 */
@RestController
@RequestMapping("/system/sample")
public class SampleController extends BaseController {
    @Autowired
    private ISampleService sampleService;

    /**
     * 查询样品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sample:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sample sample) {
        startPage();
        List<Sample> list = sampleService.selectSampleList(sample);
        return getDataTable(list);
    }

    /**
     * 导出样品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sample:export')")
    @Log(title = "样品信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sample sample) {
        List<Sample> list = sampleService.selectSampleList(sample);
        ExcelUtil<Sample> util = new ExcelUtil<Sample>(Sample.class);
        util.exportExcel(response, list, "样品信息管理数据");
    }

    /**
     * 导入样品信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:sample:import')")
    @Log(title = "样品信息管理导入", businessType = BusinessType.IMPORT)
    @PostMapping("/import")
    public void _import(HttpServletResponse response, Sample sample) {
        List<Sample> list = sampleService.selectSampleList(sample);
        ExcelUtil<Sample> util = new ExcelUtil<Sample>(Sample.class);
        util.exportExcel(response, list, "样品信息管理数据");
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<Sample> util = new ExcelUtil<Sample>(Sample.class);
        util.importTemplateExcel(response, "样品信息");
    }
    @Log(title = "样品信息管理导入", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:sample:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Sample> util = new ExcelUtil<Sample>(Sample.class);
        List<Sample> sampleList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        System.out.println(sampleList);
        String message = sampleService.importSample(sampleList, updateSupport, operName);
        return success(message);
    }

    /**
     * 获取样品信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:sample:query')")
    @GetMapping(value = "/{ioId}")
    public AjaxResult getInfo(@PathVariable("ioId") Long ioId) {
        return success(sampleService.selectSampleByIoId(ioId));
    }

    /**
     * 新增样品信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:sample:add')")
    @Log(title = "样品信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sample sample) {
        return toAjax(sampleService.insertSample(sample));
    }

    /**
     * 修改样品信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:sample:edit')")
    @Log(title = "样品信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sample sample) {
        return toAjax(sampleService.updateSample(sample));
    }

    /**
     * 删除样品信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:sample:remove')")
    @Log(title = "样品信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ioIds}")
    public AjaxResult remove(@PathVariable Long[] ioIds) {
        return toAjax(sampleService.deleteSampleByIoIds(ioIds));
    }
}
