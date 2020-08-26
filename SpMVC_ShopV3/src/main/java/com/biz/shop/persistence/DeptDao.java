
package com.biz.shop.persistence;

import com.biz.shop.model.DeptVO;
import org.apache.ibatis.annotations.Select;

public interface DeptDao extends GenericDao<DeptVO, String> {

    @Select(" SELECT MAX(d_code) FROM tbl_dept ")
    public String maxDCode();
}