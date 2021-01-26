package com.vergilyn.examples.design.tplmethod.algorithm.impl;

import com.vergilyn.examples.design.tplmethod.algorithm.TemplateClass;
import com.vergilyn.examples.design.tplmethod.bean.StudentBean;

/**
 * app登记形式必须登记: 电话号码
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class AppClass extends TemplateClass {

    @Override
    public void saveAfter(StudentBean bean) {
        //any code
    }

    @Override
    public void saveBefore(StudentBean bean) {
        bean.setRegisterType(StudentBean.TYPE_APP);
        bean.setPhoneNumber("10086");
    }
}
