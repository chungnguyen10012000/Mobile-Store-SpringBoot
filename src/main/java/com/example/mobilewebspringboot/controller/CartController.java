package com.example.mobilewebspringboot.controller;

import com.example.mobilewebspringboot.entity.Cart;
import com.example.mobilewebspringboot.entity.Product;
import com.example.mobilewebspringboot.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    private List<Cart> cart = new ArrayList<Cart>();
    @Autowired
    private ProductRepository productRepository;
    
    @RequestMapping(value = "/cartView")
    public String viewCart(Model model){
        model.addAttribute("cartList", cart);
        model.addAttribute("grandTotal", totalPrice(cart));
        return "cart.html";
    }

    @PostMapping(value = "/addToCart")
    public String addProductToCart(@RequestParam("id") String ids, Model model){
        Product product = null;
        int pId= Integer.parseInt(ids);
        Optional<Product> productOpt  = productRepository.findById(pId);
        if (productOpt.isPresent()) {
            product = productOpt.get();
            addToCart(product);
        }
        model.addAttribute("cartList", cart);
        model.addAttribute("grandTotal", totalPrice(cart));
        return "cart.html";
    }

    @PostMapping(value = "/orderNow")
    public String orderNow(@RequestParam("id") String ids, Model model){
        Product product = null;
        int pId= Integer.parseInt(ids);
        Optional<Product> productOpt  = productRepository.findById(pId);
        if (productOpt.isPresent()) {
            product = productOpt.get();
            addToCart(product);
        }
        model.addAttribute("cartList", cart);
        model.addAttribute("grandTotal", totalPrice(cart));
        return "cart.html";
    }


    @PostMapping(value = "/clearCart")
    public String clearCart(Model model){
        cart.clear();
        model.addAttribute("grandTotal", 0.0);
        return "cart.html";
    }

    @PostMapping(value = "/deleteCart")
    public String deleteCart(@RequestParam("id") String ids, Model model){
        Product product = null;
        int pId= Integer.parseInt(ids);
        Optional<Product> productOpt  = productRepository.findById(pId);
        if (productOpt.isPresent()) {
            product = productOpt.get();
            removeFromCart(product);
        }
        model.addAttribute("cartList", cart);
        model.addAttribute("grandTotal", totalPrice(cart));
        return "cart.html";
    }


    @RequestMapping(value = "/checkOut")
    public String checkOut(){
        cart.clear();
        return "home.html";
    }


    public void addToCart(Product p) {
		for (Cart item : cart) {
			if (item.getP().getProductId() == p.getProductId()) {
				item.setQuantity(item.getQuantity() + 1);
				return;
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(1);
		cart.add(c);
	}

    public void removeFromCart(Product p) {
		for (Cart item : cart) {
			if (item.getP().getProductId() == p.getProductId()) {
				cart.remove(item);
				return ;
			}
		}
	}

    public double totalPrice(List<Cart> cart){
        double total = 0;
        if (cart != null) {
            for (Cart c : cart) {
                total = total + (c.getQuantity() * c.getP().getProductPrice());
            }
        }
        return total;
    }

}
