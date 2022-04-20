package ru.geekbrains.spring_less4_boot.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring_less4_boot.Model.Product;
import ru.geekbrains.spring_less4_boot.Repository.ProductRepository;

@Controller
public class MainController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public String getTest(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("twr", product);
        return "product_page";
    }

    @GetMapping("/product/all")
    public String getTest(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "product_info_page";
    }



    //http://localhost/app/add
    @GetMapping("/add")
    @ResponseBody
    public String add() {
        return "hello";
    }

    //http://localhost/app/sum?param=1&param1=2
    @GetMapping("/sum")
    @ResponseBody
    public int sum(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    //http://localhost/app/test/2
    @GetMapping("/client/{id}/info")
    @ResponseBody
    public String findClientById(@PathVariable Long id) {
        return "Product # " + id;
    }

    @GetMapping("/product/add")
    @ResponseBody
    public void addProduct(Long id, String title, Integer cost) {
        productRepository.add(id, title, cost);
    }

    @GetMapping("/show_page")
    public String form() {
        return "simple_form";
    }


}
