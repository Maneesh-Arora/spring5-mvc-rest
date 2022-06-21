package guru.springfamework.services;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.mappers.CategoryMapper;
import guru.springfamework.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryMapper categoryMapper,CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDto(categoryRepository.findByName(name));
    }
}
