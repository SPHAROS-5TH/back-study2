package com.example.study2.test.repository;

import com.example.study2.test.dto.SearchProductRequestDto;
import com.example.study2.test.entity.Product;
import com.example.study2.test.entity.QProduct;
import com.example.study2.test.entity.QProductOption;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductQueryDslRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;
    private final QProduct product = QProduct.product;
    private final QProductOption productOption = QProductOption.productOption;

    public ProductQueryDslRepository(JPAQueryFactory jpaQueryFactory) {
        super(Product.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Product> searchProduct(SearchProductRequestDto searchProductRequestDto) {

        return jpaQueryFactory.selectFrom(product)
                .leftJoin(productOption).on(productOption.product.eq(product))
                .where(
                        product.name.contains(searchProductRequestDto.getKeyword()),
                        eqCategory(searchProductRequestDto.getCategory()),
                        eqSize(searchProductRequestDto.getSize()),
                        eqColor(searchProductRequestDto.getColor())
                ).fetch();
    }

    public BooleanExpression eqCategory(String category) {
        if(category == null) {
            return null;
        }
        return product.category.eq((category));
    }

    public BooleanExpression eqSize(String size) {
        if(size == null) {
            return null;
        }
        return productOption.size.eq((size));
    }

    public BooleanExpression eqColor(String color) {
        if(color == null) {
            return null;
        }
        return productOption.color.eq((color));
    }



}
