import java.io.*;

import java.net.Socket;

import java.util.Scanner;

import org.json.simple.*;

import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;



public class ProductClient {

  //static Socket socket;

  public static int current_no = 1;

  public static String receieved_msg= "";

  public static JSONArray list_server = new JSONArray();

//  static Socket clientSocket() throws IOException {

//    Socket socket;

//    socket = new Socket("localhost", 9999); //상대방 ip와 열린 port 지정해주기

//    return socket;

//  }



  public static void main(String[] args) throws IOException, ParseException {



    boolean flag = true;

    //Socket socket = clientSocket();

    Socket socket = new Socket("localhost", 9999);

    System.out.println(socket);

    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    JSONParser jsonParser = new JSONParser();





    while(flag) {

      //Socket socket = startClient();

      //BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

      //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));





      //String db_products = in.readLine(); //상품 목록 가지고 오기

      //check

      System.out.println("check");

      //received_msg = in.readLine() 이 왜 안됨?



      //get Product object from db

      //receieved_msg = in.readLine();

      //System.out.println("please: " + receieved_msg);

      /*

      if(!receieved_msg.equals("")){

        receieved_msg = in.readLine();

      }*/



      System.out.println("[상품 목록]");

      System.out.println("-------------------------------------------------");

      System.out.println("no \t\t name               price \t\t stock");

      System.out.println("-------------------------------------------------");

      //System.out.println(receieved_msg); //많을 경우 하나씩 프린트해야함

      //System.out.println(list_server);

      for(int i=0; i<list_server.size();i++){

        JSONObject job_tmp = ( JSONObject) list_server.get(i);

        int tmp_no = ((Long) job_tmp.getOrDefault("no", 0)).intValue();

        String tmp_name = (String) job_tmp.getOrDefault("name", "");

        int tmp_price = ((Long) job_tmp.getOrDefault("price", 0 )).intValue();

        int tmp_stock = ((Long) job_tmp.getOrDefault("stock", 0 )).intValue();

        System.out.println(tmp_no + "\t\t\t\t" + tmp_name + "\t\t\t\t\t\t\t" + tmp_price + "\t\t\t\t\t" + tmp_stock);

        //System.out.print(list_server.get(i) + "\n");

      }

      System.out.println();



      System.out.println("-------------------------------------------------");

      System.out.println("메뉴:  1.Create | 2.Update | 3.Delete | 4.Exit");

      System.out.print("선택: ");



      Scanner sc = new Scanner(System.in);

      int menu = sc.nextInt();



      String name;

      int no;

      int price;

      int stock;



      switch(menu) {

        case 1:

          System.out.println("[상품 생성]");

          System.out.print("상품 이름: ");

          name = sc.next();

          System.out.print("상품 가격: ");

          price = sc.nextInt();

          System.out.print("상품 재고: ");

          stock = sc.nextInt();



          Product product1 = new Product();

          product1.setNo(current_no);

          product1.setName(name);

          product1.setPrice(price);

          product1.setStock(stock);

          product1.setMenu(menu);



          JSONObject jsobj1 = product1.string_to_json(product1);

          System.out.println("check1 " + jsobj1);

          System.out.println("check2 " + jsobj1.toJSONString());

          out.write((jsobj1.toJSONString()+ '\n'));

          out.flush();

          current_no++;



          receieved_msg = input.readLine();

          //System.out.println(receieved_msg);

          list_server = (JSONArray) jsonParser.parse(receieved_msg);

          //System.out.println("check3 " + list_server);



          break;



        //상품 수정

        case 2:

          System.out.println("[상품 수정]");

          System.out.print("상품 번호: ");

          no = sc.nextInt();

          System.out.print("이름 변경: ");

          name = sc.next();

          System.out.print("가격 변경: ");

          price = sc.nextInt();

          System.out.print("재고 변경: ");

          stock = sc.nextInt();



          Product product2 = new Product();

          product2.setNo(no);

          product2.setMenu(menu);

          product2.setName(name);

          product2.setPrice(price);

          product2.setStock(stock);



          JSONObject jsobj2 = product2.string_to_json(product2);



          out.write((jsobj2.toJSONString()+ "\n"));

          out.flush();

          current_no++;



          receieved_msg = input.readLine();

          //System.out.println(receieved_msg);

          list_server = (JSONArray) jsonParser.parse(receieved_msg);

          //System.out.println("check3 " + list_server);

          break;



        case 3:

          System.out.println("[상품 삭제]");

          System.out.print("상품 번호: ");

          no = sc.nextInt();



          Product product3 = new Product();

          product3.setNo(no);

          product3.setMenu(3);

          JSONObject jsobj3 = product3.string_to_json(product3);

          out.write((jsobj3.toJSONString()+'\n'));



          out.flush();



          receieved_msg = input.readLine();

          //System.out.println(receieved_msg);

          list_server = (JSONArray) jsonParser.parse(receieved_msg);

          //System.out.println("check3 " + list_server);

          break;



        case 4:

          flag = false;

          System.out.println("프로그램을 종료합니다.");

          socket.close();

          break;

      }

      //receieved_msg = in.readLine();

      //System.out.println(receieved_msg);





      //list_server = in.readLine();

    }





  }

}

