package by.wadikk.core.service.implJpa;

public class CategoryServiceImpl  {

   /* private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean create(Category category) {
        if (categoryRepository.findById(category.getId()) == null) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> readAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category read(long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public boolean update(Category category, long id) {
        if (categoryRepository.getById(id) != null) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (categoryRepository.findById(id) != null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }*/
}
