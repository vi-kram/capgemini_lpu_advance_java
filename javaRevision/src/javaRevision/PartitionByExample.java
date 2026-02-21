package javaRevision;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PartitionByExample {
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("Apple");
		list.add("orange");
		list.add("kiwi");
		list.add("mango");
		Map<Boolean, List<String>> res =list.stream().collect(Collectors.partitioningBy(i->i.length(>=1)));
	}
}
