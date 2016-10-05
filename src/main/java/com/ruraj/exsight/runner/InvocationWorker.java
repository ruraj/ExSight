package com.ruraj.exsight.runner;

import com.ruraj.exsight.result.ClassDetail;
import com.ruraj.exsight.result.MethodDetail;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Created by ruraj on 9/29/16.
 */
public class InvocationWorker extends Thread {

  private final Object instance;
  private ClassDetail classDetail;
  private FileWriter fileWriter;

  InvocationWorker(ClassDetail classDetail) throws IllegalAccessException, InstantiationException, IOException {
    super(classDetail.getClazz().getName());
    this.classDetail = classDetail;

    // Let's keep an instance to run the methods on
    // TODO Consider constructors
    this.instance = classDetail.getClazz().newInstance();

    fileWriter = new FileWriter(new File(Runner.LOG_DIR, getName() + "-" + System.currentTimeMillis() + ".log"));
  }

  @Override
  public void run() {
    for (MethodDetail methodDetail : classDetail.getMethodDetails()) {
      Method method = methodDetail.getMethod();

      String methodTitle = method.toString() + System.lineSeparator();
      dualPrint("\n\n" + methodTitle);
      dualPrint(String.format("%" + methodTitle.length() + "s\n", "").replaceAll(" ", "="));
      for (Parameter parameter : method.getParameters()) {
        dualPrint(String.format("%15s\t", parameter.getName()));
      }
      dualPrint(String.format("%20s\n", "Result"));

      for (List<Object> objects : methodDetail.getInputSetListTemp()) {
        Object result = "Not supported";
        try {
          result = method.invoke(instance, objects.toArray());
        } catch (IllegalAccessException e) {
          e.printStackTrace();
        } catch (InvocationTargetException e) {
          // This is the bazinga!
          result = e.getCause().getLocalizedMessage();
        }

        for (Object object : objects) {
          dualPrint(String.format("%15s\t", object));
        }
        dualPrint(String.format("%20s\n", result));
      }
    }
  }

  private void dualPrint(String msg) {
    System.out.print(msg);
    try {
      fileWriter.write(msg);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
