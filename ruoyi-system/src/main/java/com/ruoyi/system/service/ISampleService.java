package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Sample;

/**
 * 样品信息管理Service接口
 * 
 * @author ruoyi
 * @date 2024-02-23
 */
public interface ISampleService 
{
    /**
     * 查询样品信息管理
     * 
     * @param ioId 样品信息管理主键
     * @return 样品信息管理
     */
    public Sample selectSampleByIoId(Long ioId);

    /**
     * 查询样品信息管理列表
     * 
     * @param sample 样品信息管理
     * @return 样品信息管理集合
     */
    public List<Sample> selectSampleList(Sample sample);

    /**
     * 新增样品信息管理
     * 
     * @param sample 样品信息管理
     * @return 结果
     */
    public int insertSample(Sample sample);

    /**
     * 修改样品信息管理
     * 
     * @param sample 样品信息管理
     * @return 结果
     */
    public int updateSample(Sample sample);

    /**
     * 批量删除样品信息管理
     * 
     * @param ioIds 需要删除的样品信息管理主键集合
     * @return 结果
     */
    public int deleteSampleByIoIds(Long[] ioIds);

    /**
     * 删除样品信息管理信息
     * 
     * @param ioId 样品信息管理主键
     * @return 结果
     */
    public int deleteSampleByIoId(Long ioId);

    String importSample(List<Sample> sampleList, boolean updateSupport, String operName);
}
