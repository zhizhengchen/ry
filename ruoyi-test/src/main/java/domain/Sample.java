package domain;

public class Sample {
    //序号
    private Integer number;
    //样品编号
    private String sampleNumber;
    //调查船
    private String investigationShip;
    //航次
    private String voyage;
    //海域
    private String seaArea;
    //站位
    private String standingPosition;
    //X坐标
    private Float xCoordinate;
    //Y坐标
    private Float yCoordinate;
    //详细地址
    private String detailedAddress;
    //结束深度
    private Float endDepth;
    //心长
    private Float heartLength;
    //存放位置
    private String storageLocation;
    //保存状况
    private String preservationStatus;
    //备注
    private String remarks;

    public Sample() {

    }

    public Sample(Integer number, String sampleNumber, String investigationShip, String voyage, String seaArea, String standingPosition, Float xCoordinate, Float yCoordinate, String detailedAddress, Float endDepth, Float heartLength, String storageLocation, String preservationStatus, String remarks) {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getInvestigationShip() {
        return investigationShip;
    }

    public void setInvestigationShip(String investigationShip) {
        this.investigationShip = investigationShip;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getSeaArea() {
        return seaArea;
    }

    public void setSeaArea(String seaArea) {
        this.seaArea = seaArea;
    }

    public String getStandingPosition() {
        return standingPosition;
    }

    public void setStandingPosition(String standingPosition) {
        this.standingPosition = standingPosition;
    }

    public Float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Float getEndDepth() {
        return endDepth;
    }

    public void setEndDepth(Float endDepth) {
        this.endDepth = endDepth;
    }

    public Float getHeartLength() {
        return heartLength;
    }

    public void setHeartLength(Float heartLength) {
        this.heartLength = heartLength;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getPreservationStatus() {
        return preservationStatus;
    }

    public void setPreservationStatus(String preservationStatus) {
        this.preservationStatus = preservationStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
