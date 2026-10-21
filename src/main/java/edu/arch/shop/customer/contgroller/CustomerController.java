package edu.arch.shop.customer.contgroller;

import edu.arch.shop.order.dto.OrderRequest;
import edu.arch.shop.order.dto.OrderResponse;
import edu.arch.shop.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerController {

    private final CustomerService CustomerService;

    public CustomerController(OrderService orderService) {
        this.CustomerService = orderService;
    }

    @GetMapping
    public List<OrderResponse> findAll() {
        return CustomerService.findAll();
    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable Long id) {
        return CustomerService.findById(id);
    }

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request) {
        OrderResponse response = CustomerService.create(request);
        return ResponseEntity.created(URI.create("/orders/" + response.id())).body(response);
    }

    @PutMapping("/{id}")
    public OrderResponse update(@PathVariable Long id, @RequestBody OrderRequest request) {
        return CustomerService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        CustomerService.delete(id);
    }
}
