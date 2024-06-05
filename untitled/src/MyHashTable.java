public class MyHashTable<K,V> {
    private Entry<K,V>[] table;
    private int size;
    private int capacity;
    public MyHashTable(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.table = new Entry[capacity];
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }
    public void put(K key,V value){
        int index = hash(key);
        Entry<K,V> entry = new Entry<K,V>(key,value);
        if(table[index]==null){
            table[index] = entry;
        }
        else {
            //chaining entries in a linked list
            Entry<K,V> currentEntry = table[index];
            while (currentEntry.next != null && !currentEntry.key.equals(key)){
                currentEntry = currentEntry.next;
            }
            if(currentEntry.key.equals(key)){
                currentEntry.value = value;
            } else {
                currentEntry.next = entry;
            }
        }
        size++;

    }
    public V get(K key){
        int index = hash(key);
        Entry<K,V> currentEntry = table[index];
        while (currentEntry != null){
            if(currentEntry.key.equals(key)){
                return table[index].value;
            }
            currentEntry = currentEntry.next;
        }
        return null;
    }
    public boolean remove(K key){
        int index = hash(key);
        Entry<K,V> entry = table[index];
        Entry<K,V> previous = null;

        while (entry != null){
            if(entry.key.equals(key)){
                if(previous == null){
                    table[index] = entry.next;
                } else {
                    previous.next = entry.next;
                }
                size--;
                return true;
            }
            previous = entry;
            entry = entry.next;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }

}
 class Entry<K,V>{
K key;
V value;
Entry<K,V> next;
public Entry(K key, V value){
    this.key=key;
    this.value=value;
    this.next=null;
}
}
