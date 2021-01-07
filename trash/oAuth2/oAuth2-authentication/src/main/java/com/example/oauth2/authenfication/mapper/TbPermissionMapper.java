package com.example.oauth2.authenfication.mapper;

import com.example.oauth2.authenfication.domain.TbPermission;
import com.example.oauth2.authenfication.domain.TbUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;
import java.util.List;
/**
 * 自己的 Mapper
 * 特别注意，该接口不能被扫描到，否则会出错
 * <p>Title: MyMapper</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/5/29 0:57
 */
public interface TbPermissionMapper<T> extends MyMapper<TbPermission> {
    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}
