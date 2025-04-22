package org.epam.dsa.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
@Author amresh ranjan

 */
public class SortMap {
    public static void main(String[] args) {

        // natural way to sort map on basic of key
        // just use treeMap
        Map<String, Integer> studentMap = new HashMap<String, Integer>();

        studentMap.put("Jyous", 87);
        studentMap.put("Klusener", 82);
        studentMap.put("Xiangh", 91);
        studentMap.put("Lisa", 89);
        studentMap.put("Narayan", 95);
        studentMap.put("Arunkumar", 86);
        System.out.println("Before Sorting: ");
        System.out.println(studentMap);
        System.out.println("After Sorting");
        Map<String,Integer> sortedMap=new TreeMap<>(studentMap);
        System.out.println(sortedMap);

        //sort using treeMap but using comparator
        System.out.println("After sorting using comparator");

        Map<String, String> map=new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int diff_length = o1.length() - o2.length();
                if (diff_length != 0) return diff_length;
                return o1.compareTo(o2);
            }
        });
        map.put("IBARAKI", "MitoCity");
        map.put("TOCHIGI", "UtunomiyaCity");
        map.put("GUNMA", "MaehashiCity");
        map.put("SAITAMA", "SaitamaCity");
        map.put("CHIBA", "ChibaCity");
        map.put("TOKYO", "Sinjyuku");
        map.put("KANAGAWA", "YokohamaCity");
        System.out.println(map);

        // sort using sort method.
        Map<String,Integer> map1=new HashMap<>();
        map1.put("amresh",12);
        map1.put("ranjan",6);
        map1.put("kishore",19);
        map1.put("sai",1);
        map1.put("kasif",8);
        System.out.println("After before value sorting");
        System.out.println(map1);

        List<Map.Entry<String,Integer>> list=new ArrayList<>(map1.entrySet());
        //Collections.sort(list,(e1,e2)->Integer.compare(e1.getValue(), e2.getValue()));
        list.sort((e1,e2)->Integer.compare(e1.getValue(), e2.getValue()));

        Map<String,Integer> sortedMap1=new LinkedHashMap<>();
        for(Map.Entry<String,Integer> e1: list){
            sortedMap1.put(e1.getKey(), e1.getValue());
        }
        System.out.println("Sorted Map using collections.sort:"+ sortedMap1);


        // java8 sort on the basic of key
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("amresh", 12);
        map2.put("yash",12);
        map2.put("ranjan", 6);
        map2.put("kishore", 19);
        map2.put("sai", 1);
        map2.put("kasif", 8);

        System.out.println("Unsorted map: " + map2);

        Map<String, Integer> sortedMapByKey = map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
               // .sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey())) // sorting by key
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),        // keyMapper
                        entry -> entry.getValue(),      // valueMapper
                        (oldValue, newValue) -> newValue, // mergeFunction (not really needed here)
                        LinkedHashMap::new              // keep insertion order (sorted)
                ));

        System.out.println("Sorted map by key: " + sortedMapByKey);


        // sorting using values;
        Map<String,Integer> sortedMapByValue=map2.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
               // .sorted((e1,e2)->Integer.compare(e1.getValue(), e2.getValue()))
                .collect(Collectors.toMap(
                        e1->e1.getKey(),
                        e1->e1.getValue(),
                        (oldVal,newVal)-> oldVal,
                        ()-> new LinkedHashMap<>()
                ));
        System.out.println("Sorted map by value:"+ sortedMapByValue);

    }
}
