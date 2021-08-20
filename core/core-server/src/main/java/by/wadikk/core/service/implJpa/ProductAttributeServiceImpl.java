package by.wadikk.core.service.implJpa;

public class ProductAttributeServiceImpl  {

   /* private ProductAttributeRepository productAttributeRepository;

    @Autowired
    public ProductAttributeServiceImpl(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    @Override
    public boolean create(ProductAttribute productAttribute) {
        if (productAttributeRepository.findById(productAttribute.getId()) == null) {
            productAttributeRepository.save(productAttribute);
            return true;
        }
        return false;
    }

    @Override
    public List<ProductAttribute> readAll() {
        return productAttributeRepository.findAll();
    }

    @Override
    public ProductAttribute read(long id) {
        return productAttributeRepository.getById(id);
    }

    @Override
    public boolean update(ProductAttribute productAttribute, long id) {
        if (productAttributeRepository.getById(id) != null) {
            productAttributeRepository.save(productAttribute);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (productAttributeRepository.findById(id) != null) {
            productAttributeRepository.deleteById(id);
            return true;
        }
        return false;
    }*/
}
