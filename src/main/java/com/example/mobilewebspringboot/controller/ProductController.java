package com.example.mobilewebspringboot.controller;


import com.example.mobilewebspringboot.entity.Product;
import com.example.mobilewebspringboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value="/productAdd")
    public String productAdd(@RequestParam("product_name") String productName,
    @RequestParam("unit_price") String price, 
    @RequestParam("unit_in_stock") String unitInStock, 
    @RequestParam("product_description") String description, 
    @RequestParam("manufacturer") String manufacturer, 
    @RequestParam("category") String category,
    @RequestParam("inlineRadioOptions") String inlineRadioOptions, 
    @RequestParam("filebutton") String filebutton){
        double productPrice = Double.parseDouble(price);
        int numOfProductInStock = Integer.parseInt(unitInStock);
        int productCondition = Integer.parseInt(inlineRadioOptions);
        Product product = new Product(
                    productName,
                    productPrice,
                    numOfProductInStock,
                    description,
                    manufacturer,
                    category,
                    productCondition,
                    filebutton
                );
        productRepository.save(product);
        return "home.html";
    }

    @RequestMapping(value = "/productView")
    public String productView(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "productView.html";
    }

    @PostMapping(value = "/detail")
    public String detail(@RequestParam("detailId") String id ,Model model){
        Product product = null;
        int ids = Integer.parseInt(id);
        Optional<Product> productOpt  = productRepository.findById(ids);
        if (productOpt.isPresent()) {
            product = productOpt.get();
            model.addAttribute("products", product);
            return "productDetail.html";
        }
        else return "home.html";
    }
}
