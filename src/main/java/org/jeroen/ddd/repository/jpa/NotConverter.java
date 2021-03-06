package org.jeroen.ddd.repository.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.jeroen.ddd.specification.NotSpecification;

public class NotConverter implements SpecificationConverter<NotSpecification<Object>, Object> {
    private final SpecificationTranslator translator;

    public NotConverter(SpecificationTranslator translator) {
        super();
        this.translator = translator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Predicate convertToPredicate(NotSpecification<Object> not, Root<Object> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
        return cb.not(translator.translateToPredicate(not.getProposition(), root, cq, cb));
    }

}
