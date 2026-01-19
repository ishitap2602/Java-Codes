package com.example.rbacdemo.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import com.example.rbacdemo.product.Product;
import com.example.rbacdemo.product.ProductRepository;

import java.util.Optional;

@Controller
@EnableMethodSecurity
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // View list (USER/MANAGER/ADMIN)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", repo.findAll());
        return "products/list";
    }

    // Show create form (MANAGER/ADMIN)
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "products/form";
    }

    // Create (MANAGER/ADMIN)
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    @PostMapping
    public String create(@Valid @ModelAttribute("product") Product p, BindingResult result) {
        if (result.hasErrors()) return "products/form";
        repo.save(p);
        return "redirect:/products";
    }

    // Show edit form (MANAGER/ADMIN)
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Optional<Product> p = repo.findById(id);
        if (p.isEmpty()) return "redirect:/products";
        model.addAttribute("product", p.get());
        return "products/form";
    }

    // Update (MANAGER/ADMIN)
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN')")
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute("product") Product p, BindingResult result) {
        if (result.hasErrors()) return "products/form";
        p.setId(id);
        repo.save(p);
        return "redirect:/products";
    }

    // Delete (ADMIN only)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/products";
    }
}
