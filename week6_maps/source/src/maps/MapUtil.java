package maps;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapUtil {

	public static <K, V extends Comparable<? super V>> List<Entry<K, V>> sortByValue(Map<K, V> map) {

		List<Entry<K, V>> list = new LinkedList<Entry<K, V>>(map.entrySet());
		Collections.sort(list, new EntryValueComparator<K, V>());
		return list;
	}

	private static class EntryValueComparator<K, V extends Comparable<? super V>> implements Comparator<Entry<K, V>> {

		@Override
		public int compare(Entry<K, V> o1, Entry<K, V> o2) {

			return (o2.getValue()).compareTo(o1.getValue());
		}
	}
}