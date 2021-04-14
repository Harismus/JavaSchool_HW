package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.String;

/**
 * Реализуйте свой Iterator для обхода списка в обратном порядке.
 */
public class Task5 extends AbstractTask {
    public static void Do(String buffer) {
        System.out.println( "================Task5==================" );

        List<String> lines = ArrayCast.from( buffer, "\\n" );

        SOList list = new SOList( lines );

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            System.out.println( "iterator = " + str );
        }

    }
}

class MyIterator implements Iterator<String> {
    private int currentIndex;
    private int currentSize;
    private List<String> arrayList;

    public MyIterator(List<String> newArray) {
        this.currentSize = newArray.size();
        this.currentIndex = newArray.size() - 1;
        arrayList = (List<String>) newArray;
    }


    @Override
    public boolean hasNext() {
        return currentIndex >= 0 && arrayList.get( currentIndex ) != null;
    }

    @Override
    public String next() {
        return arrayList.get(currentIndex >= 0 ? currentIndex-- : currentIndex);
    }

    @Override
    public void remove() {

    }
}


class SOList implements Iterable<String> {

    private List<String> arrayList;
    private MyIterator iterator;

    public SOList(List<String> newArray) {
        this.arrayList = newArray;
        iterator = new MyIterator( newArray );
    }

    @Override
    public Iterator<String> iterator() {
        return (Iterator<String>) iterator;
    }

    boolean add(String string) {
        return arrayList.add( string );
    }
}