package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.domain.dto.MatterDto;
import com.soft1851.spring.mybatis.domain.entity.Clazz;
import com.soft1851.spring.mybatis.domain.vo.ClazzVo;
import com.soft1851.spring.mybatis.domain.vo.MatterVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {

    /**
     * 获取指定班课中所有学生信息
     *
     * @param clazzId
     * @return List<ClazzVo>
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取值指定班课中所有教师信息
     *
     * @param id
     * @return List<Map < String, Object>>
     */
    List<Map<String, Object>> getClazzStudent1(int id);

    /**
     * 查询某位老师的某个班级上面的某个学生
     *
     * @param matterDto
     * @return MatterVo
     */
    List<MatterVo> selectLimitFromTeacherInClassByDynamicSql(MatterDto matterDto);

    /**
     * 根据 ClazzId 一对多关联查询本班所有学生
     * @param clazzId
     * @return Clazz
     */
    Clazz getClazzOneToMany(int clazzId);
}