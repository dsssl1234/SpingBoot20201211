package com.example.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.example.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>(); //创建一个部门表

        departments.put(101, new Department(101, "D-AA"));
        departments.put(102, new Department(102, "D-BB"));
        departments.put(103, new Department(103, "D-CC"));
        departments.put(104, new Department(104, "D-DD"));
        departments.put(105, new Department(105, "D-EE"));
    }

    //获得所以的部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }
    //通过id获得部门
    public Department getDepartment(Integer id) {
        return departments.get(id);
    }

}
