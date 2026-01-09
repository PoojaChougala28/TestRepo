package EcommerceAPIEndpoint;


import POJO_Class.Login;
import POJO_Class.LoginResponse;
import POJO_Class.Order_details;
import POJO_Class.Orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import  io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
public class EcommerceDemo {
    public static void main(String[] args) {
        //LoginEndpoint
        RequestSpecification request=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .setContentType(ContentType.JSON).build();
        Login login=new Login();
        login.setUserEmail("Aava@gmail.com");
        login.setUserPassword("Test@123");
        RequestSpecification log_req=given().spec(request).contentType("application/json")
                .body(login).log().all();
        LoginResponse login_res=log_req.when().post("/api/ecom/auth/login")
                .then().extract().response().as(LoginResponse.class);
        String token=login_res.getToken();
        String user_id=login_res.getUserId();
        System.out.println("Token is:"+token);
        System.out.println("User id:"+ user_id);
    //CreateProduct
        RequestSpecification prod_req=new RequestSpecBuilder()
                .setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token).build();

        RequestSpecification product_req=given().spec(prod_req)
                .param("productName", "LenevoLaptop")
                .param("productAddedBy",user_id)
                .param("productCategory","Gadget")
                .param("productSubCategory","Laptop")
                .param("productPrice","50000")
                .param("productDescription","LenovoLaptop8gb ram 516 internl")
                .param("productFor","All")
                .multiPart("productImage",new File("C:/Users/Admin/Pictures/images.jpg/"));
       String product_resp=product_req.when().post("/api/ecom/product/add-product").
                then().log().all().extract().response().asString();
        JsonPath js=new JsonPath(product_resp);
        String prod_id=js.get("productId");
        System.out.println("Product id is:"+prod_id);
        // OrderProduct
        RequestSpecification order_spec =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("Authorization",token)
                .setContentType(ContentType.JSON).build();
        Order_details order_details=new Order_details();
        order_details.setCountry("India");
        order_details.setProductOrderedId(prod_id);
        List<Order_details> orderList=new ArrayList<Order_details>();
        orderList.add(order_details);
        Orders order=new Orders();
        order.setOrders(orderList);
        RequestSpecification order_req=given().log().all().spec(order_spec)
                .body(order);
        String order_res=order_req.when().post("/api/ecom/order/create-order")
                .then().log().all().extract().response().asString();
        System.out.println(order_res);
        //Delete product
        RequestSpecification order_delete=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addHeader("authorization",token).setContentType(ContentType.JSON).build();
        RequestSpecification del_order=given().log().all().spec(order_delete).pathParam("productId",prod_id);
        String del_response=del_order.when().delete("/api/ecom/product/delete-product/{productId}")
                .then().log().all().extract().response().asString();
        JsonPath js1=new JsonPath(del_response);
        Assert.assertEquals("Product Deleted Successfully",js1.get("message"));
    }
}
