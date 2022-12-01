package com.example.iti0302backend.repository;

import com.example.iti0302backend.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostCriteriaRepository {

    private final EntityManager entityManager;

    public List<Post> search(PostFilter filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Post> postQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = postQuery.from(Post.class);
        List<Predicate> predicateList = new ArrayList<>();


        if (filter.getHeader() != null) {
            predicateList.add(criteriaBuilder.like(root.get("head"), filter.getHeader() + "%"));
        }

        postQuery.select(root).where(criteriaBuilder.and(predicateList.toArray(predicateList.toArray(new Predicate[0]))));

        if ("ASC".equals(filter.getOrderBy())) {
            postQuery.orderBy(criteriaBuilder.asc(root.get(filter.getOrderBy())));
        } else {
            postQuery.orderBy(criteriaBuilder.desc(root.get(filter.getOrderBy())));
        }

        var entityManagerQuery = entityManager.createQuery(postQuery);
        entityManagerQuery.setFirstResult(filter.getFirstResult());
        entityManagerQuery.setMaxResults(10);

        return entityManagerQuery.getResultList();

    }

}
