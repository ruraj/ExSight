package com.ruraj.exsight.runner;

import com.ruraj.exsight.result.ClassDetail;
import com.ruraj.exsight.result.InputSet;
import com.ruraj.exsight.result.MethodDetail;
import com.ruraj.exsight.tool.Combinatorics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by ruraj on 9/22/16.
 */
public class Runner {
  static final Logger LOGGER = LogManager.getLogger("ExSight");
  public static String LOG_DIR = "logs/";

  private Properties configuration;

  private List<ClassDetail> classDetails = new ArrayList<>();

  public void run() {
    LOG_DIR = configuration.containsKey("log.dir") ? configuration.getProperty("log.dir") : LOG_DIR;
    new File(LOG_DIR).mkdir();

    String[] classes = (String[]) configuration.get("classes");

    for (String aClass : classes) {
      try {
        Class clazz = Class.forName(aClass);

        ClassDetail classDetail = parseClass(clazz);

        classDetails.add(classDetail);

        new InvocationWorker(classDetail).start();

        // TODO A better job at handling these operational exceptions
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    }
  }

  public void run(Properties config) {
    this.configuration = config;
    run();
  }

  private ClassDetail parseClass(Class clazz) {
    ClassDetail classDetail = new ClassDetail(clazz);

    for (Method method : clazz.getDeclaredMethods()) {
      MethodDetail methodDetail = parseMethod(method);
      classDetail.addMethodDetail(methodDetail);
    }
    return classDetail;
  }

  private MethodDetail parseMethod(Method method) {
    MethodDetail methodDetail = new MethodDetail(method);

    InputSet inputSet = new InputSet();
    List<List<Object>> lists = new ArrayList<>();

    for (Parameter parameter : method.getParameters()) {
      InputSpace<Object> inputSpace = InputSpace.forParam(parameter);
      if (inputSpace == null) {
        LOGGER.warn("Unsupported parameter " + parameter.getName() + " of type " + parameter.getType().getName());
        continue;
      }

      lists.add(inputSpace.getValues());
    }

    Combinatorics.permute((Combinatorics.CombinationListener) methodDetail::addInputSetTemp, lists);

    return methodDetail;
  }

  public List<ClassDetail> getClassDetails() {
    return classDetails;
  }
}
