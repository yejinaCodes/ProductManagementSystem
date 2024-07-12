import java.util.List;

import org.json.simple.JSONObject;





public class Product {

  private int menu;

  private int no;

  private String name;

  private int price;

  private int stock;



  public Product() {}



  public Product(int no, String name, int price, int stock, int menu) {

    this.menu = menu;

    this.no = (Integer) no;

    this.name = name;

    this.price = price;

    this.stock = stock;

  }



//  public Product(int no, String name, int price, int stock){

//    this.no = no;

//    this.name = name;

//    this.price = price;

//    this.stock = stock;

//  }



  public int getMenu() {

    return menu;

  }



  public void setMenu(int menu) {

    this.menu = menu;

  }



  public int getNo() {

    return no;

  }



  public void setNo(int no) {

    this.no = no;

  }



  public String getName() {

    return name;

  }



  public void setName(String name) {

    this.name = name;

  }



  public int getPrice() {

    return price;

  }



  public void setPrice(int price) {

    this.price = price;

  }



  public int getStock() {

    return stock;

  }



  public void setStock(int stock) {

    this.stock = stock;

  }



  //Product를 Jsonobject로 만들기

  public JSONObject string_to_json(Product product){



    JSONObject jsonobj = new JSONObject();

    jsonobj.put("no", product.no);

    jsonobj.put("name", product.name);

    jsonobj.put("price" , product.price);

    jsonobj.put("stock", product.stock);

    jsonobj.put("menu", product.menu);

    return jsonobj;

  }

//  public JSONObject jsonobj_to_product(List<Product> array_list){

//    JSONObject jsonobj = new JSONObject();

//    for(Product p : array_list){

//      jsonobj.put("no", p.no);

//      jsonobj.put("name", p.name);

//      jsonobj.put("price", p.price);

//      jsonobj.put("stock", p.stock);

//    }

//    return jsonobj;

  //}



}

