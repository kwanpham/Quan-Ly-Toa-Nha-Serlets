package com.quanlytoanha.dao.impl;

import com.quanlytoanha.dao.IRoleDAO;
import com.quanlytoanha.model.RoleModel;


import java.util.List;


public class RoleDAO extends AbsstractDAO<RoleModel> implements IRoleDAO {



    @Override
    public RoleModel findOne(Long id) {
        String sql = "SELECT * FROM user WHERE id = ?";
        List<RoleModel> role = query(sql, RoleModel.class, id);
        return role.isEmpty() ? null : role.get(0);
    }



    @Override
    public Long save(RoleModel roleModel) {
        String sql = autoWriteInsertSQL("role");
        return insert(sql , roleModel);

    }

    @Override
    public void update(RoleModel roleModel) {
        String sql = autoWriteUpdateSQL("role");
        update(sql, roleModel);
    }

    @Override
    public void delete(long id) {
        String sql = "delete from role where roleId = ?" ;
        delete(sql , id);
    }

    @Override
    public List<RoleModel> findAll() {
        String sql = "select *from role";
        List<RoleModel> list = query(sql , RoleModel.class);
        return list;
    }

    @Override
    public int getTotalItem() {
        String sql = "select count(*) from role";
        return count(sql);
    }
}
