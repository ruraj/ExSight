package com.ruraj.exsight.runner;

import java.lang.reflect.Parameter;
import java.util.*;

/**
 * Created by ruraj on 9/22/16.
 */
public class InputSpace<T> {

  private Class clazz;
  private List<T> values = new ArrayList<>();

  private static Map<Class, InputSpace> inputSpaceMap = new HashMap<Class, InputSpace>() {{
    put(int.class, new InputSpace<>(-1, 0, Integer.MAX_VALUE));
    put(String.class, new InputSpace<>("", null, "STRING", "string"));
    put(boolean.class, new InputSpace<>(true, false));
  }};

  static InputSpace forParam(Parameter parameter) {
    return inputSpaceMap.get(parameter.getType());
  }

  @SafeVarargs
  private InputSpace(T ... objs) {
    Collections.addAll(values, objs);
  }

  List<T> getValues() {
    return values;
  }
}
