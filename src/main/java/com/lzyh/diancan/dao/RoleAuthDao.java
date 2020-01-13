package com.lzyh.diancan.dao;

import com.lzyh.diancan.dto.RoleAuthDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author huangrui
 */
public interface RoleAuthDao {

    @Select("SELECT roleauth.role_id roleId,roleauth.auth_id authId,role.role_name roleName,auth.auth_code authCode FROM of_sys_role_auth roleauth INNER JOIN of_sys_role role ON\n" +
            "roleauth.role_id=role.id INNER JOIN of_sys_auth auth ON auth.id=roleauth.auth_id\n" +
            "WHERE role.id=#{id}")
     List<RoleAuthDto> findRoleAuthDtoLisiByRoleId(Long id);
}
