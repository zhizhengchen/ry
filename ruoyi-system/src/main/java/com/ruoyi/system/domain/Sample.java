package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 样品信息管理对象 sample
 *
 * @author ruoyi
 * @date 2024-02-23
 */
public class Sample extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long ioId;

    /**
     * 序号
     */
    @Excel(name = "序号")
    private Long number;

    /**
     * 样品编号
     */
    @Excel(name = "样品编号")
    private String sampleNumber;

    /**
     * 调查船
     */
    @Excel(name = "调查船")
    private String investigationShip;

    /**
     * 航次
     */
    @Excel(name = "航次")
    private String voyage;

    /**
     * 海域
     */
    @Excel(name = "海域")
    private String seaArea;

    /**
     * 站位
     */
    @Excel(name = "站位")
    private String standingPosition;

    /**
     * X坐标
     */
    @Excel(name = "X坐标")
    private Long xCoordinate;

    /**
     * Y坐标
     */
    @Excel(name = "Y坐标")
    private Long yCoordinate;

    /**
     * 详细地址
     */
    @Excel(name = "详细地址")
    private String detailedAddress;

    /**
     * 结束深度
     */
    @Excel(name = "结束深度")
    private Long endDepth;

    /**
     * 心长
     */
    @Excel(name = "心长")
    private Long heartLength;

    /**
     * 存放位置
     */
    @Excel(name = "存放位置")
    private String storageLocation;

    /**
     * 保存状况
     */
    @Excel(name = "保存状况")
    private String preservationStatus;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    public void setIoId(Long ioId) {
        this.ioId = ioId;
    }

    public Long getIoId() {
        return ioId;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setInvestigationShip(String investigationShip) {
        this.investigationShip = investigationShip;
    }

    public String getInvestigationShip() {
        return investigationShip;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setSeaArea(String seaArea) {
        this.seaArea = seaArea;
    }

    public String getSeaArea() {
        return seaArea;
    }

    public void setStandingPosition(String standingPosition) {
        this.standingPosition = standingPosition;
    }

    public String getStandingPosition() {
        return standingPosition;
    }

    public void setxCoordinate(Long xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Long getxCoordinate() {
        return xCoordinate;
    }

    public void setyCoordinate(Long yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Long getyCoordinate() {
        return yCoordinate;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setEndDepth(Long endDepth) {
        this.endDepth = endDepth;
    }

    public Long getEndDepth() {
        return endDepth;
    }

    public void setHeartLength(Long heartLength) {
        this.heartLength = heartLength;
    }

    public Long getHeartLength() {
        return heartLength;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setPreservationStatus(String preservationStatus) {
        this.preservationStatus = preservationStatus;
    }

    public String getPreservationStatus() {
        return preservationStatus;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public Sample(Long ioId, Long number, String sampleNumber, String investigationShip, String voyage, String seaArea, String standingPosition, Long xCoordinate, Long yCoordinate, String detailedAddress, Long endDepth, Long heartLength, String storageLocation, String preservationStatus, String remarks) {
        this.ioId = ioId;
        this.number = number;
        this.sampleNumber = sampleNumber;
        this.investigationShip = investigationShip;
        this.voyage = voyage;
        this.seaArea = seaArea;
        this.standingPosition = standingPosition;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.detailedAddress = detailedAddress;
        this.endDepth = endDepth;
        this.heartLength = heartLength;
        this.storageLocation = storageLocation;
        this.preservationStatus = preservationStatus;
        this.remarks = remarks;
    }

    public Sample(Sample sample) {
        if (sample.getIoId().equals("<null>")) {
            this.sampleNumber = null;
        }
        if (sample.getNumber().equals("<null>")) {
            this.number = null;
        }
        if (sample.getSampleNumber().equals("<null>") || sample.getSampleNumber().isEmpty()) {
            this.sampleNumber = null;
        }
        if (sample.getInvestigationShip().equals("<null>") || sample.getInvestigationShip().isEmpty()) {
            this.investigationShip = null;
        }
        if (sample.getVoyage().equals("<null>") || sample.getVoyage().isEmpty()) {
            this.voyage = null;
        }
        if (sample.getSeaArea().equals("<null>") || sample.getSeaArea().isEmpty()) {
            this.seaArea = null;
        }
        if (sample.getStandingPosition().equals("<null>") || sample.getStandingPosition().isEmpty()) {
            this.standingPosition = null;
        }
        if (sample.getxCoordinate().equals("<null>")) {
            this.xCoordinate = null;
        }
        if (sample.getyCoordinate().equals("<null>")) {
            this.yCoordinate = null;
        }
        if (sample.getDetailedAddress().equals("<null>") || sample.getDetailedAddress().isEmpty()) {
            this.detailedAddress = null;
        }
        if (sample.getEndDepth().equals("<null>")) {
            this.endDepth = null;
        }
        if (sample.getHeartLength().equals("<null>")) {
            this.heartLength = null;
        }
        if (sample.getStorageLocation().equals("<null>") || sample.getStorageLocation().isEmpty()) {
            this.storageLocation = null;
        }
        if (sample.getPreservationStatus().equals("<null>") || sample.getPreservationStatus().isEmpty()) {
            this.preservationStatus = null;
        }
        if (sample.getRemarks().equals("<null>") || sample.getRemarks().isEmpty()) {
            this.remarks = null;
        }
    }

    public Sample() {

    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("ioId", getIoId())
                .append("number", getNumber())
                .append("sampleNumber", getSampleNumber())
                .append("investigationShip", getInvestigationShip())
                .append("voyage", getVoyage())
                .append("seaArea", getSeaArea())
                .append("standingPosition", getStandingPosition())
                .append("xCoordinate", getxCoordinate())
                .append("yCoordinate", getyCoordinate())
                .append("detailedAddress", getDetailedAddress())
                .append("endDepth", getEndDepth())
                .append("heartLength", getHeartLength())
                .append("storageLocation", getStorageLocation())
                .append("preservationStatus", getPreservationStatus())
                .append("remarks", getRemarks())
                .toString();
    }
}
