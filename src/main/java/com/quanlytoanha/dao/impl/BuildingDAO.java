package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IBuildingDAO;
import com.quanlytoanha.mapper.BuildingMapper;
import com.quanlytoanha.model.BuildingModel;
import com.quanlytoanha.paging.Pageble;

import java.util.List;

public class BuildingDAO extends AbsstractDAO<BuildingModel> implements IBuildingDAO {


    @Override
    public Long save(BuildingModel buildingModel) {
//        String sql = " insert into  building (  name , districtId , ward , street , structure , numberOfBasement , buildingArea ," +
//                " direction , levelBuilding , rentArea , areaDescription , costRent , costDescription , serviceCost , carCost ," +
//                " motorbikeCost , overtimeCost , electricityCost , deposit , payment , timeContract , timeDecorator , managerName ," +
//                " mamagerPhone , commission , note , link , location , imageName , thumbnailBase64 , createdDate , modifiedDate ," +
//                " createdBy , modifiedBy , status  )" +
//                " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )  ";

        String sql = autoWriteInsertSQL("building");

        return insert(sql, buildingModel.getName(), buildingModel.getDistrictId(), buildingModel.getWard(), buildingModel.getStreet(),
                buildingModel.getStructure(), buildingModel.getNumberOfBasement(), buildingModel.getBuildingArea(), buildingModel.getDirection(),
                buildingModel.getLevelBuilding(), buildingModel.getRentArea(), buildingModel.getAreaDescription(),
                buildingModel.getCostRent(), buildingModel.getCostDescription(), buildingModel.getServiceCost(),
                buildingModel.getCarCost(), buildingModel.getMotorbikeCost(), buildingModel.getOvertimeCost(),
                buildingModel.getElectricityCost(), buildingModel.getDeposit(), buildingModel.getPayment(),
                buildingModel.getTimeContract(), buildingModel.getTimeDecorator(), buildingModel.getManagerName(),
                buildingModel.getMamagerPhone(), buildingModel.getCommission(), buildingModel.getNote(), buildingModel.getLink(),
                buildingModel.getLocation(), buildingModel.getImageName(), buildingModel.getThumbnailBase64(),
                buildingModel.getCreatedDate(), buildingModel.getModifiedDate(), buildingModel.getCreatedBy(),
                buildingModel.getModifiedBy(), buildingModel.getStatus());

    }

    @Override
    public void update(BuildingModel buildingModel) {
//        String sql = "update  building set name = ? , districtId = ? , ward = ? , street = ? , structure = ? , numberOfBasement = ? ," +
//                " buildingArea = ? , direction = ? , levelBuilding = ? , rentArea = ? , areaDescription = ? , costRent = ? ," +
//                " costDescription = ? , serviceCost = ? , carCost = ? , motorbikeCost = ? , overtimeCost = ? , electricityCost = ? ," +
//                " deposit = ? , payment = ? , timeContract = ? , timeDecorator = ? , managerName = ? , mamagerPhone = ? , commission = ? ," +
//                " note = ? , link = ? , location = ? , imageName = ? , thumbnailBase64 = ? , createdDate = ? , modifiedDate = ? ," +
//                " createdBy = ? , modifiedBy = ? , status = ?   where buildingId = ? ";

        String sql = autoWriteUpdateSQL("building");


        update(sql, buildingModel.getName(), buildingModel.getDistrictId(), buildingModel.getWard(), buildingModel.getStreet(),
                buildingModel.getStructure(), buildingModel.getNumberOfBasement(), buildingModel.getBuildingArea(), buildingModel.getDirection(),
                buildingModel.getLevelBuilding(), buildingModel.getRentArea(), buildingModel.getAreaDescription(),
                buildingModel.getCostRent(), buildingModel.getCostDescription(), buildingModel.getServiceCost(),
                buildingModel.getCarCost(), buildingModel.getMotorbikeCost(), buildingModel.getOvertimeCost(),
                buildingModel.getElectricityCost(), buildingModel.getDeposit(), buildingModel.getPayment(),
                buildingModel.getTimeContract(), buildingModel.getTimeDecorator(), buildingModel.getManagerName(),
                buildingModel.getMamagerPhone(), buildingModel.getCommission(), buildingModel.getNote(), buildingModel.getLink(),
                buildingModel.getLocation(), buildingModel.getImageName(), buildingModel.getThumbnailBase64(),
                buildingModel.getCreatedDate(), buildingModel.getModifiedDate(), buildingModel.getCreatedBy(),
                buildingModel.getModifiedBy(), buildingModel.getStatus(), buildingModel.getBuildingId());
    }



    @Override
    public void delete(long id) {
        String sql = "DELETE FROM buidingWHERE id = ?";
        update(sql, id);
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from buiding";
        return count(sql);
    }

    @Override
    public BuildingModel findOne(long id) {
        String sql = "select * from buiding where id = " + id;
        return query(sql, new BuildingMapper(), id).get(0);
    }

    @Override
    public List<BuildingModel> findAll(Pageble pageble) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building");
        if (pageble.getSorter() != null) {
            sql.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy() + "");
        }
        if (pageble.getOffset() != null && pageble.getLimit() != null) {
            sql.append(" LIMIT " + pageble.getOffset() + ", " + pageble.getLimit() + "");
        }
        return query(sql.toString(), new BuildingMapper());
    }




}
