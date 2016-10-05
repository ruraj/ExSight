package com.ruraj.exsight.test;

import com.ruraj.exsight.tool.Combinatorics;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ruraj on 9/29/16.
 */
public class CombinatoricsTest {

  @Test
  public void permutationTest() {
    List<Object> ints = Arrays.asList(1, 2);
    List<Object> strings = Arrays.asList("1");
    List<Object> booleans = Arrays.asList(true, false);

    List<List<Object>> lists = new ArrayList<List<Object>>() {{
      add(ints);
      add(strings);
      add(booleans);
    }};

    List<List<Object>> supposedResult = new ArrayList<>();
    supposedResult.add(new ArrayList<Object>() {{
      add(1);
      add("1");
      add(true);
    }});
    supposedResult.add(new ArrayList<Object>() {{
      add(1);
      add("1");
      add(false);
    }});
    supposedResult.add(new ArrayList<Object>() {{
      add(2);
      add("1");
      add(true);
    }});
    supposedResult.add(new ArrayList<Object>() {{
      add(2);
      add("1");
      add(false);
    }});

    List<List<Object>> actualResult = new ArrayList<>();

    Combinatorics.permute(actualResult::add, lists);

    for (int i = 0; i < actualResult.size(); i++) {
      System.out.println(Arrays.toString(actualResult.get(i).toArray()));
      Assert.assertTrue(
            "Failed to match first permutation",
            Arrays.equals(supposedResult.get(i).toArray(), actualResult.get(i).toArray()));
    }
  }
}
