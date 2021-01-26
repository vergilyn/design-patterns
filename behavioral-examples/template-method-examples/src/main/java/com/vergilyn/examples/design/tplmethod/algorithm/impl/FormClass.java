package com.vergilyn.examples.design.tplmethod.algorithm.impl;

import com.vergilyn.examples.design.tplmethod.algorithm.TemplateClass;
import com.vergilyn.examples.design.tplmethod.bean.StudentBean;

/**
 * 填表登记形式必须登记: 出生日期
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class FormClass extends TemplateClass {
    @Override
    public void saveAfter(StudentBean bean) {
        //any code
    }

    @Override
    public void saveBefore(StudentBean bean) {
        bean.setRegisterType(StudentBean.TYPE_FORM);
        bean.setBirthday(20170102L);
    }
}
