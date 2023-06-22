package com.apache.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;


@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer://test-rest-api?period=100")
                .log("Api Hitting....")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("https://fakerapi.it/api/v1/images?_width=380")
                .process(exchange -> {
                    String user = exchange.getIn().getBody(String.class);
                    System.out.println("User :: " + user);
                });
    }
}
//    @Override
//    public void configure() throws Exception {

//        from("timer:myTimer?repeatCount=100")
//                .setHeader("Accept", constant("application/json"))
//                .to("https://fakerapi.it/api/v1/images?_width=380")
//                .convertBodyTo(String.class)
//                .to("direct:insertData");
//
//
//        from("direct:insertData")
//                .to("sql:INSERT INTO camelex (datas) VALUES (#) ?dataSource=jdbc:postgresql://localhost:5432/cameldb")
//                .log("Data inserted successfully");


//   from("timer:first-timer")
//              .transform().constant("My constant value")
//             .to("log:first-timer");



//       restConfiguration()
//              .component("http")
//               .port(443)
//             .scheme("https")


//            .bindingMode(String.valueOf(RestConfiguration.RestBindingMode.auto));

//      rest("/api/v1")
//               .get("https://fakerapi.it/api/v1/images?_width=380")
//            .to("jdbc:postgresql://localhost:5432/cameldb?user=postgres&password=javadevs");

//           .log("Fetched data: ${body}");




//            restConfiguration()
//                    .component("http")
//                    .host("https://fakerapi.it/api/v1/images?_width=380");
//            from("https://fakerapi.it/api/v1/images?_width=380")
//                    .to("rest:get:fakerapi.it/api/v1")
//                    .unmarshal().json()
//                    .log("Fetched data: ${body}");
//        }


//        from("https://fakerapi.it/api/v1/images?_width=380")
//                .unmarshal().json()
//                .to("sql:INSERT INTO camelex (datas) VALUES (#)?dataSource=jdbc:postgresql://localhost:5432/cameldb")
//                .log("Data stored in the database!");

//        from("https://fakerapi.it/api/v1/images?_width=380")
//                .log("${body}")
////                .transform().constant("My constant message")
//                .to("jdbc:postgresql://localhost/cameldb?user=postgres&password=javadevs&ssl=true");






