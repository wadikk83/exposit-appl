package by.wadikk.core.service.implJpa;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  {
    /*private final ProductRepository productRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ArticleRepository articleRepository) {
        this.productRepository = productRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public boolean create(Product product) {
        if (productRepository.findById(product.getId()) == null) {
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public Product read(long id) {
        return productRepository.getById(id);
    }

    @Override
    public boolean update(Product product, long id) {
        if (productRepository.getById(id) != null) {
            productRepository.save(product);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (productRepository.findById(id) != null) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findByAttributes(Long attributeId) {
        return productRepository.findProductsByProductAttributes(attributeId);
    }

    @Override
    public List<Product> findByCategory(Long CategoryId) {
        return null;
    }

    @Override
    public List<Product> getAllByStoreId(Long storeId) {
        List<Article> articleList = articleRepository.findArticleByStore(storeId);
        return productRepository.findProductByArticleListIn(articleList);
    }*/
}
