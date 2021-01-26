package com.vergilyn.examples.design.tplmethod.algorithm;

import com.alibaba.fastjson.JSON;
import com.vergilyn.examples.design.tplmethod.bean.StudentBean;

/**
 * 模板类
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public abstract class TemplateClass {

    public void saveBefore(StudentBean bean){
        System.out.println(this.getClass().getSimpleName() + ": saveBefore()...");
    }

    public abstract void saveAfter(StudentBean bean);

    /**
     * 模版方法
     */
    public final void saveStudentInfo(StudentBean bean){
        saveBefore(bean);
        // dao.save(bean);// 保存进数据库
        System.out.println(this.getClass().getSimpleName() + ": " + JSON.toJSONString(bean));
        saveAfter(bean);
    }
}
