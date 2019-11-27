package org.wanjune.azure.keyvault.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.wanjune.azure.keyvault.domain.DemoDomain;

import java.util.List;

@Mapper
public interface DemoMapper {
    @Select("SELECT 'F' AS Sex, 'UNIONID00019' AS UserID, 1299 AS Points UNION SELECT 'M' AS Sex, 'UNIONID00020' AS UserID, 1100 AS Points ")
    List<DemoDomain> selectAll();
}
