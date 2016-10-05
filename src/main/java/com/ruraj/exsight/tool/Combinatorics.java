package com.ruraj.exsight.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruraj on 9/29/16.
 */
public class Combinatorics {

  public interface CombinationListener {
    void onCombinationCreated(List<Object> result);
  }

  public static void permute(CombinationListener listener, List<List<Object>> objects) {
    permuteImpl(new ArrayList<>(), listener, objects);
  }

  private static void permuteImpl(List<Object> result, CombinationListener listener, List<List<Object>> objects) {
    if (objects.size() == 0) {
      return;
    }

    for (Object e : objects.get(0)) {
      // Create a new List to build this combination
      ArrayList<Object> temp = new ArrayList<>(result);
      // Add this element to the combination
      temp.add(e);
      // If there are more lists recurse down
      if (objects.size() > 1) {
        // Use recursion to add all combinations of the remaining lists
        permuteImpl(temp, listener, objects.subList(1, objects.size()));
      } else {
        // There are no more lists so we are done, add temp to the combos
        listener.onCombinationCreated(temp);
      }
    }
  }
}
