package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Sample;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-02-23
 */
public interface SampleMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param ioId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public Sample selectSampleByIoId(Long ioId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param sample 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<Sample> selectSampleList(Sample sample);

    /**
     * 新增【请填写功能名称】
     * 
     * @param sample 【请填写功能名称】
     * @return 结果
     */
    public int insertSample(Sample sample);

    /**
     * 修改【请填写功能名称】
     * 
     * @param sample 【请填写功能名称】
     * @return 结果
     */
    public int updateSample(Sample sample);

    /**
     * 删除【请填写功能名称】
     * 
     * @param ioId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteSampleByIoId(Long ioId);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ioIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSampleByIoIds(Long[] ioIds);
}
