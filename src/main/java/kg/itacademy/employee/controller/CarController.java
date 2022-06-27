package kg.itacademy.employee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kg.itacademy.employee.model.EmployeeApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
public class CarController {

    //    @GetMapping("convert")
//    public ResponseEntity<?> test1() throws JsonProcessingException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Car car = new Car("BMW", 2002L);
//        String jsonConverted = objectMapper.writeValueAsString(car);
//        System.out.println(jsonConverted);
//
//        Car againCar = objectMapper.readValue(jsonConverted, Car.class);
//        System.out.println(againCar);
//
//        return null;
//    }
//
//
//    @Getter
//    @Setter
//    @AllArgsConstructor
//    @ToString
//    class Car {
//        private String name;
//        private Long year;
//
//    }
    @GetMapping
    public ResponseEntity<?> sendGet() {
        try {
            // Создаем объект java.net.URL и туда передаем урл
            URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");
            //Открываем подключение для запроса
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Устанавливаем тип запроса, по умолчанию GET
            con.setRequestMethod("GET");
            //Устаналиваем Хедеры, если нужно.
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            //Отправляем запрос и ждем код ответа
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code: " + responseCode);

            //Если код ответа 200, то значит запрос прошел успешно
            if (responseCode == HttpURLConnection.HTTP_OK) {

                //Считываем байт-код из респонса
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                //Сериализуем байт-код в тип String
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println(response);
                //Закрываем поток подключения
                in.close();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> sendPost() {
        try {
            // Создаем объект java.net.URL и туда передаем урл
            URL url = new URL("https://dummy.restapiexample.com/api/v1/create");
            //Открываем подключение для запроса
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //Устанавливаем тип запроса, по умолчанию GET
            con.setRequestMethod("POST");
            //Устаналиваем Хедеры, если нужно.
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            //Выставляем свойство в true, которое означает что мы собираемся отправить запрос с телом
            con.setDoOutput(true);
            //Получаем объект OutputStream из HttpUrlConnection, для того чтобы в дальнейшем отправить тело запроса
            OutputStream os = con.getOutputStream();
            //Здесь устанавливаем тело запроса в формате JSON, и сериализуем в байт код для передачи
            os.write("{\"username\":\"Adam\"}".getBytes(StandardCharsets.UTF_8));
            //Отправляем запрос и ждем код ответа
            int responseCode = con.getResponseCode();
            System.out.println("POST Response Code: " + responseCode);

            //Если код ответа 200, то значит запрос прошел успешно
            if (responseCode == HttpURLConnection.HTTP_OK) {

                //Считываем байт-код из респонса
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                //Сериализуем байт-код в тип String
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                System.out.println(response);
                //Закрываем поток подключения
                in.close();
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("new")
    public ResponseEntity<EmployeeApiModel> getAllEmployees() {
        return null;
        }
}

