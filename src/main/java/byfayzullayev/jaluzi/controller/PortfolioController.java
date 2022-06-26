package byfayzullayev.jaluzi.controller;

import byfayzullayev.jaluzi.entity.portfolio.PortfolioEntity;
import byfayzullayev.jaluzi.model.receive.portfolio.PortfolioReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.service.product.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/yourjaluzi/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    @Autowired
    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;

    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PostMapping("/add")
    public HttpEntity<?> addPortfolio(@RequestBody PortfolioReceiveModel portfolioReceiveModel) {
        return ResponseEntity.ok(portfolioService.addPortfolio(portfolioReceiveModel));
    }

    @CrossOrigin
    @GetMapping("/list")
    public HttpEntity<?> getPortfolioList() {
        return ResponseEntity.ok(portfolioService.getPortfolioList());
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @PutMapping("/edit/{id}")
    public HttpEntity<?> updateCategory(@RequestBody PortfolioEntity portfolioEntity, @PathVariable("id") long id) {
        return ResponseEntity.ok(portfolioService.updatePortfolio(id, portfolioEntity));
    }

    @CrossOrigin
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('SUPER_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public HttpEntity<?> deletePortfolio(@PathVariable long id) {

        ApiResponse delete = portfolioService.deletePortfolio(id);
        return ResponseEntity.ok(delete);
    }
}