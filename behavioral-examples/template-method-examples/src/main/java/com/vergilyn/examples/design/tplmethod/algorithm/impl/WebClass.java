package com.vergilyn.examples.design.tplmethod.algorithm.impl;

import com.vergilyn.examples.design.tplmethod.algorithm.TemplateClass;
import com.vergilyn.examples.design.tplmethod.bean.StudentBean;

/**
 * web登记形式必须登记: 兴趣爱好
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class WebClass extends TemplateClass {
    @Override
    public void saveAfter(StudentBean bean) {
        //any code
    }

    @Override
    public void saveBefore(StudentBean bean) {
        bean.setRegisterType(StudentBean.TYPE_WEB);
        bean.setHobby("吃饭睡觉打豆豆");
    }
}
