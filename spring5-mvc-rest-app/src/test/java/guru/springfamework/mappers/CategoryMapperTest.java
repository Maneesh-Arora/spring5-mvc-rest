package guru.springfamework.mappers;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void categoryToCategoryDto() {
        Category category = new Category();
        category.setName("Joe");
        category.setId(2L);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDto(category);

        assertEquals(Long.valueOf(2L),categoryDTO.getId());
        assertEquals("Joe",categoryDTO.getName());

    }
}