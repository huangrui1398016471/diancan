package com.lzyh.diancan.dao;

import com.lzyh.diancan.dto.UserRoleDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangrui
 */
public interface UserRoleDao {

    @Select("SELECT userrole.user_id userId,`user`.account,`user`.`password`,`user`.user_name userName,`user`.head_img hearImg,userrole.role_id roleId,role.role_name roleName FROM of_sys_user user INNER JOIN of_sys_user_role userrole ON `user`.id=userrole.user_id\n" +
            "INNER JOIN of_sys_role role ON role.id=userrole.role_id WHERE `user`.id=#{id}")
   List<UserRoleDto> findUserRoleByUserId (Long id);
}
