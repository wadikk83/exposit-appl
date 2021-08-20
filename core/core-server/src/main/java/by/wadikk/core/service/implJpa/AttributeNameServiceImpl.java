package by.wadikk.core.service.implJpa;

public class AttributeNameServiceImpl  {

   /* private AttributeNameRepository attributeNameRepository;

    @Autowired
    public AttributeNameServiceImpl(AttributeNameRepository attributeNameRepository) {
        this.attributeNameRepository = attributeNameRepository;
    }

    @Override
    public boolean create(AttributeName attributeName) {
        if (attributeNameRepository.findById(attributeName.getId()) == null) {
            attributeNameRepository.save(attributeName);
            return true;
        }
        return false;
    }

    @Override
    public List<AttributeName> readAll() {
        return attributeNameRepository.findAll();
    }

    @Override
    public AttributeName read(long id) {
        return attributeNameRepository.getById(id);
    }

    @Override
    public boolean update(AttributeName attributeName, long id) {
        if (attributeNameRepository.getById(id) != null) {
            attributeNameRepository.save(attributeName);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (attributeNameRepository.findById(id) != null) {
            attributeNameRepository.deleteById(id);
            return true;
        }
        return false;
    }*/
}
