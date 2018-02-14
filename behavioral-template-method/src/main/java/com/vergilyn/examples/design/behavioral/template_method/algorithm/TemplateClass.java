package com.vergilyn.examples.design.behavioral.template_method.algorithm;

import com.alibaba.fastjson.JSON;
import com.vergilyn.examples.design.behavioral.template_method.bean.StudentBean;

/**
 * 模板类
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
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
