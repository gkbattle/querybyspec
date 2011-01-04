package org.jeroen.ddd.repository.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jeroen.ddd.specification.OrSpecification;


public class OrConverter implements SpecificationConverter<OrSpecification<Object>, Object> {
    private final SpecificationTranslator translator;

    public OrConverter(SpecificationTranslator translator) {
        super();
        this.translator = translator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate convert(OrSpecification<Object> spec, Root<Object> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        Predicate lhsPredicate = translator.translateToPredicate(spec.getLhs(), root, cq, cb);
        Predicate rhsPredicate = translator.translateToPredicate(spec.getRhs(), root, cq, cb);
        return cb.or(lhsPredicate, rhsPredicate);
    }

}