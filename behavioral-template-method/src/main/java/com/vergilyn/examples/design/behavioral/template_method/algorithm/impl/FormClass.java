package com.vergilyn.examples.design.behavioral.template_method.algorithm.impl;

import com.vergilyn.examples.design.behavioral.template_method.algorithm.TemplateClass;
import com.vergilyn.examples.design.behavioral.template_method.bean.StudentBean;

/**
 * 填表登记形式必须登记: 出生日期
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/p/6243626.html
 * @date 2017/1/2
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
