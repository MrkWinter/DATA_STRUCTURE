package algorithm_imp.common_algo_imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author MrkWinter
 * @version 1.0
 * 5 贪婪算法 (以电台问题为例)
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        //hashMap 中存放电台名k* 电台覆盖范围地区(hashSet)
        HashMap<String, HashSet<String>> hashMap = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("深圳");
        hashSet1.add("天津");
        hashSet1.add("成都");
        hashSet1.add("大连");
        hashSet1.add("杭州");
        hashSet1.add("广州");
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashSet<String> hashSet4 = new HashSet<>();
        HashSet<String> hashSet5 = new HashSet<>();
        hashMap.put("k1", hashSet1);
        hashMap.put("k2", hashSet2);
        hashMap.put("k3", hashSet3);
        hashMap.put("k4", hashSet4);
        hashMap.put("k5", hashSet5);
        //allAreas中存放所有要覆盖的地区
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("深圳");
        allAreas.add("天津");
        allAreas.add("成都");
        allAreas.add("大连");
        allAreas.add("杭州");
        allAreas.add("广州");
        //选择的电台存放的集合
        ArrayList<String> selects = new ArrayList<>();
        //求集areaAll所有地区与一个电台覆盖集合(存入在tempSet中)的交集
        HashSet<String> tempSet = new HashSet<>();
        HashSet<String> tempSet2 = new HashSet<>();
        //覆盖最多地区的电台名
        String maxKey = null;
        //循环遍历hashMap中的所有电台 将太对应的地区存放在tempSet中与存放所有地区的allAreas集合求交集
        //然后重新赋给tempSet 没有轮得到所有电台中可覆盖地区的数量 将较大覆盖地区数量的电台存放在selects中
        //去除allAreas中别覆盖的电台 当其容量为0时找到了可覆盖所有地区的电台集合较优解
        while (allAreas.size() != 0) {
            for (String key : hashMap.keySet()) {
                HashSet<String> areas = hashMap.get(key);
                tempSet.addAll(areas);
                //得到tempSet和allAreas中的交集 赋给tempSet
                tempSet.retainAll(allAreas);
                //拿到最电台的大交集 (如果有)
                if (maxKey != null) {
                    tempSet2.addAll(hashMap.get(maxKey));
                    tempSet2.retainAll(allAreas);
                }
                //如果当前集合包含的未覆盖地区比maxKey指向集合包含的未覆盖的地区要多
                if (tempSet.size() > 0 && tempSet.size() > tempSet2.size())
                    maxKey = key;
            }
            if (maxKey != null) {
                selects.add(maxKey);
                allAreas.removeAll(hashMap.get(maxKey));
            }
            maxKey = null;
            tempSet.clear();
            tempSet2.clear();
        }
        System.out.println(selects);
    }
}
