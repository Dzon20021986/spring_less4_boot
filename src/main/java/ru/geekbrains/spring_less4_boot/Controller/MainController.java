package ru.geekbrains.spring_less4_boot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_less4_boot.Model.Product;
import ru.geekbrains.spring_less4_boot.Repository.ProductRepository;
import ru.geekbrains.spring_less4_boot.Service.ProductService;

import java.util.List;

//@Controller
@RestController
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService service;

    @GetMapping("/product/{id}")
    public String getTest(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("twr", product);
        return "product_page";
    }

    @GetMapping("/product/all")
//    @ResponseBody
    public List<Product> getTest() {
        return productRepository.getAllProducts();
    }




    //http://localhost/app/add
    @GetMapping("/add")
//    @ResponseBody
    public String add() {
        return "hello";
    }

    //http://localhost/app/sum?param=1&param1=2
    @GetMapping("/sum")
//    @ResponseBody
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    //http://localhost/app/test/2
    @GetMapping("/product/{id}/info")
//    @ResponseBody
    public String findClientById(@PathVariable Long id) {
        return "Product # " + id;
    }

    @GetMapping("/find")
//    @ResponseBody
    public Product adf(){
        return productRepository.findById(1L);
    }

    @GetMapping("/product/add")
//    @ResponseBody
    public void addProduct(Long id, String title, Integer cost) {
        productRepository.add(id, title, cost);
    }

    @GetMapping("/show_page")
    public String form() {
        return "simple_form";
    }

    @PostMapping("/product/add")
//    @ResponseBody
    public void addProductPost(@RequestBody Product product) {
        productRepository.addProduct(product);
    }
    //559

    @GetMapping("/product/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        service.changeCost(productId, delta);
    }


}
