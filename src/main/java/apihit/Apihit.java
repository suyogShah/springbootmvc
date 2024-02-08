package apihit;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Employee;

@RestController
public class Apihit {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "url")
   public String getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<String> entity = new HttpEntity<String>(headers);
      return restTemplate.exchange(
         "end point api  url", HttpMethod.GET, entity, String.class).getBody();
   }
   @RequestMapping(value = "url")
   public String saveProducts(@RequestBody Employee emp) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Employee> entity = new HttpEntity<Employee>(emp,headers);
      
      return restTemplate.exchange(
         "end point api url ", HttpMethod.POST, entity, String.class).getBody();
   }
   @RequestMapping(value = "url")
   public String updateProduct(@PathVariable("id") String id, @RequestBody Employee Emp) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Employee> entity = new HttpEntity<Employee>(Emp,headers);
      
      return restTemplate.exchange(
         "end point url api "+id, HttpMethod.PUT, entity, String.class).getBody();
   }
   @RequestMapping(value = "url")
   public String deleteProduct(@PathVariable("id") String id) {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
      
      return restTemplate.exchange(
         "end point url api "+id, HttpMethod.DELETE, entity, String.class).getBody();
   }
}
