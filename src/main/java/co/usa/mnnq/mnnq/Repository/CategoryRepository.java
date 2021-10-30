package co.usa.mnnq.mnnq.Repository;

import co.usa.mnnq.mnnq.Model.Category;
import co.usa.mnnq.mnnq.Repository.Crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author mnnq
 */
@Repository
public class CategoryRepository {

    @Autowired

    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c){
        return categoryCrudRepository.save(c);
    }
    public void delete(Category c){
        categoryCrudRepository.delete(c);
    }
}
