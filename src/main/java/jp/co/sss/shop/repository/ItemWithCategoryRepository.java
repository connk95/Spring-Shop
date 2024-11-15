package jp.co.sss.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;

public interface ItemWithCategoryRepository
		extends JpaRepository<ItemWithCategory, Integer> {

	List<ItemWithCategory> findByCategory(Category category);

	@Query("SELECT i FROM ItemWithCategory i WHERE i.id = :id")
	public List<ItemWithCategory> findByIdQuery(@Param("id") Integer id);

	@Query("SELECT i FROM ItemWithCategory i WHERE i.price >= (SELECT AVG(i2.price) FROM ItemWithCategory i2)")
	public List<ItemWithCategory> findByPriceGreaterThanEqualAVGPriceQuery();

}