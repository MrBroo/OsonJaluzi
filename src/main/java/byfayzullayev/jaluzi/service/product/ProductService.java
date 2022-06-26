package byfayzullayev.jaluzi.service.product;

import byfayzullayev.jaluzi.config.CurrentUser;
import byfayzullayev.jaluzi.entity.product.*;
import byfayzullayev.jaluzi.model.receive.product.ProductReceiveModel;
import byfayzullayev.jaluzi.model.response.ApiResponse;
import byfayzullayev.jaluzi.repository.ProductRepository;
import byfayzullayev.jaluzi.repository.ProductShortRepository;
import byfayzullayev.jaluzi.service.base.BaseService;
import byfayzullayev.jaluzi.service.file.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements BaseService {
    private final ProductRepository productRepository;
    private final CurrentUser currentUser;
    private final ProductShortRepository productShortRepository;
    private final FileService fileService;

    @Autowired
    public ProductService(ProductRepository productRepository, CurrentUser currentUser, ProductShortRepository productShortRepository, FileService fileService) {
        this.productRepository = productRepository;
        this.currentUser = currentUser;
        this.productShortRepository = productShortRepository;
        this.fileService = fileService;

    }

    public ApiResponse addProduct(
            ProductReceiveModel productReceiveModel
    ) {
        String imageUrl = fileService.saveFile(productReceiveModel.getBase64(), productReceiveModel.getContentType());
        if (imageUrl == null)
            return ERROR_FILE_CREATE;

        Optional<ProductShortEntity> optionalProductShortEntity = productShortRepository.findById(productReceiveModel.getProductShortId());
        if (optionalProductShortEntity.isEmpty())
            return ERROR_CATEGORY_NOT_FOUND;

        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductShortEntity(optionalProductShortEntity.get());
        productEntity.setName(productReceiveModel.getName());
        productEntity.setImageUrl(imageUrl);
        productEntity.setPrice(productReceiveModel.getPrice());
        productEntity.setCategory(productReceiveModel.getCategory());
        productEntity.setColor(productReceiveModel.getColor());
        productEntity.setSunProtection(productReceiveModel.getSunProtection());
        productEntity.setAbout(productReceiveModel.getAbout());
        productRepository.save(productEntity);

        return SUCCESS_V2;
    }

    public ApiResponse getProductList() {
        SUCCESS.setData(productRepository.findAll());
        return SUCCESS;
    }

    public ApiResponse getProductList(long id) {
        Optional<ProductShortEntity> optionalProductShortEntity = productShortRepository.findById(id);
        if (optionalProductShortEntity.isEmpty())
            return ERROR_CATEGORY_NOT_FOUND;
        List<ProductEntity> productEntityList = productRepository.findByProductShortEntityId(id);
        SUCCESS.setData(productEntityList);
        return SUCCESS;
    }


    public ApiResponse updateProduct(long id, ProductEntity productEntity) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            ProductEntity updateId = optionalProductEntity.get();
            Optional<ProductEntity> updateProduct = productRepository.findByName(productEntity.getName());

            if (updateProduct.isPresent())
                return USER_EXIST;

            updateId.setName(productEntity.getName());
            productRepository.save(updateId);
        }
        return SUCCESS_V2;
    }

    public ApiResponse deleteProduct(long id) {

        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            productRepository.deleteById(id);

            return SUCCESS_V2;
        }
        return ERROR_DELETE;
    }

}
