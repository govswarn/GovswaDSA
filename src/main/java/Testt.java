import java.util.*;

public class Testt {

    public static void printNamesInSorted(String[] names){
        Arrays.sort(names);
        Map<Character, String> namesMap = new HashMap<>();
        for(int i = 0; i < names.length; i++){
            namesMap.put(names[i].charAt(0), names[i]);
        }
    }
    public static void main(String[] args) {
        String[] names = {"Ramesh","Shyam","Ram","Binod","Sanju","Kumar","Raj"};
        printNamesInSorted(names);
        for(String name : names){
            System.out.print(name + " ");
        }
    }
}

/*
table(employee) with id,name,city.. city name is delhi, mumbai multiple rows..
 if city name is more than 1 then that record needs to be deleted..
 delete from employee where city in (select city from employee groupby city count > 2)
*/