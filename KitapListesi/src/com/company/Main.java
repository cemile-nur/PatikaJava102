package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("Tutunamayanlar","Oğuz Atay",671);
        Book book2 = new Book("Şeker Portakalı","Jose Maura",200);
        Book book3 = new Book("Küçük Prens","Antoine",96);
        Book book4 = new Book("Araba Sevdası","Recaizade Mahmut Ekrem",224);
        Book book5 = new Book("Kürk Mantolu Madonna","Sabahattin Ali",160);
        Book book6 = new Book("Hayvan Çiftliği","George Orwell",152);
        Book book7 = new Book("Araba Sevdası","Recaizade Mahmut Ekrem",294);
        Book book8 = new Book("Beyaz Zambaklar Ülkesinde","Grigory Petrov",208);
        Book book9 = new Book("Satranç","Stefan Zweig",104);
        Book book10 = new Book("Prens","Niccolo Machiavelli",128);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);


        Map<String,String> stringStringMap = new HashMap<>();
        books.stream().forEach(book -> stringStringMap.put(book.getName(),book.getWriter()));

        System.out.println(stringStringMap );

        System.out.println("**************************");

        List<Book> shortBooksList = new ArrayList<>();

        books.stream().filter(book -> book.getPage() > 100).forEach(a -> shortBooksList.add(a));
        System.out.println(shortBooksList);
    }
}
