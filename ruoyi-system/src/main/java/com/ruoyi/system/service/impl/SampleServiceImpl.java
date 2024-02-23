package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.domain.Sample;
import com.ruoyi.system.mapper.*;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.service.ISampleService;

import javax.annotation.Resource;
import javax.validation.Validator;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2024-02-23
 */
@Service
public class SampleServiceImpl implements ISampleService {
    @Resource
    private SampleMapper sampleMapper;

    @Resource
    private SysUserMapper userMapper;

    @Resource
    private SysRoleMapper roleMapper;

    @Resource
    private SysPostMapper postMapper;

    @Resource
    private SysUserRoleMapper userRoleMapper;

    @Resource
    private SysUserPostMapper userPostMapper;

    @Resource
    private ISysConfigService configService;

    @Resource
    protected Validator validator;

    /**
     * 查询【请填写功能名称】
     *
     * @param ioId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public Sample selectSampleByIoId(Long ioId) {
        return sampleMapper.selectSampleByIoId(ioId);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param sample 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<Sample> selectSampleList(Sample sample) {
        return sampleMapper.selectSampleList(sample);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sample 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSample(Sample sample) {
        return sampleMapper.insertSample(sample);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sample 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSample(Sample sample) {
        return sampleMapper.updateSample(sample);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param ioIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSampleByIoIds(Long[] ioIds) {
        return sampleMapper.deleteSampleByIoIds(ioIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param ioId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteSampleByIoId(Long ioId) {
        return sampleMapper.deleteSampleByIoId(ioId);
    }

    @Override
    public String importSample(List<Sample> sampleList, boolean updateSupport, String operName) {
        if (StringUtils.isNull(sampleList) || sampleList.size() == 0) {
            throw new ServiceException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //插入
        for (Sample sample : sampleList) {
//            sample = new Sample(sample);
            if (sampleMapper.insertSample(sample) == 0) {
                failureNum++;
            } else {
                successNum++;
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
