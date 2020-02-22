/*An e-commerce website contains one to many items in each page. To mimic the logic of the website, a
programmer has a list of items and each item is in the form of a string array: [name, relevance, price]. After
sorting the items by (name:0, relevance :1, price:2), the programmer is trying to find out a list of items
displayed in a chosen page.
Given a list of items, the sort column, the sort order (0 : ascending, 1 : descending), the number of items to
be displayed in each page and a page number.
Determine the list of item names in the specified page while respecting the item's order (Page number
starts at 0). */





import java.util.*;
import java.util.stream.Collectors;


class Product {
    private String productName;
    private String relevance;
    private String price;
    Product(String productName, String relevance, String price) {
        this.productName = productName;
        this.relevance = relevance;
        this.price = price;
    }
    public String getProductName() {
        return productName;
    }
    public String getRelevance() {
        return relevance;
    }
    public String getPrice() {
        return price;
    }
}

class ProductResult {

    public static List < String > fetchItemsToDisplay(List < List < String >> items,
        int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        List < Product > itemsList = new ArrayList < Product > ();

        for (List < String > item: items) {
            itemsList.add(new Product(item.get(0), item.get(1), item.get(2)));
        }
        List < String > sortedList = new ArrayList < String > ();
        if (sortParameter == 0) {
            sortedList = itemsList.stream().
            				sorted(Comparator.comparing(Product::getProductName)).
            				map(Product::getProductName).
            				collect(Collectors.toList());
        }
        if (sortParameter == 1) {
            //sort them by relevance
            sortedList = itemsList.stream().
            				sorted(Comparator.comparing(Product::getRelevance)).
            				map(Product::getProductName).
            				collect(Collectors.toList());
        }
        if (sortParameter == 2) {
            sortedList = itemsList.stream().
            				sorted(Comparator.comparing(Product::getPrice)).
            				map(Product::getProductName).
            				collect(Collectors.toList());
        }
        
        if (sortOrder == 1) {
            Collections.reverse(sortedList);
        }

        for (int i = 0; i < sortedList.size(); i++) {

            if (i == pageNumber) {
                return sortedList.subList(i, i + itemPerPage);
            }
        }
        return null;
    }
}

public class EcommPagination {
    public static void main(String args[]) {
        ProductResult rs = new ProductResult();
        List < List < String >> items = new ArrayList < List < String >> ();

        /*List<String> item = new ArrayList<String>();
        item.add("p1");
        item.add("1");
        item.add("2");
		
        List<String> item1 = new ArrayList<String>();
        item1.add("p2");
        item1.add("2");
        item1.add("1");
        items.add(item);
        items.add(item1);
		
        for(String str : rs.fetchItemsToDisplay(items, 0,0, 1, 0)){
        	System.out.println(str);
        }*/

        items.add(new ArrayList < String > (Arrays.asList("owjevtkuyv", "58584272", "62930912")));
        items.add(new ArrayList < String > (Arrays.asList("rpaqgbjxik", "9425650", "96088250")));
        items.add(new ArrayList < String > (Arrays.asList("dfbkasyqcn", "37469674", "46363902")));
        items.add(new ArrayList < String > (Arrays.asList("vjrrisdfxe", "18666489", "88046739")));
        items.add(new ArrayList < String > (Arrays.asList("vjrrisdfxf", "18666490", "88046740")));
        items.add(new ArrayList < String > (Arrays.asList("vjrrisdfxg", "18666491", "88046741")));
        items.add(new ArrayList < String > (Arrays.asList("vjrrisdfxh", "18666492", "88046742")));
        items.add(new ArrayList < String > (Arrays.asList("vjrrisdfxi", "18666493", "88046743")));

        for (String str: rs.fetchItemsToDisplay(items, 2, 0, 2, 0)) {
            System.out.println(str);
        }

    }
}
