package com.ruraj.exsight.test;

import com.ruraj.exsight.result.ClassDetail;
import com.ruraj.exsight.result.MethodDetail;
import com.ruraj.exsight.runner.Runner;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by ruraj on 9/22/16.
 */
public class ReflectionTest {

  @Test
  public void testReflection() {

    Properties properties = new Properties();
    properties.put("classes", new String[] {"com.ruraj.exsight.test.ReflectionTestSubject"});

    Runner runner = new Runner();
    runner.run(properties);

    ClassDetail classDetail = runner.getClassDetails().get(0);

    Assert.assertEquals("Not the right method count", 4, classDetail.getMethodDetails().size());
  }
}
