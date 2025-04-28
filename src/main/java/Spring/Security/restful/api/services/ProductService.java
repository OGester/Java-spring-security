package Spring.Security.restful.api.services;

import Spring.Security.restful.api.exeptions.ResourceNotFoundException;
import Spring.Security.restful.api.models.Product;
import Spring.Security.restful.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product createProduct(Product product) {
        if(product.getName() == null || product.getName().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty! ");
        }
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // update alternatives both PUT & PATCH

    //PUT
    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());

        return productRepository.save(existingProduct);
    }

    //PATCH
    public Product patchProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        if(product.getName() != null) {
            existingProduct.setName(product.getName());
        }

        if(product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }

        if(product.getDescription() != null) {
            existingProduct.setDescription(product.getDescription());
        }
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

            productRepository.delete(product);
    }
}
